package com.example.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.example.entity.Role;
import com.example.repository.RoleRepository;
import com.example.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public <S extends Role> S save(S entity) {
		return roleRepository.save(entity);
	}

	@Override
	public <S extends Role> Optional<S> findOne(Example<S> example) {
		return roleRepository.findOne(example);
	}

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Page<Role> findAll(Pageable pageable) {
		return roleRepository.findAll(pageable);
	}

	@Override
	public List<Role> findAll(Sort sort) {
		return roleRepository.findAll(sort);
	}

	@Override
	public List<Role> findAllById(Iterable<String> ids) {
		return roleRepository.findAllById(ids);
	}

	@Override
	public <S extends Role> List<S> saveAll(Iterable<S> entities) {
		return roleRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		roleRepository.flush();
	}

	@Override
	public <S extends Role> S saveAndFlush(S entity) {
		return roleRepository.saveAndFlush(entity);
	}

	@Override
	public <S extends Role> List<S> saveAllAndFlush(Iterable<S> entities) {
		return roleRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Role> Page<S> findAll(Example<S> example, Pageable pageable) {
		return roleRepository.findAll(example, pageable);
	}

	@Override
	public Optional<Role> findById(String id) {
		return roleRepository.findById(id);
	}

	@Override
	public void deleteInBatch(Iterable<Role> entities) {
		roleRepository.deleteInBatch(entities);
	}

	@Override
	public boolean existsById(String id) {
		return roleRepository.existsById(id);
	}

	@Override
	public <S extends Role> long count(Example<S> example) {
		return roleRepository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Role> entities) {
		roleRepository.deleteAllInBatch(entities);
	}

	@Override
	public <S extends Role> boolean exists(Example<S> example) {
		return roleRepository.exists(example);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<String> ids) {
		roleRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public <S extends Role, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return roleRepository.findBy(example, queryFunction);
	}

	@Override
	public long count() {
		return roleRepository.count();
	}

	@Override
	public void deleteAllInBatch() {
		roleRepository.deleteAllInBatch();
	}

	@Override
	public void deleteById(String id) {
		roleRepository.deleteById(id);
	}

	@Override
	public Role getOne(String id) {
		return roleRepository.getOne(id);
	}

	@Override
	public void delete(Role entity) {
		roleRepository.delete(entity);
	}

	@Override
	public Role getById(String id) {
		return roleRepository.getById(id);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		roleRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends Role> entities) {
		roleRepository.deleteAll(entities);
	}

	@Override
	public Role getReferenceById(String id) {
		return roleRepository.getReferenceById(id);
	}

	@Override
	public void deleteAll() {
		roleRepository.deleteAll();
	}

	@Override
	public <S extends Role> List<S> findAll(Example<S> example) {
		return roleRepository.findAll(example);
	}

	@Override
	public <S extends Role> List<S> findAll(Example<S> example, Sort sort) {
		return roleRepository.findAll(example, sort);
	}

	
	
}
