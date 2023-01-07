package es.teamM5.cardchamp.dao;

import es.teamM5.cardchamp.model.Nation;
import jakarta.persistence.Query;

public class NationDao extends AbstractDao<Nation> {

	public NationDao() {
		setClazz(Nation.class);
	}
	
	//Nation.class.getName()
	public Nation selectNationById(int id) {
		String qlString = "FROM " + Nation.class.getName() + " WHERE id = ?1 ";
		Query query = getEntityManager().createQuery(qlString).setMaxResults(1); // Equivale a un LIMIT 1
		query.setParameter(1, id);
		return (Nation) query.getSingleResult();
	}
	
}
