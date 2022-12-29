package br.com.escolaeh.sge.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.escolaeh.sge.models.Aluno;
import br.com.escolaeh.sge.models.Avaliacao;

public interface AvaliacaoRepositorio extends JpaRepository<Avaliacao, UUID> {
	
	List<Avaliacao> findByAluno(Aluno aluno);

}
