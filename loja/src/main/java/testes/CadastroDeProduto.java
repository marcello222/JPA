package testes;

import javax.persistence.EntityManager;

import modelo.Categoria;
import util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		Categoria celulares = new Categoria("CELULARES");

		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();

		em.persist(celulares);

		// update após o persist
		celulares.setNome("XPTO");

		// flush para sincronizar com banco de dados
		em.flush();
		// clear para limpar
		em.clear();

		// retorna a entidade criada do estado DETACHED para o MANAGER
		celulares = em.merge(celulares);
		celulares.setNome("1234");
		em.flush();
		em.clear();
		em.remove(celulares);
		em.flush();

	}

}
