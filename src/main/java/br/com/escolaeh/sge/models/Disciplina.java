package br.com.escolaeh.sge.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import br.com.escolaeh.sge.enums.TipoAvaliacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Disciplina implements Serializable {

	private static final long serialVersionUID = -1714812554326374118L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String nome;

	@ManyToMany(fetch = FetchType.LAZY ,cascade = {CascadeType.ALL})
	@JoinTable(
			  name = "aluno_matriculado", 
			  joinColumns = @JoinColumn(name = "disciplina_id"), 
			  inverseJoinColumns = @JoinColumn(name = "aluno_id"))
	private List<Aluno> alunosMatriculados = new ArrayList<>();

	@ElementCollection(targetClass = Avaliacao.class)
	@OneToMany(cascade=CascadeType.PERSIST)
	List<Avaliacao> avaliacoes = new ArrayList<>();

	public Disciplina(String nome) {
		this.nome = nome;
	}

	public void matricularAlunos(List<Aluno> alunos) {
		this.alunosMatriculados.addAll(alunos);
		for (Aluno aluno : alunos) {
			gerarAvaliacoes(aluno);
		}
	}

	public void matricularAluno(Aluno aluno) {
		this.alunosMatriculados.add(aluno);
		gerarAvaliacoes(aluno);
	}

	public void gerarAvaliacoes(Aluno aluno) {
		avaliacoes.addAll(Arrays.asList(new Avaliacao(TipoAvaliacao.AV1, aluno, 0L),
				new Avaliacao(TipoAvaliacao.AV2, aluno, 0L), new Avaliacao(TipoAvaliacao.RECUPERACAO, aluno, 0L)));
	}

	private void setNota(TipoAvaliacao av, Aluno aluno, Long nota) {
		for (Avaliacao avaliacao : avaliacoes) {
			if (avaliacao.getNome().equals(av) && avaliacao.getAluno().equals(aluno)) {
				avaliacao.setNota(nota);
				return;
			}
		}
	}

	public void setNotaAV1(Aluno aluno, Long nota) {
		setNota(TipoAvaliacao.AV1, aluno, nota);
	}

	public void setNotaAV2(Aluno aluno, Long nota) {
		setNota(TipoAvaliacao.AV2, aluno, nota);
	}

	public void setNotaRecuperacao(Aluno aluno, Long nota) {
		setNota(TipoAvaliacao.RECUPERACAO, aluno, nota);
	}
	
	public void setNotaTrabalho(Aluno aluno, Long nota) {
		setNota(TipoAvaliacao.TRABALHO, aluno, nota);
	}

}
