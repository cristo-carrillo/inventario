package com.procesos.inventario.controllers;

import com.procesos.inventario.models.User;
import com.procesos.inventario.services.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final UserServiceImp userServiceImp;

    @GetMapping("/{id}")
    public ResponseEntity findUserById(@PathVariable Long id) {
        Map<String, String> response = new HashMap<>();
        try {
            return new ResponseEntity<>(userServiceImp.getUser(id), HttpStatus.OK);
        } catch (Exception e) {
            response.put("status", "404");
            response.put("message", "No se encontro el usuario!");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity saveUser(@RequestBody User user) {
        Map<String, String> response = new HashMap<>();
        if (!userServiceImp.createUser(user)) {
            response.put("status", "400");
            response.put("message", "Error en los datos enviados");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        response.put("status", "201");
        response.put("message", "Usuario creado con éxito");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity getAllUser() {
        Map<String, String> response = new HashMap<>();
        List<User> registeredUsers = userServiceImp.allUser();
        if (registeredUsers.isEmpty()) {
            response.put("status", "404");
            response.put("message", "No hay usuarios");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(registeredUsers);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable Long id, @RequestBody User user) {
        Map<String, String> response = new HashMap<>();
        if (!userServiceImp.updateUser(id, user)) {
            response.put("status", "400");
            response.put("message", "Error en los datos enviados");
            return new ResponseEntity<>(response, HttpStatus.PAYMENT_REQUIRED);
        }
        response.put("status", "200");
        response.put("message", "Usuario actualizado con éxito");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
