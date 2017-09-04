package main.java.ihm;

public enum Menu {
	DEFENSEUR("Défenseur"),CHALLENGER("Challenger"),DUEL("Duel");
	private String name = "";

	Menu(String n) {
		name = n;
	}

	public String toString() {
		return name;
	}
}
