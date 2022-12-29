package br.com.escolaeh.sge.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.escolaeh.sge.configs.Carga;
import br.com.escolaeh.sge.models.Aluno;
import br.com.escolaeh.sge.models.Disciplina;
import br.com.escolaeh.sge.repositories.AlunoRepositorio;
import br.com.escolaeh.sge.repositories.DisciplinaRepositorio;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepositorio alunoRepositorio;

	@Autowired
	private DisciplinaRepositorio disciplinaRepositorio;

	public List<Aluno> listar() {
		return alunoRepositorio.findAll();
	}

	public Optional<Aluno> buscar(Long matricula) {
		return alunoRepositorio.findById(matricula);
	}

	@Transactional
	public Aluno cadastrar(Aluno aluno) {
		return alunoRepositorio.save(aluno);
	}

	public void alterar(Aluno aluno) {
		alunoRepositorio.save(aluno);
	}

	@Transactional
	public void deletar(Long matricula) {
		alunoRepositorio.deleteById(matricula);
	}

	public Long contar() {
		return alunoRepositorio.count();
	}

	public void cargaInicial() {
		for (int i = 0; i < 60; i++) {
			List<Aluno> alunos = alunoRepositorio.saveAllAndFlush(Carga.alunos());
			List<Disciplina> dcplns = Carga.criarDisciplinas(alunos);
			dcplns = Carga.popularDisciplinas(dcplns, alunos);
			disciplinaRepositorio.saveAll(dcplns);
		}
	}

}
