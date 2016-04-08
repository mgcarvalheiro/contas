package br.com.marcelocarvalheiro.contas.model;

import java.util.Calendar;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Conta {
	
	private Long id;

	@NotNull(message="{conta.formulario.descricao.obrigatoria}") 
	@Size(min=5, message="{conta.formulario.descricao.tamanho}")
	private String descricao;

	private boolean paga;
	
	//@NotNull(message="{conta.formulario.valor.obrigatorio}") 
	//@DecimalMin(value="0.01", message="{conta.formulario.valor.maior.zero}")
	private double valor;

	private Calendar dataPagamento;
	
	private TipoDaConta tipo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isPaga() {
		return paga;
	}

	public void setPaga(boolean paga) {
		this.paga = paga;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Calendar getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Calendar dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public TipoDaConta getTipo() {
		return tipo;
	}

	public void setTipo(TipoDaConta tipo) {
		this.tipo = tipo;
	}

}
