package com.procesos.inventario.models;

import lombok.Data;

import java.util.Date;
@Data
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String Address;
    private String email;
    private String password;
    private Date birthday;

}
