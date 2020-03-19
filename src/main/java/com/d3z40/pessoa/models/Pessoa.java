package com.d3z40.pessoa.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nome")
    @NotBlank(message = "Campo \"Nome\" obrigatório")
    private String nome;

    @Column(name = "cpf")
    @NotBlank(message = "Campo \"CPF\" obrigatório")
    private String cpf;

    @Column(name = "dataNasc")
    private Date dataNascimento;

    public Pessoa() {
    }

    public Pessoa(@NotBlank(message = "Campo \"Nome\" obrigatório") String nome, @NotBlank(message = "Campo \"CPF\" obrigatório") String cpf, @NotBlank(message = "Campo \"Data de Nascimento\" obrigatório") Date dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}