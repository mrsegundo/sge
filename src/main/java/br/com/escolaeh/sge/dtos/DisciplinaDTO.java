package br.com.escolaeh.sge.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.escolaeh.sge.models.Aluno;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DisciplinaDTO {

	private UUID id;
	private String nome;
	private List<Aluno> alunosMatriculados = new ArrayList<>();
}
