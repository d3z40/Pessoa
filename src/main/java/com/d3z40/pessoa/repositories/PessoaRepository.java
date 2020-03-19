package com.d3z40.pessoa.repositories;

import com.d3z40.pessoa.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}
