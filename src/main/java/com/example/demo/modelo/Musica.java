package com.example.demo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tbl_musica")
public class Musica {

	
	@Id
	@GeneratedValue
	private Integer id;
	

	@Column(name ="nm_musica", length = 100)
	private String nome;


	@Transient
	private String grauInstrucao;

	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public void setGrauInstrucao(String grauInstrucao) {
		this.grauInstrucao = grauInstrucao;
	}


	public String getGrauInstrucao() {
		return grauInstrucao;
	}

	
	
	
	
}
