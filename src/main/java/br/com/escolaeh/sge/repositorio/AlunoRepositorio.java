package br.com.escolaeh.sge.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.escolaeh.sge.modelo.Aluno;

public interface AlunoRepositorio extends JpaRepository<Aluno, Long> {

}
