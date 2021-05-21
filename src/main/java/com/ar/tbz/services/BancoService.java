package com.ar.tbz.services;


import com.ar.tbz.domain.Banco;

public interface BancoService {
    // !!!!!!!!!!!!!!!!!!!!!!!!
    Banco getBancoByNroCuenta(Integer nroCuenta);

    Banco getBancoByDescription(String description);

    Iterable<Banco> listAllBancos();

    Banco getBancoById(Integer id);

    Banco saveBanco(Banco banco);

    void deleteBanco(Integer id);
}
