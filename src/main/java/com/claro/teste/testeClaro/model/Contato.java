package com.claro.teste.testeClaro.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contatos")
public class Contato {

	@Id
	@Column(name="email", length=120, nullable=false, unique=true)
	private String Email;
	@Column(name="nome", length=100, nullable=false)
	private String Nome;
	@Column(name="telefone", length=11, nullable=false)
	private String Telefone;
	@Column(name="cep", length=9)
	private String Cep;
	@Column(name="endereco", length=220)
	private String Endereco;
	@Column(name="cidade", length=80)
	private String Cidade;
    @Column(name="uf", length=2)
    private String Uf;
    @Column(name="data_cadastro")
    private Date DataCadastro;
    
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		Telefone = telefone;
	}
	public String getCep() {
		return Cep;
	}
	public void setCep(String cep) {
		Cep = cep;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	public String getCidade() {
		return Cidade;
	}
	public void setCidade(String cidade) {
		Cidade = cidade;
	}
	public String getUf() {
		return Uf;
	}
	public void setUf(String uf) {
		Uf = uf;
	}
	public Date getDataCadastro() {
		return DataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		DataCadastro = dataCadastro;
	}
	
}
