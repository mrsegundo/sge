package br.com.escolaeh.sge.controller;

import java.time.Instant;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.escolaeh.sge.modelo.Aluno;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@GetMapping
	public Aluno getInfo() {
		Aluno aluno = new Aluno(1L, "José da Silva", "(21) 2555-5555", "jose@escolaeh.com.br", Instant.now());
		return aluno;
	}

}
