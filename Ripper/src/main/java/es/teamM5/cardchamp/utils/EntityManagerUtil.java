package es.teamM5.cardchamp.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerUtil {
	public static EntityManager getEntityManager() {
		// El nombre dado para la EntityManagerFactory debe tener el mismo nombre que la
		// persistence-unit en persistence.xml
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CardChamp");
		EntityManager entityManager = factory.createEntityManager();
		return entityManager;
	}
	
	public static void main(String[] args) {
		EntityManager em = getEntityManager();
		System.out.println("EntityManager class => " + em.getClass().getCanonicalName());
	}
}

