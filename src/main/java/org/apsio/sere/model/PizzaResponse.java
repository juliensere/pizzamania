package org.apsio.sere.model;

public class PizzaResponse {
	private final long id;
	private final String content;

	public PizzaResponse(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}
