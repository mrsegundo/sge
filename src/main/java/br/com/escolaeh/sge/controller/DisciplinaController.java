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

import br.com.escolaeh.sge.modelo.Disciplina;
import br.com.escolaeh.sge.repositorio.DisciplinaRepositorio;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

	@Autowired
	private DisciplinaRepositorio disciplinaRepositorio;

	@GetMapping
	public List<Disciplina> listar() {
		return disciplinaRepositorio.findAll();
	}

	// Buscar
	@GetMapping("/{id}")
	public Optional<Disciplina> buscar(@PathVariable UUID id) {
		return disciplinaRepositorio.findById(id);
	}

	// Cadastrar
	@PostMapping
	public void cadastrar(@RequestBody Disciplina disciplina) {
		disciplinaRepositorio.save(disciplina);
	}

	// Alterar
	@PutMapping
	public void alterar(@RequestBody Disciplina disciplina) {
		disciplinaRepositorio.save(disciplina);
	}

	// Deletar
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable UUID id) {
		disciplinaRepositorio.deleteById(id);
	}
	
	// Buscar
	@GetMapping("/count")
	public Long contar() {
		return disciplinaRepositorio.count();
	}

}
