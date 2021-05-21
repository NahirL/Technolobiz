package com.ar.tbz.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ar.tbz.domain.Banco;
import com.ar.tbz.services.BancoService;

@RestController
@RequestMapping("/banco")
@Api(value="onlinestore", description="Operations pertaining to bancos in Online Store")
public class BancoController {

    private BancoService bancoService;

    @Autowired
    public void setBancoService(BancoService bancoService) {
        this.bancoService = bancoService;
    }

    @ApiOperation(value = "View a list of available bancos",response = Iterable.class)
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
        Iterable<Banco> bancoList = bancoService.listAllBancos();

        if(!bancoList.iterator().hasNext()) {
            return new ResponseEntity("No existe ningún banco", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(bancoList, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/", method= RequestMethod.GET, produces = "application/json")
    
    public ResponseEntity list(Model model){
        Iterable<Banco> bancoList = bancoService.listAllBancos();

        if(!bancoList.iterator().hasNext()) {
            return new ResponseEntity("No existe ningún banco", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(bancoList, HttpStatus.OK);
        }
    }
    
    
    @ApiOperation(value = "Search a banco with an ID",response = Banco.class)
    @RequestMapping(value = "/show/{id}", method= RequestMethod.GET, produces = "application/json")
    /*public Product showProduct(@PathVariable Integer id, Model model){
        Product product = productService.getProductById(id);
        return product;
    }*/
    public ResponseEntity showBanco(@PathVariable Integer id, Model model){
        Banco banco = bancoService.getBancoById(id);

        if(banco == null) {
            return new ResponseEntity("No existe ningún banco con id " + id, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(banco, HttpStatus.OK);
        }
    }

    // !!!!!!!!!!!!!!!!!!!
    @ApiOperation(value = "Search a banco with an nroCuenta",response = Banco.class)
    @RequestMapping(value = "/validate/{nroCuenta}", method= RequestMethod.GET, produces = "application/json")
    public Banco validateBanco(@PathVariable Integer nroCuenta){ // parametro Model model???
        Banco banco= bancoService.getBancoByNroCuenta(nroCuenta);
        return banco;
    }

    @ApiOperation(value = "Search a banco with a Description")
    @RequestMapping(value="/view/{description}", method = RequestMethod.GET, produces = "application/json")
    public Banco showBancoByDescription(@PathVariable String description){
        Banco banco = bancoService.getBancoByDescription(description);
        return banco;
    }

    @ApiOperation(value = "Add a banco")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveBanco(@RequestBody Banco banco) {
        // !!!!!!!!!!!!!!!!!!!!!
        if (this.validateBanco(banco.getNroCuenta()) != null) {
            return new ResponseEntity("Banco with existing nroCuenta", HttpStatus.ALREADY_REPORTED);
        } else {
            bancoService.saveBanco(banco);
            return new ResponseEntity("Banco saved successfully", HttpStatus.OK);
        }
    }

    @ApiOperation(value = "Update a banco")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity updateBanco(@PathVariable Integer id, @RequestBody Banco banco){
        Banco storedBanco = bancoService.getBancoById(id);
        storedBanco.setDescription(banco.getDescription());
        storedBanco.setImageUrl(banco.getImageUrl());
        storedBanco.setSaldo(banco.getSaldo());
        bancoService.saveBanco(storedBanco);
        return new ResponseEntity("Banco updated successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a banco")
    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity delete(@PathVariable Integer id){
    	
    	
    	Banco banco = bancoService.getBancoById(id);
    	
    	
    	 if (banco ==null) {
             return new ResponseEntity("Banco not existing nroCuenta", HttpStatus.NOT_FOUND);
         } else {
             bancoService.deleteBanco(id);
             return new ResponseEntity("Banco delete successfully", HttpStatus.OK);
         }
    	
    	
        //productService.deleteProduct(id);
       // return new ResponseEntity("Product deleted successfully", HttpStatus.OK);
    }
}
