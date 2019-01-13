package br.com.ifpb.teste.auto_parking.model;

import java.time.LocalDateTime;

public class Pagamento {
	
	public enum TipoPagamento{CREDITO, AVULSO}
	
	private LocalDateTime dhPagamento;
	private double valor;
	private TipoPagamento tipoPagamento;
	private int idServico;
	private String cpfCliente;
	
	public Pagamento() {
	}

	public Pagamento(LocalDateTime dhPagamento, double valor, int idServico) {
		this.tipoPagamento = TipoPagamento.AVULSO;
		this.dhPagamento = dhPagamento;
		this.valor = valor;
		this.idServico = idServico;
	}

	public Pagamento(LocalDateTime dhPagamento, double valor, String cpfCliente) {
		this.tipoPagamento = TipoPagamento.CREDITO;
		this.dhPagamento = dhPagamento;
		this.valor = valor;
		this.cpfCliente = cpfCliente;
	}

	public LocalDateTime getDhPagamento() {
		return dhPagamento;
	}

	public void setDhPagamento(LocalDateTime dhPagamento) {
		this.dhPagamento = dhPagamento;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public int getIdServico() {
		return idServico;
	}

	public void setIdServico(int idServico) {
		this.idServico = idServico;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	@Override
	public String toString() {
		return "Pagamento [dhPagamento=" + dhPagamento + ", valor=" + valor + ", tipoPagamento=" + tipoPagamento
				+ ", idServico=" + idServico + ", cpfCliente=" + cpfCliente + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpfCliente == null) ? 0 : cpfCliente.hashCode());
		result = prime * result + ((dhPagamento == null) ? 0 : dhPagamento.hashCode());
		result = prime * result + idServico;
		result = prime * result + ((tipoPagamento == null) ? 0 : tipoPagamento.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Pagamento other = (Pagamento) obj;
		if (cpfCliente == null) {
			if (other.cpfCliente != null)
				return false;
		} else if (!cpfCliente.equals(other.cpfCliente))
			return false;
		if (dhPagamento == null) {
			if (other.dhPagamento != null)
				return false;
		} else if (!dhPagamento.equals(other.dhPagamento))
			return false;
		if (idServico != other.idServico)
			return false;
		if (tipoPagamento != other.tipoPagamento)
			return false;
		if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
			return false;
		return true;
	}	
		
}
