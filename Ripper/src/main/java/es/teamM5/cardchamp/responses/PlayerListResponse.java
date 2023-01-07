package es.teamM5.cardchamp.responses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import es.teamM5.cardchamp.model.Card;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerListResponse {
	private List<Card> items;
	private Pagination pagination;

	public PlayerListResponse() {
	}

	public List<Card> getItems() {
		return items;
	}

	public void setItems(List<Card> items) {
		this.items = items;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
}
