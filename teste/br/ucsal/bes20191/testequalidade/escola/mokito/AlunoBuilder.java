package br.ucsal.bes20191.testequalidade.escola.mokito;

import br.ucsal.bes20191.testequalidade.escola.domain.Aluno;
import br.ucsal.bes20191.testequalidade.escola.domain.SituacaoAluno;

public class AlunoBuilder {

	private static final Integer matriculaDEFAULT = 1;
	private static final String nomeDEFAULT = "luiz";
	private static final SituacaoAluno situacaoDEFAUlT = SituacaoAluno.ATIVO;
	private static final Integer anoNascimentoDEFAUlT = 1997;

	private Integer matricula = matriculaDEFAULT;
	private String nome = nomeDEFAULT;
	private SituacaoAluno situacao = situacaoDEFAUlT;
	private Integer anoNascimento = anoNascimentoDEFAUlT;

	public AlunoBuilder() {
		super();
	}

	public static AlunoBuilder umAluno() {
		return new AlunoBuilder();
	}

	public static AlunoBuilder umAlunoAtivo() {
		return new AlunoBuilder().ativo();
	}

	public static AlunoBuilder umAlunoCancelado() {
		return new AlunoBuilder().cancelado();
	}

	public AlunoBuilder comMatricula(Integer matricula) {
		this.matricula = matricula;
		return this;
	}

	public AlunoBuilder comNome(String nome) {
		this.nome = nome;
		return this;
	}

	public AlunoBuilder ativo() {
		this.situacao = SituacaoAluno.ATIVO;
		return this;
	}

	public AlunoBuilder cancelado() {
		this.situacao = SituacaoAluno.CANCELADO;
		return this;
	}

	public AlunoBuilder comAnoNascimento(Integer anoNascimento) {
		this.anoNascimento = anoNascimento;
		return this;
	}

	public AlunoBuilder mas() {
		AlunoBuilder novoalunoAlunoBuilder = umAluno();
		novoalunoAlunoBuilder.matricula = matricula;
		novoalunoAlunoBuilder.nome = nome;
		novoalunoAlunoBuilder.situacao = situacao;
		novoalunoAlunoBuilder.anoNascimento = anoNascimento;
		return novoalunoAlunoBuilder;
	}

	public Aluno Builder() {
		Aluno aluno = new Aluno();
		aluno.setMatricula(matricula);
		aluno.setNome(nome);
		aluno.setSituacao(situacao);
		aluno.setAnoNascimento(anoNascimento);
		return aluno;
	}

}