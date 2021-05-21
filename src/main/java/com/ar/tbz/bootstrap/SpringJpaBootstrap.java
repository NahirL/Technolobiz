package com.ar.tbz.bootstrap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.ar.tbz.domain.Banco;
import com.ar.tbz.domain.Product;
import com.ar.tbz.domain.User;
import com.ar.tbz.repositories.BancoRepository;
import com.ar.tbz.repositories.ProductRepository;
import com.ar.tbz.repositories.UserRepository;

import java.math.BigDecimal;
import java.util.List;

@Component
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private ProductRepository productRepository;
    private UserRepository userRepository;
    private BancoRepository bancoRepository;

    private Logger log = LogManager.getLogger(SpringJpaBootstrap.class);

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setBancoRepository(BancoRepository bancoRepository) {
        this.bancoRepository = bancoRepository;
    }
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadProducts();
        loadUsers();
        loadBancos();
    }
    private void loadProducts() {
        Product shirt = new Product();
        shirt.setDescription("Spring Framework Guru Shirt");
        shirt.setPrice(new BigDecimal("18.95"));
        shirt.setImageUrl("https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_shirt-rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg");
        shirt.setProductId("235268845711068308");
        productRepository.save(shirt);

        log.info("Saved Shirt - id: " + shirt.getId());
        Product mug = new Product();
        mug.setDescription("Spring Framework Guru Mug");
        mug.setImageUrl("https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_coffee_mug-r11e7694903c348e1a667dfd2f1474d95_x7j54_8byvr_512.jpg");
        mug.setProductId("168639393495335947");
        mug.setPrice(new BigDecimal("11.95"));
        productRepository.save(mug);

        log.info("Saved Mug - id:" + mug.getId());
    }
    private void loadUsers() {
        User marco = new User();
        marco.setUserName("marco");
        marco.setAvatar("https://images.unsplash.com/photo-1547644121-6282961a0a40?ixid=MnwxMjA3fDB8MHx0b3BpYy1mZWVkfDJ8dG93SlpGc2twR2d8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60");
        marco.setLname("Perretta");
        marco.setFname("Marco");
        userRepository.save(marco);

        log.info("Saved Marco - id: " + marco.getId());
        
        User kellen = new User();
        kellen.setUserName("kellen");
        kellen.setAvatar("https://images.unsplash.com/photo-1618278096912-d14cda36d45b?ixid=MnwxMjA3fDB8MHx0b3BpYy1mZWVkfDZ8dG93SlpGc2twR2d8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60");
        kellen.setLname("Riggin");
        kellen.setFname("Kellen");
        userRepository.save(kellen);

        log.info("Saved Kellen - id: " + kellen.getId());
    }
    
    private void loadBancos() {
    	Banco banco1 = new Banco();
    	banco1.setDescription("Macro");
        banco1.setSaldo(new BigDecimal("15000.99"));
        banco1.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/Logo_Banco_Macro.svg/800px-Logo_Banco_Macro.svg.png");
        banco1.setNroCuenta(111);
        bancoRepository.save(banco1);

        log.info("Saved Banco1 - id: " + banco1.getId());
        
        Banco banco2 = new Banco();
    	banco2.setDescription("Santander");
        banco2.setSaldo(new BigDecimal("25000.99"));
        banco2.setImageUrl("https://logos-marcas.com/wp-content/uploads/2020/11/Santander-Logo.png");
        banco2.setNroCuenta(222);
        bancoRepository.save(banco2);

        log.info("Saved Banco2 - id:" + banco2.getId());
    	
    }
    
    
}



