package br.com.escolaeh.sge.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.escolaeh.sge.modelo.Aluno;
import br.com.escolaeh.sge.repositorio.AlunoRepositorio;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	private AlunoRepositorio alunoRepositorio;

	@GetMapping
	public List<Aluno> listar() {
		return alunoRepositorio.findAll();
	}

	// Buscar
	@GetMapping("/{matricula}")
	public Optional<Aluno> buscar(@PathVariable Long matricula) {
		return alunoRepositorio.findById(matricula);
	}

	// Cadastrar
	@PostMapping
	public void cadastrar(@RequestBody Aluno aluno) {
		alunoRepositorio.save(aluno);
	}

	// Alterar
	@PutMapping
	public void alterar(@RequestBody Aluno aluno) {
		alunoRepositorio.save(aluno);
	}

	// Deletar
	@DeleteMapping("/{matricula}")
	public void deletar(@PathVariable Long matricula) {
		alunoRepositorio.deleteById(matricula);
	}

}
