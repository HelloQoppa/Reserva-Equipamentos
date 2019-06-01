package br.ucsal.bes20191.testequalidade.escola.mockitotui;

import static org.junit.Assert.assertEquals;

import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;
import org.mockito.Mockito;

public class TuiHelperUnitarioTest {

	/**
	 * Verificar a obtenção do nome completo. Caso de teste: primeiro nome
	 * "Claudio" e sobrenome "Neiva" resulta no nome "Claudio Neiva".
	 */
	
	@Test
	public void testarObterNomeCompleto() {
		TuiUtil tuiUtil = new TuiUtil();
		Scanner scannerMock = Mockito.mock(Scanner.class);
		tuiUtil.scanner = scannerMock;

		String nome = "Claudio";
		String sobrenome = "Neiva";
		Mockito.doReturn(nome).doReturn(sobrenome).when(scannerMock).nextLine();

		String nomeEsperado = "Claudio Neiva";

		String nomeAtual = tuiUtil.obterNomeCompleto();

		assertEquals(nomeEsperado, nomeAtual);

	}

	/**
	 * Verificar a obtenção exibição de mensagem. Caso de teste: mensagem "Tem
	 * que estudar." resulta em "Bom dia! Tem que estudar.".
	 */
	@Test
	public void testarExibirMensagem() {
		TuiUtil tuiUtil = new TuiUtil();

		PrintStream printMock = Mockito.mock(PrintStream.class);
		System.setOut(printMock);

		String mensagem = "Tem que estudar";

		tuiUtil.exibirMensagem(mensagem);

		Mockito.verify(printMock).println(mensagem);
	}

}
