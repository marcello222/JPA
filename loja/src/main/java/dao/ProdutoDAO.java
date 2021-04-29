package dao;

import javax.persistence.EntityManager;

import modelo.Categoria;

public class ProdutoDAO {
	
	private EntityManager em;

	public ProdutoDAO(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Categoria celulares) {
		this.em.persist(celulares);
		
	}

}
