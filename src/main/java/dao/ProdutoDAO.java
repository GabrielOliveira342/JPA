package dao;

import model.Produto; //import a classe Produto 

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProdutoDAO {
	//cria uma fabrica de entidades 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("produtoPU"); 
	
	//metodo para criar um novo produto 
	public void criar (Produto produto) {
		EntityManager em = emf.createEntityManager(); //ontem um EntityManager 
		em.getTransaction().begin(); //inicia uma transação 
		em.persist(produto); //persiste o objeto produto
		em.getTransaction().commit(); //confirma a transação 
		em.close(); //fecha o EntityManager 
	}
	//método para buscar um produto no banco 
	public Produto ler (Long id) {
		EntityManager em = emf.createEntityManager(); //obtem um EntityManager
		Produto produto = em.find(Produto.class, id); //busca o produto 
		em.close(); //fecha o EntityManager 
		return produto;
	}
	//método para listar todos os produtos do banco de dados 
	public List<Produto> listarTodos(){
		EntityManager em = emf.createEntityManager();
		// Executa a consulta JPQL para buscar todos os produtos e armazena o resultado
		List<Produto> produtos = em.createQuery("FROM Produto", Produto.class).getResultList();
		em.close(); //fecha o EntityManager
		return produtos;
	}
	//metodo para atualizar o produto 
	public void atualizar (Produto produto) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin(); //inicia uma transação
		em.merge(produto); //atualiza o produto no banco 
		em.getTransaction().commit(); //confirma a transação
		em.close();
	}
	//metodo para excluir um produto no banco de dados 
	public void excluir(Long id) {
		EntityManager em = emf.createEntityManager();
		Produto produto = em.find(Produto.class, id); //busca o produto pelo ID
		if(produto != null) { //verifica se o produto existe 
			em.getTransaction().begin();
			em.remove(produto); //remove o produto do banco de dados 
			em.getTransaction().commit();
		}
		em.close(); //fecha o EntityManager
	}
}
