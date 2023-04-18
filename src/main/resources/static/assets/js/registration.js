var app = angular.module('myApp',[]);

app.controller('account-ctrl', function($scope, $http) {
	$scope.form = {};
	$scope.items = []; //Thêm dòng này để khởi tạo mảng items

	//Thêm mới account
	$scope.create = function() {
		//Lấy dữ liệu từ form
		var item = angular.copy($scope.form);

		//Post dữ liệu lên
		$http.post(`/rest/registration`, item).then(resp => {

			//bỏ vào list account
			$scope.items.push(resp.data);

			Swal.fire(
				'Thành công',
				'Đăng kí tài khoản thành công ',
				'success'
			)
			//reset form

		}).catch(error => {
			Swal.fire(
				'Opps...!',
				'Đăng kí tài khoản thất bại ',
				'error'
			)
			console.log("Error", error);
		})
	}
});