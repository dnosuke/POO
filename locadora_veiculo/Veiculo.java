package locadora_veiculo;

public class Veiculo {
	protected String placa;
	protected int ano;
	protected String cor;
	protected double valorLocacao=100.0;
	
	public Veiculo(String placa, int ano, String cor) {
		super();
		this.placa = placa;
		this.ano = ano;
		this.cor = cor;
		
	}



	public String getPlaca() {
		return placa;
	}



	public void setPlaca(String placa) {
		this.placa = placa;
	}



	public int getAno() {
		return ano;
	}



	public void setAno(int ano) {
		this.ano = ano;
	}



	public String getCor() {
		return cor;
	}



	public void setCor(String cor) {
		this.cor = cor;
	}



	public double getValorLocacao() {
		return valorLocacao;
	}



	public void setValorLocacao(double valorLocacao) {
		this.valorLocacao = valorLocacao;
	}

	public void calculaValorLocacao() {
		
	}

	@Override
	public String toString() {
		return "Veiculo [placa=" + placa + ", ano=" + ano + ", cor=" + cor + ", valorLocacao=" + valorLocacao + "]";
	}




	
}
