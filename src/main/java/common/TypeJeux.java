package common;

public enum TypeJeux {
	CHALLENGER("Challenger"), DEFENSEUR("Defenseur"), DUEL("Duel");

	private String type = "";

	TypeJeux(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return type;
	}

}
