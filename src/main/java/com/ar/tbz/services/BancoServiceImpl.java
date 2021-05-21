package com.ar.tbz.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ar.tbz.domain.Banco;
import com.ar.tbz.repositories.BancoRepository;

@Service
public class BancoServiceImpl implements BancoService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private BancoRepository bancoRepository;

    @Autowired
    public void setBancoRepository(BancoRepository bancoRepository) {
        this.bancoRepository = bancoRepository;
    }

    // !!!!!!!!!!!!!!!
    @Override
    public Banco getBancoByNroCuenta(Integer nroCuenta) {
        logger.debug("getBancoByNroCuenta called");
        return bancoRepository.findByNroCuenta(nroCuenta).orElse(null);
    }

    @Override
    public Banco getBancoByDescription(String description) {
        return bancoRepository.findByDescription(description).orElse(null);
    }

    @Override
    public Iterable<Banco> listAllBancos() {
        logger.debug("listAllBancos called");
        return bancoRepository.findAll();
    }

    @Override
    public Banco getBancoById(Integer id) {
        logger.debug("getBancoById called");
        return bancoRepository.findById(id).orElse(null);
    }

    @Override
    public Banco saveBanco(Banco banco) {
        logger.debug("saveBanco called");
        return bancoRepository.save(banco);
    }

    @Override
    public void deleteBanco(Integer id) {
        logger.debug("deleteProduct called");
        bancoRepository.deleteById(id);
    }
}
