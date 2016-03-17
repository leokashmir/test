package org.fiveware.test.service;

import java.util.List;

import javax.transaction.Transactional;

import org.fiveware.test.entidades.Pessoa;
import org.fiveware.test.model.dao.PessoaDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PessoaServiceImpl  {

	@Autowired
	@Qualifier("pessoaDaoImpl")
	PessoaDaoImpl dao;

	
	public List<Pessoa> listarTodos() {
		
		return dao.listarTodos();
	}

	
	public void atualizarOuSalvar(Pessoa pessoa) {
		dao.atualizarOuSalvar(pessoa);
		
	}

	
	public void delete(Pessoa pessoa) {
		dao.delete(pessoa);
		
	}

	
	
}
