package com.claro.teste.testeClaro.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="contatos")
public class Contato {

	@Id
	@Column(name="email", length=120, nullable=false, unique=true, updatable = false)
	private String email;
	@Column(name="nome", length=100, nullable=false)
	private String nome;
	@Column(name="telefone", length=11, nullable=false)
	private String telefone;
	@Column(name="cep", length=9)
	private String cep;
	@Column(name="endereco", length=220)
	private String endereco;
	@Column(name="cidade", length=80)
	private String cidade;
    @Column(name="uf", length=2)
    private String uf;
    @Column(name="data_cadastro")
    @JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
    private Date dataCadastro;
	
    public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
}
