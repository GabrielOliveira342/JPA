package Main;

import dao.ProdutoDAO;
import model.Produto;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Scanner scanner = new Scanner(System.in);
		
		String continuar = "sim";
		while (continuar.equalsIgnoreCase("sim")) {
			
			Produto produto = new Produto();
			System.out.println("Digite o nome do produto: ");
			produto.setNome(scanner.nextLine());
			
			System.out.println("Digite o preço do produto: ");
			produto.setPreco(scanner.nextDouble());
			scanner.nextLine();
			
			produtoDAO.criar(produto);
			
			System.out.println("Deseja adicionar outro produto? (sim/não): ");
			continuar = scanner.nextLine();
		}

		System.out.println("\nLista de produtos no banco de dados: ");
		produtoDAO.listarTodos().forEach(p -> System.out.println(p.getNome()+" - "+ p.getPreco()));
	
		scanner.close();
	}
	
}
