package locadora_veiculo;

import java.sql.Date;
import java.time.LocalDate;

public class Locacao {
	
	private double valor;
	private LocalDate dataSaida;
    private LocalDate dataEntrega;
    private Cliente cliente;
	private Funcionario funcionario;
	private Veiculo veiculo;
	
	public Locacao(Cliente cliente, Funcionario funcionario,Date data,
			Veiculo veiculo, int dias) {
    	LocalDate entrega = data.toLocalDate().plusDays(dias);
    	
		this.dataSaida = data.toLocalDate();
		this.dataEntrega = entrega;
		this.cliente = cliente;
		this.funcionario = funcionario;
		this.veiculo = veiculo;
		this.valor = veiculo.getValorLocacao()*dias;
		cliente.setRestricao(true);
	}
	

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}


	@Override
	public String toString() {
		return "Locacao [valor=" + valor + ", dataSaida=" + dataSaida + ", dataEntrega=" + dataEntrega + ", cliente="
				+ cliente + ", funcionario=" + funcionario.nome + ", veiculo=" + veiculo + "]";
	}


	

	
}
