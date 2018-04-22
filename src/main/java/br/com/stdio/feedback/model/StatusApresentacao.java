package br.com.stdio.feedback.model;

public enum StatusApresentacao {

	ATIVA("Ativa"),
	INATIVA("Inativa");
	
	private String descricao;

	private StatusApresentacao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
