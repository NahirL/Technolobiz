package com.ar.tbz.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ar.tbz.domain.User;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Integer> {
}
