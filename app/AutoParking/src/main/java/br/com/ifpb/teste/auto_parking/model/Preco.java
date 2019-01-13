package br.com.ifpb.teste.auto_parking.model;

public class Preco {
	private boolean precoPadrao;
	private long duracaoInicial;
	private long duracaoFinal;
	private double precoPorHora;
	public Preco() {
	}
	public Preco(boolean precoPadrao, long duracaoInicial, long duracaoFinal, double precoPorHora) {
		this.precoPadrao = precoPadrao;
		this.duracaoInicial = duracaoInicial;
		this.duracaoFinal = duracaoFinal;
		this.precoPorHora = precoPorHora;
	}
	public boolean isPrecoPadrao() {
		return precoPadrao;
	}
	public void setPrecoPadrao(boolean precoPadrao) {
		this.precoPadrao = precoPadrao;
	}
	public long getDuracaoInicial() {
		return duracaoInicial;
	}
	public void setDuracaoInicial(long duracaoInicial) {
		this.duracaoInicial = duracaoInicial;
	}
	public long getDuracaoFinal() {
		return duracaoFinal;
	}
	public void setDuracaoFinal(long duracaoFinal) {
		this.duracaoFinal = duracaoFinal;
	}
	public double getPrecoPorHora() {
		return precoPorHora;
	}
	public void setPrecoPorHora(double precoPorHora) {
		this.precoPorHora = precoPorHora;
	}
	@Override
	public String toString() {
		return "Preco [precoPadrao=" + precoPadrao + ", duracaoInicial=" + duracaoInicial + ", duracaoFinal="
				+ duracaoFinal + ", precoPorHora=" + precoPorHora + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (duracaoFinal ^ (duracaoFinal >>> 32));
		result = prime * result + (int) (duracaoInicial ^ (duracaoInicial >>> 32));
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
		Preco other = (Preco) obj;
		if (duracaoFinal != other.duracaoFinal)
			return false;
		if (duracaoInicial != other.duracaoInicial)
			return false;
		return true;
	}	
}
