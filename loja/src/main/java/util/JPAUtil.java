package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//Objetivo da classe é isolar a criação do EntityManager e esconder o EntityManagerFactory
public class JPAUtil {

	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("loja");

	// metodo que cria o EntityManager
	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();

	}

}
