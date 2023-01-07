package es.teamM5.cardchamp.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "club")
public class Club
{
	@Id
	private int id;
	private String name;
	
	@OneToMany(mappedBy = "club")
	private List<Card> cards;
	
	public Club(int id, String club)
	{
		this.id = id;
		this.name = club;
	}
	
	public Club() { }

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String club)
	{
		this.name = club;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	@Override
	public String toString() {
		return "Club [id=" + id + ", name=" + name + "]";
	}

}
