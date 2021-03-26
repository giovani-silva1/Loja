package com.devgiovani.loja.domain.enums;

public enum EstadoPagamento {

	PENDENTE(1, "Pendente"), 
	QUITADO(2, "Quitado"), 
	CANCELADO(3, "Cancelado");

	private int cod;
	private String nome;

	private EstadoPagamento() {

	}

	private EstadoPagamento(int cod, String nome) {
		this.cod = cod;
		this.nome = nome;
	}

	public int getCod() {
		return cod;
	}

	public String getNome() {
		return nome;
	}

	public static EstadoPagamento toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}

		for (EstadoPagamento estadoPagamento : EstadoPagamento.values()) {
			if (estadoPagamento.getCod() == cod) {
				return estadoPagamento;
			}
		}
		throw new IllegalArgumentException("Id não encontrado" + cod);
	}

}
