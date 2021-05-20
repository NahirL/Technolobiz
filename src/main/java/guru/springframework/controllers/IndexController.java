package guru.springframework.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

// la llamada desde el cliente a (http://localhost:8080) entra aqui porque no hay nada despues del 8080
//@RequestMapping("/product") este RequestMapping va a ingresar por aqui cuando venga /product desde el cliente


@RequestMapping("/")
public class IndexController {
    @RequestMapping(method= RequestMethod.GET)
    String index(){
    	
    	String index= "Metodo mal utilizado";
    	
        return index;
    }
}
@RequestMapping("/")
 class IndexController2 {
    @RequestMapping(method= RequestMethod.POST)
    String index(){
    	
    	String index= "Metodo mal utilizado";
    	
        return index;
    }
}
@RequestMapping("/")
class IndexController3 {
   @RequestMapping(method= RequestMethod.PUT)
   String index(){
   	
   	String index= "Metodo mal utilizado";
   	
       return index;
   }
}
@RequestMapping("/")
class IndexController4 {
   @RequestMapping(method= RequestMethod.DELETE)
   String index(){
   	
   	String index= "Metodo mal utilizado";
   	
       return index;
   }
}

