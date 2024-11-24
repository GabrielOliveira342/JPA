package Main; //pacote do main 

import dao.ProdutoDAO;  //impot do ProdutoDAO
import model.Produto; //model produto 

import java.util.Scanner; //import para receber infromação do usuario

public class Main { //class main 

	public static void main(String[] args) {
		ProdutoDAO produtoDAO = new ProdutoDAO();//instanciando o produto 
		Scanner scanner = new Scanner(System.in);//instanciondo o scanner 
		
		String continuar = "sim";//inicia o loop do while 
		while (continuar.equalsIgnoreCase("sim")) { //entra no loop
			
			Produto produto = new Produto(); //cria um objeto na classe produto 
			System.out.println("Digite o nome do produto: "); //solicita o nome do produto 
			produto.setNome(scanner.nextLine());//armazena no banco de dados produto_db
			
			System.out.println("Digite o preço do produto: "); //solicita o preço do objeto 
			produto.setPreco(scanner.nextDouble()); //armazena no banco de dados produto_db
			scanner.nextLine();
			
			produtoDAO.criar(produto); //salva o produto no banco de dados 
			
			System.out.println("Deseja adicionar outro produto? (sim/não): "); //pergunta se o quer colocar um novo produto
			continuar = scanner.nextLine();
		}
		//exibe a lista de produtos salvos no banco de dados
		
		System.out.println("\nLista de produtos no banco de dados: ");
		produtoDAO.listarTodos().forEach(p -> System.out.println(p.getNome()+" - "+ p.getPreco()));
	
		scanner.close(); //fechar a scanner para liberar recursos 
	}
	
}
