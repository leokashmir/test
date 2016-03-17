package org.fiveware.test.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pessoa", schema = "master")
public class Pessoa {

	@Id
	@GeneratedValue
	@Column(name = "ID_PESSOA")
	private Integer idPessoa;
	
	
	@Column(name = "NOME_PESSOA")
	private String nome;
	
	@Column(name = "EMAIL_PESSOA")
	private String email;
	
	@Column(name = "SEXO_PESSOA")
	private char sexo;
	
	@Column(name = "GRADUACAO_PESSOA")
	private String graduacao;
	
	@Column(name = "FORMADO_PESSOA")
	private boolean formado;

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getGraduacao() {
		return graduacao;
	}

	public void setGraduacao(String graduacao) {
		this.graduacao = graduacao;
	}

	public boolean isFormado() {
		return formado;
	}

	public void setFormado(boolean formado) {
		this.formado = formado;
	}

	
	
	
}
