package es.teamM5.cardchamp.dao;

import es.teamM5.cardchamp.model.Club;
import jakarta.persistence.Query;

public class ClubDao extends AbstractDao<Club> {

	public ClubDao() {
		setClazz(Club.class);
	}
	
	public Club selectClubById(int id) {
		String qlString = "FROM " + Club.class.getName() + " WHERE id = ?1 ";
		Query query = getEntityManager().createQuery(qlString).setMaxResults(1); // Equivale a un LIMIT 1
		query.setParameter(1, id);
		return (Club) query.getSingleResult();
	}
	
}
