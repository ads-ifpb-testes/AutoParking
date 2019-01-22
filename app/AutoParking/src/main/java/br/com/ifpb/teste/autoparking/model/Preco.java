package br.com.ifpb.teste.autoparking.model;

public class Preco {
	private boolean precoFixo;
	private long duracaoInicial;
	private long duracaoFinal;
	private double precoPorHora;
	public Preco() {
	}
	public Preco(boolean precoFixo, long duracaoInicial, long duracaoFinal, double precoPorHora) {
		super();
		this.precoFixo = precoFixo;
		this.duracaoInicial = duracaoInicial;
		this.duracaoFinal = duracaoFinal;
		this.precoPorHora = precoPorHora;
	}
	public boolean isPrecoFixo() {
		return precoFixo;
	}
	public void setPrecoFixo(boolean precoFixo) {
		this.precoFixo = precoFixo;
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
