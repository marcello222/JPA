package testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import dao.ProdutoDAO;
import modelo.Produto;
import util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		Produto celular = new Produto();
		celular.setNome("Xiaomi Redmi");
		celular.setDescricao("Muito legal");
		celular.setPreco(new BigDecimal("800"));

//		// Acessa o banco de dados atraves interface EntityManager que vai fazer a
//		// ponte em transformar a entidade produto em uma linha na tabela no banco de dados;
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");
//		EntityManager em = factory.createEntityManager();
		
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO dao = new ProdutoDAO(em);
		
		//EntityManager vai la e antes de persistir pega a transação e inicia. 
		em.getTransaction().begin();		
		dao.cadastrar(celular);
		em.getTransaction().commit();
		em.close();
	}

}
