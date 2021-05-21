package com.ar.tbz.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ar.tbz.domain.Product;
import com.ar.tbz.domain.User;
import com.ar.tbz.services.UserService;

@RestController
@RequestMapping("/user")
@Api(value="onlinestore", description="Operations pertaining to users in Online Store")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) { this.userService = userService; }

    @ApiOperation(value = "View a list of available users", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 208, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    
    
@RequestMapping(value = "/", method= RequestMethod.GET, produces = "application/json")
    
    public ResponseEntity list2(Model model){
        Iterable<User> userList = userService.listAllUsers();

        if(!userList.iterator().hasNext()) {
            return new ResponseEntity("No existe ningún usuario", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(userList, HttpStatus.OK);
        }
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
    public Iterable<User> list(Model model) {
        Iterable<User> userList = userService.listAllUsers();
        return userList;
    }

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


    @ApiOperation(value = "Search a user with an ID", response = User.class)
    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = "application/json")
    public User showUser(@PathVariable Integer id, Model model) {
        User user = userService.getUserById(id);
        return user;
    }

    @ApiOperation(value = "Add a user")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return new ResponseEntity("User saved successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Update a user")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity updateProduct(@PathVariable Integer id, @RequestBody User user){
        User storedUser = userService.getUserById(id);
        storedUser.setUserName(user.getUserName());
        storedUser.setFname(user.getFname());
        storedUser.setLname(user.getLname());
        storedUser.setAvatar(user.getAvatar());
        userService.saveUser(storedUser);
        return new ResponseEntity("Product updated successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a user")
    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity delete(@PathVariable Integer id){
        userService.deleteUser(id);
        return new ResponseEntity("User deleted successfully", HttpStatus.OK);
    }
}