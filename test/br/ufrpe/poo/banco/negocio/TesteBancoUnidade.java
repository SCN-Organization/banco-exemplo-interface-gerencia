package br.ufrpe.poo.banco.negocio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Ignore;
import org.junit.Test;

import br.ufrpe.poo.banco.dados.IRepositorioContas;
import br.ufrpe.poo.banco.exceptions.ContaJaCadastradaException;
import br.ufrpe.poo.banco.exceptions.ContaNaoEncontradaException;
import br.ufrpe.poo.banco.exceptions.RenderBonusContaEspecialException;
import br.ufrpe.poo.banco.exceptions.RepositorioException;

/**
 * Testa a classe Banco independente da implementa��o dos repositorios.
 * 
 * @author sidneynogueira
 * 
 */
public class TesteBancoUnidade {

	public static Banco getBancoMock() {
		IRepositorioContas contasMock = mock(IRepositorioContas.class);
		Banco bancoMock = new Banco(null, contasMock);
		return bancoMock;
	}

	@Test
	public void cadastrarNovaConta() throws RepositorioException {

		Banco banco = getBancoMock();
		ContaAbstrata conta1 = new Conta("1", 0);
		when(banco.contas.inserir(conta1)).thenReturn(true);//conta não existe no repositório

		try {
			banco.cadastrar(conta1);
		} catch (RepositorioException | ContaJaCadastradaException e) {
			fail("Excecao levantada quando nao deveria");
		}
		
	}

	@Test(expected = ContaJaCadastradaException.class)
	public void cadastrarContaExiste()
			throws RepositorioException, ContaJaCadastradaException {

		Banco banco = getBancoMock();
		ContaAbstrata conta = new Conta("1", 0);
		when(banco.contas.inserir(conta)).thenReturn(false);//conta existe no repositório

		banco.cadastrar(conta);
	}

	@Test(expected = RenderBonusContaEspecialException.class)
	public void renderBonusContaNaoEspecial() throws RepositorioException, 
			ContaNaoEncontradaException, RenderBonusContaEspecialException {
		Banco banco = getBancoMock();
		ContaAbstrata conta = new Conta("1", 0);
		//esse teste so precisa que exista o repositório
		//nao precisa emular o comportamento do repositorio
		banco.renderBonus(conta);
	}
	
	@Test(expected = ContaNaoEncontradaException.class)
	public void renderBonusContaEspecialNaoCadastrada() throws RepositorioException, 
			ContaNaoEncontradaException, RenderBonusContaEspecialException {
		Banco banco = getBancoMock();
		ContaAbstrata conta = new ContaEspecial("1", 0);
		when(banco.contas.existe(conta.getNumero())).thenReturn(false);//conta não existe		
		banco.renderBonus(conta);
	}
	
	@Test
	public void renderBonusContaEspecialSucesso() throws RepositorioException,
			ContaNaoEncontradaException, RenderBonusContaEspecialException {
		Banco banco = getBancoMock();
		ContaAbstrata conta = new ContaEspecial("1", 100);
		when(banco.contas.existe(conta.getNumero())).thenReturn(true);//conta existe		
		conta.creditar(100);
		banco.renderBonus(conta);	
		assertEquals(201, conta.getSaldo(),0);
	}


}