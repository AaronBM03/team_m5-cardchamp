package es.teamM5.cardchamp;

import es.teamM5.cardchamp.dao.CardDao;
import es.teamM5.cardchamp.dao.ClubDao;
import es.teamM5.cardchamp.dao.NationDao;
import es.teamM5.cardchamp.model.Card;
import es.teamM5.cardchamp.model.Club;
import es.teamM5.cardchamp.model.Nation;

public class SQLiteTest {

	public static void main(String[] args) {
		CardDao cDao = new CardDao();
		NationDao nDao = new NationDao();
		ClubDao clDao = new ClubDao();
		
		int joseId = 1;
		
//		Club dam = new Club(1, "GDAM");
//		clDao.save(dam);
//		
//		Nation espana = new Nation(1, "Espanhita");
//		nDao.save(espana);
//		
//		Card jose = new Card(joseId, "Jose Godino", espana, Color.BRONZE, 1, Position.CM, 65, 53, 60, 68, 70, 30, 50);
//		System.out.println(jose);
//		cDao.save(jose);
		
		Club dam = clDao.selectClubById(joseId);
		Nation espana = nDao.selectNationById(joseId);
		Card jose = cDao.getCardById(joseId);
		System.err.println(espana);
		System.err.println(jose);
		System.err.println(dam);
		
		jose.setClub(dam);
		cDao.update(jose);
		
		jose = cDao.getCardById(joseId);
		
		System.err.println(jose);
	}

}
