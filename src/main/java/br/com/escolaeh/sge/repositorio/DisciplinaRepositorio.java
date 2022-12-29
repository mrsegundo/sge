package br.com.escolaeh.sge.repositorio;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.escolaeh.sge.modelo.Disciplina;

public interface DisciplinaRepositorio extends JpaRepository<Disciplina, UUID> {

}
