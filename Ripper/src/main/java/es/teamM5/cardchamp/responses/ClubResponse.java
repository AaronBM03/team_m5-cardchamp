package es.teamM5.cardchamp.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import es.teamM5.cardchamp.model.Club;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClubResponse {
	Club club;

	public Club getNation() {
		return club;
	}

	public void setNation(Club club) {
		this.club = club;
	}

	public ClubResponse() {

	}

	@Override
	public String toString() {
		return "Club [club=" + club + "]";
	}
	
	
}
