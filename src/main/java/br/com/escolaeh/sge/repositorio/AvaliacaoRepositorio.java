package br.com.escolaeh.sge.repositorio;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.escolaeh.sge.modelo.Aluno;
import br.com.escolaeh.sge.modelo.Avaliacao;

public interface AvaliacaoRepositorio extends JpaRepository<Avaliacao, UUID> {
	
	List<Avaliacao> findByAluno(Aluno aluno);

}
