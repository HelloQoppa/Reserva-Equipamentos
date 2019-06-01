package br.ucsal.bes20191.testequalidade.escola.mokito;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import br.ucsal.bes20191.testequalidade.escola.domain.Aluno;
import br.ucsal.bes20191.testequalidade.escola.persistence.AlunoDAO;
import br.ucsal.bes20191.testequalidade.escola.util.DateHelper;

@RunWith(MockitoJUnitRunner.class)
public class AlunoBOUnitarioTest2 {
	@Mock
	private DateHelper dateHelperMock;
	@Mock
	private AlunoDAO alunoDAOMock;
	@InjectMocks
	private AlunoBO alunoBO;

	/**
	 * Verificar o calculo da idade. Caso de teste: aluno nascido em 2003 terá
	 * 16 anos.
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

		// obs:
		Mockito.verify(alunoDAOMock, Mockito.atLeast(1)).salvar(alunoAtivo);
		Mockito.verify(alunoDAOMock, Mockito.times(1)).salvar(alunoAtivo);

	}

}
