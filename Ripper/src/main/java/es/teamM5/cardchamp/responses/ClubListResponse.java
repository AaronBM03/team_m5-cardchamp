package es.teamM5.cardchamp.responses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import es.teamM5.cardchamp.model.Club;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClubListResponse {
	private List<Club> items;
	private Pagination pagination;

	public ClubListResponse() {
	}

	public List<Club> getItems() {
		return items;
	}

	public void setItems(List<Club> items) {
		this.items = items;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
}
