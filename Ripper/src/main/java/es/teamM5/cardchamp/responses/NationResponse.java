package es.teamM5.cardchamp.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import es.teamM5.cardchamp.model.Nation;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NationResponse {
	Nation nation;

	public Nation getNation() {
		return nation;
	}

	public void setNation(Nation nation) {
		this.nation = nation;
	}

	public NationResponse() {

	}

	@Override
	public String toString() {
		return "Nation [nation=" + nation + "]";
	}
	
	
}
