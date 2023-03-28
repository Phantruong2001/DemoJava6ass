package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.example.entity.Role;

public interface RoleService {

	<S extends Role> List<S> findAll(Example<S> example, Sort sort);

	<S extends Role> List<S> findAll(Example<S> example);

	void deleteAll();

	Role getReferenceById(String id);

	void deleteAll(Iterable<? extends Role> entities);

	void deleteAllById(Iterable<? extends String> ids);

	Role getById(String id);

	void delete(Role entity);

	Role getOne(String id);

	void deleteById(String id);

	void deleteAllInBatch();

	long count();

	<S extends Role, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void deleteAllByIdInBatch(Iterable<String> ids);

	<S extends Role> boolean exists(Example<S> example);

	void deleteAllInBatch(Iterable<Role> entities);

	<S extends Role> long count(Example<S> example);

	boolean existsById(String id);

	void deleteInBatch(Iterable<Role> entities);

	Optional<Role> findById(String id);

	<S extends Role> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Role> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends Role> S saveAndFlush(S entity);

	void flush();

	<S extends Role> List<S> saveAll(Iterable<S> entities);

	List<Role> findAllById(Iterable<String> ids);

	List<Role> findAll(Sort sort);

	Page<Role> findAll(Pageable pageable);

	List<Role> findAll();

	<S extends Role> Optional<S> findOne(Example<S> example);

	<S extends Role> S save(S entity);

}
