package es.teamM5.cardchamp;

public class Queries
{
	private static final int VARIABLE_CARD_AVG = 5;

	// *********************** QUERIES FROM TABLE <nation> ********************************************************************
	public static final String SELECT_NATION_NAME_BY_ID = " SELECT name FROM nation WHERE id = "; // Concat the id
	public static final String SELECT_NATION_ID_BY_NAME = " SELECT id FROM nation WHERE name = "; // Concat the name

	// *********************** QUERIES FROM TABLE <club> **********************************************************************
	public static final String SELECT_CLUB_NAME_BY_ID = " SELECT name FROM club WHERE id = "; // Concat the id
	public static final String SELECT_CLUB_ID_BY_NAME = " SELECT id FROM club WHERE name = "; // Concat the name

	// *********************** QUERIES FROM TABLE <match> *********************************************************************
	
	
	// *********************** QUERIES FROM TABLE <championship> **************************************************************
	
	
	// *********************** QUERIES FROM TABLE <card> **********************************************************************
	public static final String SELECT_NAME_BY_ID = " SELECT name FROM card WHERE id = "; // Concat the id
	public static final String SELECT_RARITY_BY_ID = " SELECT rarity FROM card WHERE id = "; // Concat the id
	public static final String SELECT_CARD_AVG_BY_ID = " SELECT cardAvg FROM card WHERE id = "; // Concat the id
	public static final String SELECT_RATING_BY_ID = " SELECT rating FROM card WHERE id = "; // Concat the id
	public static final String SELECT_PACE_BY_ID = " SELECT pace FROM card WHERE id = "; // Concat the id
	public static final String SELECT_SHOOTING_BY_ID = " SELECT shooting FROM card WHERE id = "; // Concat the id
	public static final String SELECT_PASSING_BY_ID = " SELECT passing FROM card WHERE id = "; // Concat the id
	public static final String SELECT_DRIBBLING_BY_ID = " SELECT dribbling FROM card WHERE id = "; // Concat the id
	public static final String SELECT_DEFENDING_BY_ID = " SELECT defending FROM card WHERE id = "; // Concat the id
	public static final String SELECT_PHYSICALITY_BY_ID = " SELECT physicality FROM card WHERE id = "; // Concat the id
	public static final String SELECT_COLOR_BY_ID = " SELECT color FROM card WHERE id = "; // Concat the id
	public static final String SELECT_POSITION_BY_ID = " SELECT position FROM card WHERE id = "; // Concat the id
	public static final String SELECT_ID_BY_NAME = " SELECT id FROM card WHERE name = "; // Concat the name

	public String selectIdByColorAndCardAvg(String color, int cardAvg)
	{
		int lowCardAvg = cardAvg - VARIABLE_CARD_AVG;
		int highCardAvg = cardAvg + VARIABLE_CARD_AVG;
		
		return " SELECT id FROM card WHERE color = " + color + " AND cardAvg BETWEEN " + lowCardAvg + " AND " + highCardAvg + " LIMIT 1 "; 
	}
}
