package es.teamM5.cardchamp.dao;

import es.teamM5.cardchamp.model.Card;
import jakarta.persistence.Query;

public class CardDao extends AbstractDao<Card> {

	public CardDao() {
		setClazz(Card.class);
	}
	
	//Card.class.getName()
	public Card getCardById(int id) {
		String qlString = "FROM " + Card.class.getName() + " WHERE id = ?1 ";
		Query query = getEntityManager().createQuery(qlString).setMaxResults(1); // Equivale a un LIMIT 1
		query.setParameter(1, id);
		return (Card) query.getSingleResult();
	}
	
	
	
}
