package locadora_veiculo;

public class Moto extends Veiculo {
	
	private boolean acessorios;
	
	public Moto(String placa, String cor, int ano,String ac) {
		super(placa, ano, cor);
		// TODO Auto-generated constructor stub
		if(ac == "s") {
			this.acessorios = true;
		}else {
			this.acessorios = false;
		}
	}

	public void calculaValorLocacao() {
		if(this.acessorios == true)
			super.valorLocacao = super.valorLocacao+150;
		}

	public boolean isAcessorios() {
		return acessorios;
	}

	public void setAcessorios(boolean acessorios) {
		this.acessorios = acessorios;
	}

	@Override
	public String toString() {
		return "Moto [placa=" + placa + ", ano=" + ano + ", cor=" + cor + ", valorLocacao=" + valorLocacao
				+ ", acessorios=" + acessorios + "]";
	}

	
	



}
