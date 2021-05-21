package com.ar.tbz.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ar.tbz.domain.Product;

import java.util.Optional;

@RepositoryRestResource
public interface ProductRepository extends CrudRepository<Product, Integer>{
    // !!!!!!!!!!!!!!
    Optional<Product> findByProductId(String var1);

    Optional<Product> findByDescription(String var1);
}