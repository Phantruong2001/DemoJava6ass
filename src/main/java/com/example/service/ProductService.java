package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.example.entity.Product;

public interface ProductService {

	List<Product> findByNameContaining(String name);

	void delete(Integer id);

	Product update(Product product);

	Product create(Product product);

	<S extends Product> List<S> findAll(Example<S> example, Sort sort);

	<S extends Product> List<S> findAll(Example<S> example);

	void deleteAll();

	Product getReferenceById(Integer id);

	void deleteAll(Iterable<? extends Product> entities);

	void deleteAllById(Iterable<? extends Integer> ids);

	Product getById(Integer id);

	void delete(Product entity);

	Product getOne(Integer id);

	void deleteById(Integer id);

	void deleteAllInBatch();

	long count();

	<S extends Product, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void deleteAllByIdInBatch(Iterable<Integer> ids);

	<S extends Product> boolean exists(Example<S> example);

	void deleteAllInBatch(Iterable<Product> entities);

	<S extends Product> long count(Example<S> example);

	boolean existsById(Integer id);

	void deleteInBatch(Iterable<Product> entities);

	Optional<Product> findById(Integer id);

	<S extends Product> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Product> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends Product> S saveAndFlush(S entity);

	void flush();

	<S extends Product> List<S> saveAll(Iterable<S> entities);

	List<Product> findAllById(Iterable<Integer> ids);

	List<Product> findAll(Sort sort);

	Page<Product> findAll(Pageable pageable);

	List<Product> findAll();

	<S extends Product> Optional<S> findOne(Example<S> example);

	<S extends Product> S save(S entity);

	List<Product> findByCategoryId(Optional<String> id);

	
	
}
