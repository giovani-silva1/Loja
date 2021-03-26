package com.devgiovani.loja.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.devgiovani.loja.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento {


	private static final long serialVersionUID = 1L;
	private Date dataVencimento;
	private Date dataPagamento;
	
	
	public PagamentoComBoleto() {
		
	}


	public PagamentoComBoleto(Integer id, EstadoPagamento estadoPagamento, Pedido pedido, Date datavencimento,Date dataPagamento) {
		super(id, estadoPagamento, pedido);
		this.dataVencimento = datavencimento;
		this.dataPagamento = dataPagamento;
	}


	public Date getDataVencimento() {
		return dataVencimento;
	}


	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}


	public Date getDataPagamento() {
		return dataPagamento;
	}


	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	
	
	
	
	
	
}
