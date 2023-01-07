package es.teamM5.cardchamp.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import es.teamM5.cardchamp.model.Card;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerResponse {
	Card player;

	public Card getPlayer() {
		return player;
	}

	public void setPlayer(Card player) {
		this.player = player;
	}

	public PlayerResponse() {

	}

	@Override
	public String toString() {
		return "Player [player=" + player + "]";
	}
	
	
}
