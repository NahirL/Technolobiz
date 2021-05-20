package guru.springframework.controllers;

import guru.springframework.domain.Product;
import guru.springframework.services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@Api(value="onlinestore", description="Operations pertaining to products in Online Store")
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @ApiOperation(value = "View a list of available products",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 208, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
          
    }
    )
    
    // el usuario invoca (http://localhost:8080) (no invoca nada mas despues del 8080)
    // el @RequestMapping analiza el contenido de value que en este caso esta vacio
    
    @RequestMapping(value = "", method= RequestMethod.PUT, produces = "application/json")
    
    public ResponseEntity list6(Model model){
        
            return new ResponseEntity("URL incorrecta ", HttpStatus.NOT_FOUND);
        
    }
    
    @RequestMapping(value = "", method= RequestMethod.POST, produces = "application/json")
    
    public ResponseEntity list5(Model model){
        
            return new ResponseEntity("URL incorrecta ", HttpStatus.NOT_FOUND);
        
    }
    
    @RequestMapping(value = "", method= RequestMethod.DELETE, produces = "application/json")
   
    public ResponseEntity list4(Model model){
        
            return new ResponseEntity("URL incorrecta", HttpStatus.NOT_FOUND);
        
    }
    
    @RequestMapping(value = "", method= RequestMethod.GET, produces = "application/json")
    
    public ResponseEntity list3(Model model){
        
            return new ResponseEntity("URL incorrecta", HttpStatus.NOT_FOUND);
        
    }
    
    @RequestMapping(value = "/list", method= RequestMethod.GET, produces = "application/json")
  
    public ResponseEntity list2(Model model){
        Iterable<Product> productList = productService.listAllProducts();

        if(!productList.iterator().hasNext()) {
            return new ResponseEntity("No existe ningún producto", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(productList, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/", method= RequestMethod.GET, produces = "application/json")
    
    public ResponseEntity list(Model model){
        Iterable<Product> productList = productService.listAllProducts();

        if(!productList.iterator().hasNext()) {
            return new ResponseEntity("No existe ningún producto", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(productList, HttpStatus.OK);
        }
    }
    
    
    @ApiOperation(value = "Search a product with an ID",response = Product.class)
    @RequestMapping(value = "/show/{id}", method= RequestMethod.GET, produces = "application/json")
    /*public Product showProduct(@PathVariable Integer id, Model model){
        Product product = productService.getProductById(id);
        return product;
    }*/
    public ResponseEntity showProduct(@PathVariable Integer id, Model model){
        Product product = productService.getProductById(id);

        if(product == null) {
            return new ResponseEntity("No existe ningún producto con id " + id, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(product, HttpStatus.OK);
        }
    }

    // !!!!!!!!!!!!!!!!!!!
    @ApiOperation(value = "Search a product with an ProductID",response = Product.class)
    @RequestMapping(value = "/validate/{productId}", method= RequestMethod.GET, produces = "application/json")
    public Product validateProduct(@PathVariable String productId){ // parametro Model model???
        Product product = productService.getProductByProductId(productId);
        return product;
    }

    @ApiOperation(value = "Search a product with a Description")
    @RequestMapping(value="/view/{description}", method = RequestMethod.GET, produces = "application/json")
    public Product showProductByDescription(@PathVariable String description){
        Product product = productService.getProductByDescription(description);
        return product;
    }

    @ApiOperation(value = "Add a product")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveProduct(@RequestBody Product product) {
        // !!!!!!!!!!!!!!!!!!!!!
        if (this.validateProduct(product.getProductId()) != null) {
            return new ResponseEntity("Product with existing ProductID", HttpStatus.ALREADY_REPORTED);
        } else {
            productService.saveProduct(product);
            return new ResponseEntity("Product saved successfully", HttpStatus.OK);
        }
    }

    @ApiOperation(value = "Update a product")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity updateProduct(@PathVariable Integer id, @RequestBody Product product){
        Product storedProduct = productService.getProductById(id);
        storedProduct.setDescription(product.getDescription());
        storedProduct.setImageUrl(product.getImageUrl());
        storedProduct.setPrice(product.getPrice());
        productService.saveProduct(storedProduct);
        return new ResponseEntity("Product updated successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a product")
    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity delete(@PathVariable Integer id){
    	
    	
    	Product product = productService.getProductById(id);
    	
    	
    	 if (product ==null) {
             return new ResponseEntity("Product not existing ProductID", HttpStatus.NOT_FOUND);
         } else {
             productService.deleteProduct(id);
             return new ResponseEntity("Product delete successfully", HttpStatus.OK);
         }
    	
    	
        //productService.deleteProduct(id);
       // return new ResponseEntity("Product deleted successfully", HttpStatus.OK);
    }
}
