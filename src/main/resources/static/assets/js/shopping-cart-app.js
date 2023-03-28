const app = angular.module("shopping-cart-app", []);

app.controller("shopping-cart-ctrl", function($scope, $http) {


	// quản lý giỏ hàng
	$scope.cart = {
		items: [],

		// thêm sản phẩm vào giỏ hàng
		add(id) {
			//tìm xem có mặt hàng nào có ID này chưa
			var item = this.items.find(item => item.id == id);
			//Có
			if (item) {
				//Tăng số lượng lên và lưu vào local
				item.qty++;
				this.saveToLocalStorage();

				Swal.fire({
					title: 'Sản phẩm đã có trong giỏ hàng',
					text: 'Đã tăng số lượng sản phẩm của bạn lên',
					icon: 'info',
					timer: 2000
				})
			}
			//chưa có
			else {

				Swal.fire({
					titile: 'Thành công',
					text: 'Đã thêm sản phẩm vào giỏ hàng !',
					icon: 'success',
					timer: 1100
				}

				)

				//tải sản phẩm trên server thông qua API
				$http.get(`/rest/products/${id}`).then(resp => {

					//đặt số lượng = 1
					resp.data.qty = 1;

					//Bỏ vào danh sách các mặt hàng đã chọn
					this.items.push(resp.data);

					//lưu vào local
					this.saveToLocalStorage();
					console.log(resp);
				})
			}
		},

		//tính tổng số lượng các mặt hàng trong giỏ
		get count() {
			return this.items
				.map(item => item.qty)
				.reduce((total, qty) => total += qty, 0);
		},

		// tính tổng thành tiền các mặt hàng có trong giỏ
		get amount() {
			return this.items
				.map(item => item.qty * item.price)
				.reduce((total, qty) => total += qty, 0);
		},

		// xóa sản phẩm khỏi giỏ hàng
		remove(id) {
			// tìm vị trí sản phẩm nằm trong giỏ hàng thông qua id
			var index = this.items.findIndex(item => item.id == id);
			this.items.splice(index, 1);
			this.saveToLocalStorage();
		},

		// xóa sạch các mặt hàng trong giỏ
		clear() {
			// cho mảng rỗng
			this.items = []
			// lưu lại vào local
			this.saveToLocalStorage();
		},
		//Lưu giỏ hàng vào local storage
		saveToLocalStorage() {

			//đổi ds các mặt hàng sang file json
			var json = JSON.stringify(angular.copy(this.items));

			//lưu vào local
			localStorage.setItem("cart", json);
		},

		// đọc giỏ hàng từ local storage
		loadFormLocalStorage() {
			// đọc 
			var json = localStorage.getItem("cart");
			// nếu có thì chuyển thành json và gán vào items, ngược lại thì gán cho nó mảng rỗng
			this.items = json ? JSON.parse(json) : [];
		}

	}
	// tải lại toàn bộ mặt hàng đã lưu trong local storage để hiển thị lên form
	$scope.cart.loadFormLocalStorage();

	$scope.order = {
		createDate: new Date(),
		address: "",

		// lấy username
		account: { username: $("#username").text()},
		// lấy toàn bộ thông tin đơn hàng
		get orderDetails() {
			return $scope.cart.items.map(item => {
				return {
					product: { id: item.id },
					price: item.price,
					quantity: item.qty
				}
			});
		},

		 purchase() {
            var order = angular.copy(this);

            //Thực hiện đặt hàng
            $http.post("/rest/orders", order).then(resp => {
                alert("Đặt hàng thành công");

                //xóa sạch giỏ hàng
                $scope.cart.clear();

                //Chuyển trang chi tiết đơn hàng
                location.href = "/order/detail/" + resp.data.id
            }).catch(error => {
                Swal.fire(
                    'Thất bại',
                    'Đặt hàng thất bại !',
                    'error'
                )
                console.log(error)
            })
        },
		
		success() {
			location.href = "/product/list/"
		}
	}


})