package br.com.escolaeh.sge.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.escolaeh.sge.models.Disciplina;

public interface DisciplinaRepositorio extends JpaRepository<Disciplina, UUID> {

}
