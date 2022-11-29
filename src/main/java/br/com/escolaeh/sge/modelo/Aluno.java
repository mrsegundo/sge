package br.com.escolaeh.sge.modelo;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Aluno {

	private Long matricula;
	private String nome;
	private String telefone;
	private String email;
	private Instant dataCadastro;

}
