package dao;

import javax.persistence.EntityManager;

import modelo.Categoria;

public class CategoriaDAO {

	private EntityManager em;

	public CategoriaDAO(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Categoria categoria) {
		this.em.persist(categoria);

	}

	// Esse metodo é para garantir que a categoria estara no estado merge
	public void atualizar(Categoria categoria) {
		this.em.merge(categoria);

	}

	public void remove(Categoria categoria) {
		// Esse metodo é para garantir que a categoria estara no estado MENAGED
		categoria = em.merge(categoria);
		this.em.remove(categoria);

	}
}
