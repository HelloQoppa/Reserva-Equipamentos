package br.ucsal.bes20191.testequalidade.escola.mokito;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.ucsal.bes20191.testequalidade.escola.domain.Aluno;
import br.ucsal.bes20191.testequalidade.escola.persistence.AlunoDAO;
import br.ucsal.bes20191.testequalidade.escola.util.DateHelper;

public class AlunoBOUnitarioTest {
	private DateHelper dateHelperMock;
	private AlunoDAO alunoDAOMock;
	private AlunoBO alunoBO;

	@Before
	public void setup() {
		dateHelperMock = Mockito.mock(DateHelper.class);
		alunoDAOMock = Mockito.mock(AlunoDAO.class);
		alunoBO = new AlunoBO(alunoDAOMock, dateHelperMock);
	}

	/**
	 * Verificar o calculo da idade. Caso de teste: aluno nascido em 2003 terá 16
	 * anos.
	 */
	@Test
	public void testarCalculoIdadeAluno1() {
		Integer matricula = 1;

		Mockito.doReturn(2019).when(dateHelperMock).obterAnoAtual();

		Aluno aluno = AlunoBuilder.umAluno().comAnoNascimento(2003).Builder();
		Mockito.doReturn(aluno).when(alunoDAOMock).encontrarPorMatricula(matricula);

		Integer esperado = 16;

		Integer atual = alunoBO.calcularIdade(matricula);

		assertEquals(esperado, atual);

		Mockito.verify(dateHelperMock).obterAnoAtual();
		Mockito.verify(alunoDAOMock).encontrarPorMatricula(matricula);
	}

	/**
	 * Verificar se alunos ativos são atualizados.
	 */
	@Test
	public void testarAtualizacaoAlunosAtivos() {

		Aluno alunoAtivo = AlunoBuilder.umAluno().ativo().Builder();

		alunoBO.atualizar(alunoAtivo);

		Mockito.verify(alunoDAOMock).salvar(alunoAtivo);

	}

}
