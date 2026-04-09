package br.ufrpe.poo.banco.dados;

import java.util.ArrayList;

import br.ufrpe.poo.banco.exceptions.RepositorioException;
import br.ufrpe.poo.banco.iterator.IteratorContaAbstrata;
import br.ufrpe.poo.banco.negocio.ContaAbstrata;

public class RepositorioContasLista_6 implements IRepositorioContas{
	
	ArrayList<ContaAbstrata> contas;
	
	public RepositorioContasLista_6(){
		contas = new ArrayList<ContaAbstrata>();
	}

	@Override
	public boolean inserir(ContaAbstrata conta) throws RepositorioException {
		if(conta==null) { //se conta nao existe
			return false;
		} else if(this.existe(conta.getNumero())) { //conta ja existe no banco
			return false;
		} else { //conta existe e vai ser adicionada no banco
		contas.add(conta);
		return true;
		}
	}
	
	@Override
	public boolean remover(String numero) throws RepositorioException {
		if(this.existe(numero)) { //remover conta que existe
			contas.remove(this.procurar(numero));
			return true;
		} else //conta nao existe no repositorio
		return false;
	}

	@Override
	public ContaAbstrata procurar(String numero) {
		for(int i = 0; i < contas.size(); i++) {
			if(contas.get(i).getNumero()==numero)
				return contas.get(i);
		}
		return null;
	}

	

	@Override
	public boolean atualizar(ContaAbstrata conta) throws RepositorioException {
		return false;
	}

	@Override
	public boolean existe(String numero) {
		return false;
	}

	@Override
	public IteratorContaAbstrata getIterator() {
		return null;
	}
	
	

}
