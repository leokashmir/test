package org.fiveware.test.model.dao;

import java.util.List;

import org.fiveware.test.entidades.Pessoa;

public interface PessoaDao {

	public List<Pessoa> listarTodos();
	
	public void atualizarOuSalvar(Pessoa pessoa);
	
	public void delete(Pessoa pessoa);
	
	
	

}
