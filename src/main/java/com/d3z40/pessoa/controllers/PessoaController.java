package com.d3z40.pessoa.controllers;

import com.d3z40.pessoa.models.Pessoa;
import com.d3z40.pessoa.repositories.PessoaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api
@RestController
@RequestMapping(path = "/pessoas")
public class PessoaController {

    private static Logger logger = LoggerFactory.getLogger(PessoaController.class);

    @Autowired
    PessoaRepository pessoaRepository;

    @ApiOperation("Retorna todas as pessoas")
    @GetMapping
    public ResponseEntity<List<Pessoa>> getFindAll() {
        logger.info("Retornando todas as pessoas");

        List<Pessoa> pessoas = pessoaRepository.findAll();
        return new ResponseEntity<>(pessoas, HttpStatus.OK);
    }

    @ApiOperation("Retorna a pessoa por id")
    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Pessoa>> getById(@PathVariable int id) {
        logger.info("Retornando pessoa pelo id: {}", id);

        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        return new ResponseEntity<>(pessoa, HttpStatus.OK);
    }

    @ApiOperation("Deleta a pessoa por id")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Optional<HttpStatus>> deleteById(@PathVariable int id) {
        logger.info("Deletando pessoa pelo id: {}", id);

        pessoaRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation("Salva uma nova pessoa")
    @PostMapping
    public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa) {
        logger.info("Cadastrando uma pessoa {}", pessoa.getNome());

        Pessoa newPessoa  = pessoaRepository.save(pessoa);
        return new ResponseEntity<>(newPessoa, HttpStatus.OK);
    }

    @ApiOperation("Atualiza a pessoa por id")
    @PutMapping(path = "/{id}")
    public ResponseEntity<Optional<Pessoa>> update(@PathVariable int id, @RequestBody Pessoa newPessoa) {
        logger.info("Atualizando a pessoa {}", id);

        return pessoaRepository.findById(id)
                .map(pessoa -> {
                    pessoa.setNome(newPessoa.getNome());
                    pessoa.setCpf(newPessoa.getCpf());
                    pessoa.setDataNascimento(newPessoa.getDataNascimento());
                    Pessoa pessoaUpdated = pessoaRepository.save(pessoa);
                    return new ResponseEntity(pessoaUpdated, HttpStatus.OK);
                }).orElse(ResponseEntity.notFound().build());
    }
}