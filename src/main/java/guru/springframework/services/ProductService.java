package guru.springframework.services;


import guru.springframework.domain.Product;

public interface ProductService {
    // !!!!!!!!!!!!!!!!!!!!!!!!
    Product getProductByProductId(String productId);

    Product getProductByDescription(String description);

    Iterable<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);
}
