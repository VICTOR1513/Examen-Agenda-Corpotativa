package com.examen.agenda.corpotativa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.examen")
public class AgendaCorporativaApplication {

	private static final Logger log = LoggerFactory.getLogger(AgendaCorporativaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AgendaCorporativaApplication.class, args);
		log.info("Inicio de aplicacion");
	}

}
