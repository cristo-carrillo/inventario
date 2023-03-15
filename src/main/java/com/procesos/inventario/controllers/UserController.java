package com.procesos.inventario.controllers;

import com.procesos.inventario.models.User;
import com.procesos.inventario.services.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final UserServiceImp userServiceImp;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userServiceImp.getUser(id));
    }

    @PostMapping("/")
    public ResponseEntity<Void> saveUser(@RequestBody User user) {
        if (!userServiceImp.createUser(user)) {
            return new ResponseEntity<Void>(HttpStatus.PAYMENT_REQUIRED);
        }
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.ok(userServiceImp.allUser());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id, @RequestBody User user){
        if (!userServiceImp.updateUser(id,user)) {
            return new ResponseEntity<Void>(HttpStatus.PAYMENT_REQUIRED);
        }
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }


}
