package locadora_veiculo;

import java.time.LocalDate;

public class Pagamento {
	private LocalDate data;
	private double valor;
	private Locacao locacao;
	private boolean pendente;
	
	public Pagamento(LocalDate data, Locacao locacao) {
		super();
		this.data = data;
		this.locacao = locacao;
		this.valor = locacao.getValor();
		this.pendente = true;
		locacao.getCliente().setRestricao(true);
	}

	void pagar() {
		locacao.getCliente().setRestricao(false);
		this.pendente = false;
	}
	
	public boolean isPendente() {
		return pendente;
	}

	public void setPendente(boolean emAberto) {
		this.pendente = emAberto;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Locacao getLocacao() {
		return locacao;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}

	@Override
	public String toString() {
		return "Pagamento [data=" + data + ", valor=" + valor + ", pendente=" + pendente + "]";
	}
	
	
}
