package com.coderhouse.controllers;

import com.coderhouse.models.User;
import com.coderhouse.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

@Autowired
private UserService userService;


@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
public responseEntity<List<User>> getAllUsers(){
    try {
        List<User>   users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    } catch (IllegalArgumentException e) {
        return ResponseEntity.notFound().build();
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}

@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
public responseEntity<User> getUserById(@PathVariable String id){
    try {
        User user = userService.getUserById(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();          //Utilizamos ternario para simplificar.
    } catch (IllegalArgumentException e) {
        return ResponseEntity.notFound().build();
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}

@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public responseEntity<User> createUser(@RequestBody User user){
    try {
        User newUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser); //201
    } catch (IllegalArgumentException e) {
        return ResponseEntity.notFound().build();
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}

@PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public responseEntity<User> updateUser(@RequestBody User user){
    try {
        user.setId(id);
        User updatedUser = userService.updateUser(user);
        return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
    } catch (IllegalArgumentException e) {
        return ResponseEntity.notFound().build();
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    }

    @DeleteMapping(value = "/{id}")
    public responseEntity<Void> deleteUser(@PathVariable String id){
        try {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build(); //204
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
