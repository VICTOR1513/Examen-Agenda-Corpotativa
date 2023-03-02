package com.examen.agenda.corpotativa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.examen")
//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class OperacionesAutoservicioApplication {

	private static final Logger log = LoggerFactory.getLogger(OperacionesAutoservicioApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OperacionesAutoservicioApplication.class, args);
		log.info("Inicio de aplicacion");
	}

}
