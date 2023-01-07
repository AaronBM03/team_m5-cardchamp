package es.teamM5.cardchamp.responses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import es.teamM5.cardchamp.model.Nation;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NationListResponse {
	private List<Nation> items;
	private Pagination pagination;

	public NationListResponse() {
	}

	public List<Nation> getItems() {
		return items;
	}

	public void setItems(List<Nation> items) {
		this.items = items;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
}
