package locadora_veiculo;

public class Funcionario extends Pessoa {
	protected int id;
	protected double salario;
	
	public Funcionario(String nome,String cpf, int id, double salario) {
		super(nome,cpf);
		this.id = id;
		this.nome = nome;
		this.salario = salario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	

	
	
	
}
