package br.com.escolaeh.sge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.escolaeh.sge.models.Aluno;

public interface AlunoRepositorio extends JpaRepository<Aluno, Long> {

}
