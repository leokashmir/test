package org.fiveware.test.model.dao;

import org.fiveware.test.entidades.Pessoa;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


@Repository
public class PessoaDaoImpl extends GenericDao implements PessoaDao{

	@Override
	public void atualizarOuSalvar(Pessoa pessoa) {
		persist(pessoa);
		
	}

	@Override
	public void delete(Pessoa pessoa) {
		Pessoa p = (Pessoa ) getSession().createCriteria(Pessoa.class)
                 .add(Restrictions.eq("idPessoa", pessoa.getIdPessoa())).uniqueResult();
		 
		getSession().delete(p);
		
	}

	

	


	

	

}
