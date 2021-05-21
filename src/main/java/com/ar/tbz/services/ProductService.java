package com.ar.tbz.services;


import com.ar.tbz.domain.Product;

public interface ProductService {
    // !!!!!!!!!!!!!!!!!!!!!!!!
    Product getProductByProductId(String productId);

    Product getProductByDescription(String description);

    Iterable<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);
}
