package dao;

import javax.persistence.EntityManager;

import modelo.Categoria;

public class CategoriaDAO {

	private EntityManager em;

	public CategoriaDAO(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Categoria celulares) {
		this.em.persist(celulares);

	}

}
