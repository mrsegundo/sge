package br.com.escolaeh.sge.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.escolaeh.sge.dtos.AlunoDTO;
import br.com.escolaeh.sge.models.Aluno;
import br.com.escolaeh.sge.services.AlunoService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	AlunoService alunoService;

	@GetMapping
	public List<Aluno> listar() {
		return alunoService.listar();
	}

	// Buscar
	@GetMapping("/{matricula}")
	public Optional<Aluno> buscar(@PathVariable Long matricula) {
		return alunoService.buscar(matricula);
	}

	// Cadastrar
	@PostMapping
	public ResponseEntity<Object> cadastrar(@RequestBody AlunoDTO alunoDto) {
		var aluno = new Aluno();
		BeanUtils.copyProperties(alunoDto, aluno);
		aluno.setDataCadastro(LocalDate.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.cadastrar(aluno));
	}

	// Alterar
	@PutMapping
	public void alterar(@RequestBody Aluno aluno) {
		alunoService.alterar(aluno);
	}

	// Deletar
	@DeleteMapping("/{matricula}")
	public void deletar(@PathVariable Long matricula) {
		alunoService.deletar(matricula);
	}

	// Buscar
	@GetMapping("/count")
	public Long contar() {
		return alunoService.contar();
	}

	@GetMapping("/carga")
	private void cargaInicial() {
		alunoService.cargaInicial();
	}

}
