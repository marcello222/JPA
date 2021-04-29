package testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import dao.CategoriaDAO;
import dao.ProdutoDAO;
import modelo.Categoria;
import modelo.Produto;
import util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		
		Categoria celulares = new Categoria("CELULARES");

		Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);

//		// Acessa o banco de dados atraves interface EntityManager que vai fazer a
//		// ponte em transformar a entidade produto em uma linha na tabela no banco de dados;
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");
//		EntityManager em = factory.createEntityManager();

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDao = new ProdutoDAO(em);
		CategoriaDAO categoriaDao = new CategoriaDAO(em);

		// EntityManager vai la e antes de persistir pega a transação e inicia.
		em.getTransaction().begin();
		
		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celulares);
		
		em.getTransaction().commit();
		em.close();
	}

}
