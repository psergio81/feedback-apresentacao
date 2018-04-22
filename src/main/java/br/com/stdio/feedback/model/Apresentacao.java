package br.com.stdio.feedback.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Apresentacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String titulo;

	@Column(length = 500)
	private String descricao;
	private String apresentador;

	@Transient
	private Long totalVotos;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getApresentador() {
		return apresentador;
	}

	public void setApresentador(String apresentador) {
		this.apresentador = apresentador;
	}

	public Long getTotalVotos() {
		return totalVotos;
	}
	
	public void setTotalVotos(Long totalVotos) {
		this.totalVotos = totalVotos;
	}

	

}
