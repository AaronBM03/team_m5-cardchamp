package es.teamM5.cardchamp.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

/**
 * This class represents the entire set of data related to a player card
 * 
 * @author Miguel Rubio
 * @author Aaron Blanco
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "card")
public class Card {
//	public static final List<Integer> SUPPORTED_RARITIES = Arrays.asList(new Integer[] {0, 1, 12});
	
	public static Map<Integer, Nation> nationsMap;
	
	@Id
	private int id;
	@JsonProperty("commonName")
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Club club;
	
	@JsonProperty("club")
	@Transient
	private int clubId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Nation nation;
	
	@JsonProperty("nation")
	@Transient
	private int nationId;
	
	private Color color;
	private int rarity;
	private Position position;
	private int cardAvg;
	private int rating;
	private int pace;
	private int shooting;
	private int passing;
	private int dribbling;
	private int defending;
	private int physicality;

	public Card() {
	}
	
	

	public Card(int id, String name, Nation nation, Color color, int rarity, Position position, int rating,
			int pace, int shooting, int passing, int dribbling, int defending, int physicality) {
		super();
		this.id = id;
		this.name = name;
		this.nation = nation;
		this.color = color;
		this.rarity = rarity;
		this.position = position;
		this.rating = rating;
		this.pace = pace;
		this.shooting = shooting;
		this.passing = passing;
		this.dribbling = dribbling;
		this.defending = defending;
		this.physicality = physicality;
		this.updateCardAvg();
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@JsonProperty("commonName")
	public String getName() {
		return name;
	}

	@JsonProperty("commonName")
	public void setName(String name) {
		this.name = name;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	@JsonProperty("club")
	public int getClubId() {
		return clubId;
	}

	@JsonProperty("club")
	public void setClubId(int clubId) {
		this.clubId = clubId;
	}

	public Nation getNation() {
		return nation;
	}

	public void setNation(Nation nation) {
		this.nation = nation;
	}
	
	@JsonProperty("nation")
	public int getNationId() {
		return nationId;
	}

	@JsonProperty("nation")
	public void setNationId(int nationId) {
		this.nationId = nationId;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		if(this.color == null) {
			this.color = color;
		}
	}

	public int getRarity() {
		return rarity;
	}

	public void setRarity(int rarity) {
		this.rarity = rarity;
		if(rarity == 12) {
			this.color = Color.ICON;
		}
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}


	public int getCardAvg() {
		return cardAvg;
	}

	private void updateCardAvg() {
		this.cardAvg = (pace + shooting + passing + dribbling + defending + physicality) / 6;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	/**
	 * This function returns a statistic value depending on the Stats class
	 * @param stat Statistic enumeration value for the desired stat
	 * @return Returns the intended value for the stat or -1 in case of error
	 */
	public int getStat(Stats stat) {
		switch (stat) {
			case DEF:
				return defending;
			case DRI:
				return dribbling;
			case PAC:
				return pace;
			case PAS:
				return passing;
			case PHI:
				return physicality;
			case SHO:
				return shooting;
			default:
				return -1;
		}
	}

	public int getPace() {
		return pace;
	}

	public void setPace(int pac) {
		this.pace = pac;
		updateCardAvg();
	}

	public int getShooting() {
		return shooting;
	}

	public void setShooting(int sho) {
		this.shooting = sho;
		updateCardAvg();
	}

	public int getPassing() {
		return passing;
	}

	public void setPassing(int pas) {
		this.passing = pas;
		updateCardAvg();
	}

	public int getDribbling() {
		return dribbling;
	}

	public void setDribbling(int dri) {
		this.dribbling = dri;
		updateCardAvg();
	}

	public int getDefending() {
		return defending;
	}

	public void setDefending(int def) {
		this.defending = def;
		updateCardAvg();
	}

	public int getPhysicality() {
		return physicality;
	}

	public void setPhysicality(int phy) {
		this.physicality = phy;
		updateCardAvg();
	}
	
//	public boolean isSupported() {
//		if(SUPPORTED_RARITIES.contains(rarity) && position != Position.GK)
//			return true;
//		return false;
//	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", name=" + name + ", club=" + club.getName() + ", nation=" + nation.getName() + ", color=" + color
				+ ", rarity=" + rarity + ", position=" + position + ", cardAvg=" + cardAvg + ", rating=" + rating + "]";
	}
}
