package br.com.escolaeh.sge.configs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import br.com.escolaeh.sge.models.Aluno;
import br.com.escolaeh.sge.models.Disciplina;

public class Carga {

	public static List<Aluno> alunos() {
		List<Aluno> alunos = new ArrayList<Aluno>(
				Arrays.asList(new Aluno("Samuel", "21 973132378", "samuel@escolaeh.com.br"),
						new Aluno("Davi", "22 981368812", "davi@escolaeh.com.br"),
						new Aluno("Lucas", "22 981368812", "lucas@escolaeh.com.br"),
						new Aluno("João", "22 981368812", "joao@escolaeh.com.br"),
						new Aluno("Felipe", "22 981368812", "felipe@escolaeh.com.br")));
		return alunos;
	}

	public static List<Disciplina> criarDisciplinas(List<Aluno> alunos) {
		// Criando as disciplinas
		List<Disciplina> disciplinas = new ArrayList<Disciplina>(
				Arrays.asList(new Disciplina("Matemática"), new Disciplina("Português"), new Disciplina("História"),
						new Disciplina("Biologia"), new Disciplina("Física")));
		return disciplinas;
	}

	public static List<Disciplina> popularDisciplinas(List<Disciplina> disciplinas, List<Aluno> alunos) {
		// Matriculando nas disciplinas e dando notas aos alunos
		for (Disciplina disciplina : disciplinas) {
			disciplina.matricularAlunos(alunos);
			Random randon = new Random();
			for (Aluno aluno : disciplina.getAlunosMatriculados()) {
				disciplina.gerarAvaliacoes(aluno);
				disciplina.setNotaAV1(aluno, randon.nextLong(10));
				disciplina.setNotaAV2(aluno, randon.nextLong(10));
				disciplina.setNotaRecuperacao(aluno, randon.nextLong(10));
			}
		}
		return disciplinas;
	}
}
