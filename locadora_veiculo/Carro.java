package locadora_veiculo;

public class Carro extends Veiculo {
	
	private boolean arcondicionado;
	
	public Carro(String placa, String cor, int ano,String ar) {
		super(placa, ano, cor);
		// TODO Auto-generated constructor stub
		if(ar == "s") {
			this.arcondicionado = true;
		}else {
			this.arcondicionado = false;
		}	
	}

	
	public void calculaValorLocacao() {
		if(this.arcondicionado == true)
			super.valorLocacao = super.valorLocacao+100;
		}


	public boolean isArcondicionado() {
		return arcondicionado;
	}


	public void setArcondicionado(boolean arcondicionado) {
		this.arcondicionado = arcondicionado;
	}


	@Override
	public String toString() {
		return "Carro [placa=" + placa + ", ano=" + ano + ", cor=" + cor + ", valorLocacao=" + valorLocacao
				+ ", arcondicionado=" + arcondicionado + "]";
	}


	
	
	
	
}
