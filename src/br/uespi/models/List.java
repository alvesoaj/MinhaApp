package br.uespi.models;

public class List {
	private long id;
	private String description;

	public List() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// Will be used by the ArrayAdapter in the ListView
	@Override
	public String toString() {
		return description;
	}
}
