package com.procesos.inventario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import javax.xml.crypto.Data;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class InventarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventarioApplication.class, args);
	}

}
