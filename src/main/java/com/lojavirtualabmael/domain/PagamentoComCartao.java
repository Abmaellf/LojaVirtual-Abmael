package com.lojavirtualabmael.domain;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.lojavirtualabmael.domain.enuns.EstadoPagamento;

@Entity
@JsonTypeName("pagamentoComCartao") 
public class PagamentoComCartao extends Pagamento {
	
	private static final long serialVersionUID = 1L;
	
	private Integer numerosDeParcelas;
	
	public PagamentoComCartao() {
		
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numerosDeParcelas) {
		super(id, estado, pedido);
		this.numerosDeParcelas = numerosDeParcelas;
	}
	
	
}
