package br.com.escolaeh.sge.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.escolaeh.sge.models.Aluno;
import br.com.escolaeh.sge.models.Avaliacao;
import br.com.escolaeh.sge.repositories.AlunoRepositorio;
import br.com.escolaeh.sge.repositories.AvaliacaoRepositorio;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

	@Autowired
	private AvaliacaoRepositorio avaliacaoRepositorio;
	
	@Autowired
	private AlunoRepositorio alunoRepositorio;

	@GetMapping
	public List<Avaliacao> listar() {
		return avaliacaoRepositorio.findAll();
	}

	// Buscar
	@GetMapping("/{id}")
	public Optional<Avaliacao> buscar(@PathVariable UUID id) {
		return avaliacaoRepositorio.findById(id);
	}
	
	// Buscar
	@GetMapping("/aluno={matricula}")
	public List<Avaliacao> buscar(@PathVariable Long matricula) {
		Aluno aluno = alunoRepositorio.findById(matricula)
				.orElseGet(() -> { return new Aluno(); }); // Pega ou Aluno do Optional ou se for null de da um new Aluno()
		return avaliacaoRepositorio.findByAluno(aluno);
	}

	// Cadastrar
	@PostMapping
	public void cadastrar(@RequestBody Avaliacao avaliacao) {
		avaliacaoRepositorio.save(avaliacao);
	}

	// Alterar
	@PutMapping
	public void alterar(@RequestBody Avaliacao avaliacao) {
		avaliacaoRepositorio.save(avaliacao);
	}

	// Deletar
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable UUID id) {
		avaliacaoRepositorio.deleteById(id);
	}

}
