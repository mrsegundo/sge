package br.com.escolaeh.sge.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AlunoDTO {

	private Long matricula;
	private String nome;
	private String telefone;
	private String email;
	private LocalDate dataCadastro;

}
