package br.com.ifpb.teste.auto_parking.model;

import java.time.LocalDateTime;

public class Estacionamento {
	private int id;
	private boolean quitado;
	private boolean finalizado; 
	private String placa;
	private LocalDateTime dhChegada;
	private LocalDateTime dhPagamento;
	private LocalDateTime dhSaida;
	private Double valor;
	
	public Estacionamento() {
	}

	public Estacionamento(String placa) {	
		this.placa = placa;
		this.finalizado = false;
		this.dhChegada = LocalDateTime.now();
		this.valor = 0.0;
	}

	public Estacionamento(int id, String placa) {
		this.id = id;
		this.placa = placa;
		this.finalizado = false;
		this.dhChegada = LocalDateTime.now();
		this.valor = 0.0;
	}
	
	public Estacionamento(int id, boolean quitado, boolean finalizado, String placa, LocalDateTime dhChegada,
			LocalDateTime dhPagamento, LocalDateTime dhSaida, Double valor) {
		super();
		this.id = id;
		this.quitado = quitado;
		this.finalizado = finalizado;
		this.placa = placa;
		this.dhChegada = dhChegada;
		this.dhPagamento = dhPagamento;
		this.dhSaida = dhSaida;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isQuitado() {
		return quitado;
	}

	public void setQuitado(boolean quitado) {
		this.quitado = quitado;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public LocalDateTime getDhChegada() {
		return dhChegada;
	}

	public void setDhChegada(LocalDateTime dhChegada) {
		this.dhChegada = dhChegada;
	}

	public LocalDateTime getDhPagamento() {
		return dhPagamento;
	}

	public void setDhPagamento(LocalDateTime dhPagamento) {
		this.dhPagamento = dhPagamento;
	}

	public LocalDateTime getDhSaida() {
		return dhSaida;
	}

	public void setDhSaida(LocalDateTime dhSaida) {
		this.dhSaida = dhSaida;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Estacionamento [id=" + id + ", finalizado=" + finalizado + ", placa=" + placa + ", dhChegada="
				+ dhChegada + ", dhPagamento=" + dhPagamento + ", dhSaida=" + dhSaida + ", valor=" + valor + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estacionamento other = (Estacionamento) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
