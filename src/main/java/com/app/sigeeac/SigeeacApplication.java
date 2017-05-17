package com.app.sigeeac;

import com.app.sigeeac.dao.InstitucionGubernamentalDao;
import com.app.sigeeac.model.InstitucionGubernamental;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SigeeacApplication {

    private static final Logger log = LoggerFactory.getLogger(SigeeacApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SigeeacApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(InstitucionGubernamentalDao repository) {
        return (args) -> {
            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (InstitucionGubernamental user : repository.findAll()) {
                log.info(user.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            //InstitucionGubernamental user = repository.findOne(1);
            log.info("Customer found with findOne(1L):");
            log.info("--------------------------------");
            //log.info(user.getCodigoUsuario());
            log.info("");
        };
    }
}
