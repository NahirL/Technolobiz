package guru.springframework.repositories;

import guru.springframework.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface ProductRepository extends CrudRepository<Product, Integer>{
    // !!!!!!!!!!!!!!
    Optional<Product> findByProductId(String var1);

    Optional<Product> findByDescription(String var1);
}