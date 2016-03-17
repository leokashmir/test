package org.fiveware.test.service;

import java.util.List;

import org.fiveware.test.entidades.Pessoa;

public interface PessoaService {

public List<Pessoa> listarTodos();
	
	public void atualizarOuSalvar(Pessoa pessoa);
	
	public void delete(Pessoa pessoa);
	

}
