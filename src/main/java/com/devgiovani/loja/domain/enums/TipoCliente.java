package com.devgiovani.loja.domain.enums;

public enum TipoCliente {

	PESSOAFISICA(1, "Pessoa Física"), PESSOAJURÍDICA(2, "Pessoa Juridica");

	private int cod;
	private String nome;

	private TipoCliente() {

	}

	private TipoCliente(int cod, String nomeTipo) {
		this.cod = cod;
		this.nome = nomeTipo;
	}

	public int getCod() {
		return cod;
	}

	public String getNome() {
		return nome;
	}

	public static TipoCliente toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (TipoCliente x : TipoCliente.values()) {
			if (cod.equals(x)) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id não encontrado" + cod);
	}

}
