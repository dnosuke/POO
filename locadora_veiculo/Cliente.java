package locadora_veiculo;

public class Cliente extends Pessoa {
	private boolean restricao;
	private String telefone;
	
	public Cliente(String nome,String cpf, String telefone) {
		super(nome,cpf);
		this.telefone = telefone;
		this.restricao = false;
		
	}


	public boolean isRestricao() {
		return restricao;
	}


	public void setRestricao(boolean restricao) {
		this.restricao = restricao;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + ", restricao=" + restricao + "]";
	}


	


	
}
