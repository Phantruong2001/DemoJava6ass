package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Account;
@Repository
public interface AccountRepository extends JpaRepository<Account, String>{
	//lấy ra acccount có vai trò dire and staff 
		@Query("SELECT DISTINCT ar.account FROM Authority ar WHERE ar.role.id IN('DIRE','STAF')")
		List<Account> getAdministrators();
		
}
