package br.com.stdio.feedback.domain.enums;

public enum Perfil {
	ADM(1, "ROLE_ADMIN");

	private int codigo;
	private String descricao;

	private Perfil(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public static Perfil toEnum(Integer x) {
		
		return Perfil.ADM;
	}

}
