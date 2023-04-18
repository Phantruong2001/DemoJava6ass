package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	List<Product> findByCategoryId(Optional<String> id);

	List<Product> findByNameContaining(String name);
	
	Page<Product> findAll(Pageable pageable);
}
