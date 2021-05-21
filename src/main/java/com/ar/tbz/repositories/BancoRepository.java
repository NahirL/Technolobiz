package com.ar.tbz.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ar.tbz.domain.Banco;

import java.util.Optional;

@RepositoryRestResource
public interface BancoRepository extends CrudRepository<Banco, Integer>{
    // !!!!!!!!!!!!!!
    Optional<Banco> findByNroCuenta(Integer var1);

    Optional<Banco> findByDescription(String var1);
}