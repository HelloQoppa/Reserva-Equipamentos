package br.ucsal.testequalidade.powerMock;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.legacy.PowerMockRunner;

import br.ucsal.testequalidade.powerMock.business.LocacaoBO;
import br.ucsal.testequalidade.powerMock.dominio.Cliente;
import br.ucsal.testequalidade.powerMock.dominio.Locacao;
import br.ucsal.testequalidade.powerMock.dominio.Veiculo;
import br.ucsal.testequalidade.powerMock.persistence.ClienteDAO;
import br.ucsal.testequalidade.powerMock.persistence.LocacaoDAO;
import br.ucsal.testequalidade.powerMock.persistence.VeiculoDAO;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ LocacaoBOUnitarioTest.class })
public class LocacaoBOUnitarioTest {

	/**
	 * Locar, para um cliente cadastrado, um veículo disponível. Método:
	 * public static Integer locarVeiculos(String cpfCliente, List<String>
	 * placas, Date dataLocacao, Integer quantidadeDiasLocacao) throws
	 * ClienteNaoEncontradoException, VeiculoNaoEncontradoException,
	 * VeiculoNaoDisponivelException, CampoObrigatorioNaoInformado {
	 *
	 * Observação: lembre-se de mocar os métodos necessários nas classes
	 * ClienteDAO, VeiculoDAO e LocacaoDAO.
	 * 
	 * @throws Exception
	 */

	
		Veiculo veiculo;
		Integer numContrato;
		Cliente cliente;
		Locacao local;
		String cpf = "123";
		String placa;
		ArrayList<String> placas;
		Date data;
		Integer qtdDias;
	

	@SuppressWarnings("static-access")
	@Test
	public void locarClienteCadastradoUmVeiculoDisponivel() throws Exception {
		LocacaoBO localBO = new LocacaoBO();
		LocacaoBO spy = PowerMockito.spy(localBO);
		PowerMockito.mockStatic(LocacaoBO.class);
		PowerMockito.when(LocacaoBO.locarVeiculos(cpf, placas, data, qtdDias)).thenReturn(local.getNumeroContrato());
		spy.locarVeiculos(cpf, placas, data, qtdDias);

		PowerMockito.mockStatic(ClienteDAO.class);
		PowerMockito.when(ClienteDAO.obterPorCpf(cpf)).thenReturn(cliente);
		PowerMockito.mockStatic(LocacaoDAO.class);
		PowerMockito.when(LocacaoDAO.obterPorNumeroContrato(numContrato)).thenReturn(local);
		PowerMockito.mockStatic(VeiculoDAO.class);
		PowerMockito.when(VeiculoDAO.obterPorPlaca(placa)).thenReturn(veiculo);
	}
}
