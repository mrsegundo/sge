package br.com.escolaeh.sge.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Aluno implements Serializable {

	private static final long serialVersionUID = 8059605288693577077L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long matricula;
	private String nome;
	private String telefone;
	private String email;
	private LocalDate dataCadastro;
	@JsonIgnore
	@ManyToMany(mappedBy = "alunosMatriculados", fetch = FetchType.LAZY)
	private List<Disciplina> disciplinas = new ArrayList<>();
	

	public Aluno(String nome, String telefone, String email) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.dataCadastro = LocalDate.now();
	}

}
