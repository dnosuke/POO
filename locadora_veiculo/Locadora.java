package locadora_veiculo;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Locadora {
	ArrayList<Veiculo> veiculo;
	ArrayList<Cliente> cliente;
	ArrayList<Pagamento> pagamento;
	ArrayList<Locacao> locacao;
	ArrayList<Funcionario> funcionario;
	
	Locadora() {
		veiculo = new ArrayList<>();
		cliente = new ArrayList<>();
		pagamento = new ArrayList<>();
		locacao = new ArrayList<>();
		funcionario = new ArrayList<>();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Locadora e=new Locadora();
		
		Funcionario maria= new Funcionario("Maria", "1234-12", 1, 1000.0);
		e.funcionario.add(maria);
		Funcionario jean= new Funcionario("Jean", "4567-32", 2, 1000.0);
		e.funcionario.add(jean);
		Veiculo teste = new Carro("no12","red",2000,"s");
		e.adicionaVeiculo(teste);
		Cliente testeC = new Cliente("Joao", "12234-34", "1234-0988");
		 e.adicionaCliente(testeC);
		
				Veiculo v1;
				Cliente c;
				Locacao l;
				Pagamento p;
				int op = 0;
				while(true) {
					System.out.println("\n================MENU==================");
					System.out.println("Escolha o que deseja fazer:\n"
							+ "1- Cadastrar Veiculo.\n"
							+ "2- Cadastrar Cliente.\n"
							+ "3- Cadastrar Locacao.\n"
							+ "4- Cadastrar Devolução .\n"
							+ "5- Efetuar Pagamento.\n"
							+ "6- Listas de cadastro."
							);
					System.out.println("==================================");
					
					
					 op = in.nextInt();			

					
					switch(op) {
						case 1:
							System.out.println("================Cadastro de Veiculo==================");
							System.out.println("Escolha o tipo de veiculo:\n"
									+ "1- Carro.\n"
									+ "2- Moto.\n"
									);
									
							System.out.println("=====================================================");
							int ad = in.nextInt();
							
							switch(ad) {
								case 1:
									System.out.print("Placa: ");
									String placa = in.next();
									System.out.print("Cor: ");
									String cor = in.next();
									System.out.print("Ano: ");
									int ano = in.nextInt();
									System.out.print("Ar-condicionado: (s/n) ");
									String ar = in.next();	
								
									v1 = new Carro(placa,cor,ano,ar);
									e.adicionaVeiculo(v1); 
									e.RelatorioVeiculos();
									break;
								case 2:
									System.out.print("Placa: ");
									String placaM = in.next();
									System.out.print("Cor: ");
									String corM = in.next();
									System.out.print("Ano: ");
									int anoM = in.nextInt();
									System.out.print("Acessorios: (s/n) ");
									String ac = in.next();	
									
									v1 = new Moto(placaM,corM,anoM,ac);
									e.adicionaVeiculo(v1);
									e.RelatorioVeiculos();
									break;
						
							}//FIM DO SWITCH AD
							break;	
						case 2:
							System.out.println("================Cadastro de Cliente==================");
							System.out.print("Nome: ");
							String nome = in.next();
							System.out.print("CPF: ");
							String cpf = in.next();
							System.out.print("Telefone: ");
							String telefone = in.next();
							
							 c = new Cliente(nome, cpf, telefone);
							 e.adicionaCliente(c);
							 e.RelatorioClientes();
							System.out.println("=====================================================");
							break;
						case 3:
							System.out.println("================Cadastro de Locacao==================");
							System.out.print("Data: yyyy-mm-dd ");
							String dataS = in.next();
							Date data =Date.valueOf(dataS);
							LocalDate dat = data.toLocalDate();
							dat.format(formatador);
							System.out.print("N° do Cliente: ");
							int n_cli = in.nextInt();
							Cliente C = e.cliente.get(n_cli);
							verificarCliente(e,n_cli, dat, C);
							if(C.isRestricao() == false) {
							System.out.print("N° Funcionario: ");
							int n_fun = in.nextInt();
							Funcionario F = e.funcionario.get(n_fun);
							
							System.out.print("N° Veiculo: ");
							int n_vei = in.nextInt();
							Veiculo V = e.veiculo.get(n_vei);
							System.out.print("Quantidade de dias: ");
							int dias = in.nextInt();
							V.calculaValorLocacao();
							 l = new Locacao(C,F,data,V,dias);
							 e.adicionaLocacao(l);
							 e.RelatorioLocacao();
							System.out.println("=====================================================");
							}else {
								System.out.println("Cliente possui restrição para Locações.\n");
							}
							break;
						
						case 4:
							System.out.println("================Cadastrar Devolução==================");
							System.out.print("Data: yyyy-mm-dd");
							String dataD = in.next();
							Date data2 =Date.valueOf(dataD);
							LocalDate dataDev = data2.toLocalDate();
							System.out.print("N° da Locacao: ");
							int n_loc = in.nextInt();
							Locacao L = e.locacao.get(n_loc);
							
							p = new Pagamento(dataDev,L);
							e.adicionaPagamento(p);
							e.RelatorioPagamento();
							System.out.println("=====================================================");
							break;
							
						case 5:
							System.out.println("================Efetuar Pagamento==================");
							System.out.print("N° do Pagamento: ");
							int n_pag = in.nextInt();
							Pagamento P = e.pagamento.get(n_pag);
							System.out.println("Efetuar pagamento? (s/n)");
							in.nextLine();
							String pagar = in.next();
							if(pagar == "s") {
								P.pagar();
							}else {
								System.out.println("Pagamento cancelado.\n");
							}
							break;
						case 6:
							System.out.println("\n================Relatorios==================");
							System.out.println("Escolha o que deseja fazer:\n"
									+ "1- Mostrar Clientes.\n"
									+ "2- Mostrar Veiculos.\n"
									+ "3- Mostrar Funcionarios.\n"
									+ "4- Mostrar Locações.\n"
									+ "5- Mostrar Pagamentos."
									);
							System.out.println("==================================");
							int relatorio = in.nextInt();
							switch(relatorio) {	
								case 1:
									if(e.cliente.isEmpty()) {
										System.out.println("Nenhum cliente cadastrado.\n");
									}else {
										e.RelatorioClientes();
									}
									break;
								case 2:
									if(e.cliente.isEmpty()) {
										System.out.println("Nenhum veiculo cadastrado.\n");
									}else {
										e.RelatorioVeiculos();
									}
									break;
								case 3:
									if(e.cliente.isEmpty()) {
										System.out.println("Nenhum Funcionario cadastrado.\n");
									}else {
										e.RelatorioFuncionario();
									}
									break;
								case 4:
									if(e.cliente.isEmpty()) {
										System.out.println("Nenhum locação cadastrada.\n");
									}else {
										e.RelatorioLocacao();
									}
									break;
								case 5:
									if(e.cliente.isEmpty()) {
										System.out.println("Nenhum pagamento cadastrado.\n");
									}else {
										e.RelatorioPagamento();
									}
									break;
								default:
									System.out.println("Escolha inválida.\n");
							}//FIM DO SWITCH RELATORIO
							break;
					}//FIM DO SWITCH OP		
				}//FIM DO WHILE	
	}//FIM DO MAIN
	
				void RelatorioFuncionario() {
					for (int i=0;i<funcionario.size();i++){
						System.out.println(funcionario.get(i));
						}
		
	}
				void adicionaPagamento(Pagamento pag) {
					  pagamento.add(pag);
		
	}
				void adicionaLocacao(Locacao loc) {
					 locacao.add(loc);
		
	}
				void adicionaVeiculo(Veiculo vei) {
					veiculo.add(vei);
				}
				void adicionaCliente(Cliente cli) {
					cliente.add(cli);
				}
				
				void RelatorioVeiculos() {
					for (int i=0;i<veiculo.size();i++){
						System.out.println(veiculo.get(i));
						}
					}
					
				void RelatorioClientes() {
						for (int i=0;i<cliente.size();i++){
							System.out.println(cliente.get(i));
						}
				}
				void RelatorioLocacao() {
							for (int i=0;i<locacao.size();i++){
								System.out.println(locacao.get(i));
							}
				}
				
				void RelatorioPagamento() {
					for (int i=0;i<pagamento.size();i++){
						System.out.println(pagamento.get(i));
					}
		}	
				//verifica se o cliente ja possui locaçoes cadastradas, locações diferentes de um mesmo cliente so podem ser feitas na mesma data
				static void verificarCliente(Locadora e,int numero,LocalDate dataS,Cliente cliente) {	
					
					Locacao loca = null;
					for(int i=0;i<e.locacao.size();i++) {
						if (e.locacao.get(numero)!=null)
							loca = e.locacao.get(numero);
							if(cliente.equals(loca.getCliente()))  
								if(dataS.isAfter(loca.getDataSaida())) {
									cliente.setRestricao(true);
									System.out.println("----Cliente "+cliente.getNome()+" está pendente.----\n");
									break;
									}else {	
										cliente.setRestricao(false);
										System.out.println("----Cliente "+cliente.getNome() +" nao possui pendências.----\n");
										break;
									}//FIM DO ELSE			
					}//FIM DO FOR
					}//FIM DA FUNÇÃO
}//FIM LOCADORA
