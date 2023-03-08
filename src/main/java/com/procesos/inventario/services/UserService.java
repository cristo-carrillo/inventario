package com.procesos.inventario.services;

import com.procesos.inventario.models.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserService {
    public User getUser(Long id){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        User user = new User();
        user.setId(1L);
        user.setFirstName("Tia");
        user.setLastName("Paola");
        user.setAddress("carrera 14 5A-15");
        user.setEmail("paola@gmail.com");
        user.setPassword("12345");
        try{
            user.setBirthday(format.parse("26/06/2000"));
        }catch (ParseException e){
            user.setBirthday(new Date());
        }
        return user;
    }
}
