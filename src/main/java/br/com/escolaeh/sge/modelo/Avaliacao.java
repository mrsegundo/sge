package br.com.escolaeh.sge.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Avaliacao implements Serializable {
	private static final long serialVersionUID = 8679586954142379170L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private TipoAvaliacao nome;
	private Long nota;
	@ManyToOne
	private Aluno aluno;
	private LocalDate dataRealizacao;

	public Avaliacao(TipoAvaliacao nome, Aluno aluno) {
		this.nome = nome;
		this.aluno = aluno;
		this.dataRealizacao = LocalDate.now();
	}

	public Avaliacao(TipoAvaliacao nome, Aluno aluno, Long nota) {
		this.nome = nome;
		this.nota = nota;
		this.aluno = aluno;
		this.dataRealizacao = LocalDate.now();
	}

	public Avaliacao(TipoAvaliacao nome, Aluno aluno, Long nota, LocalDate dataRealizacao) {
		this.nome = nome;
		this.nota = nota;
		this.aluno = aluno;
		this.dataRealizacao = dataRealizacao;
	}

}
