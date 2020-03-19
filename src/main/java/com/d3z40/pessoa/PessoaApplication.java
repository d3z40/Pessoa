package com.d3z40.pessoa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PessoaApplication {

    private static Logger logger = LoggerFactory.getLogger(PessoaApplication.class);

    public static void main(String[] args) {
        logger.info("Iniciando a API REST de cadastro de Pessoas");

        SpringApplication.run(PessoaApplication.class, args);

        logger.info("Finalizando a API REST de cadastro de Pessoas");
    }
}