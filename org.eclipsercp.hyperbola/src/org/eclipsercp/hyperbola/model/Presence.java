package org.eclipsercp.hyperbola.model;

public enum Presence {

	ONLINE("online"), AWAY("away"), DO_NOT_DISTRUB("do_not_distrub"), INVISIBLE(
			"invisible");

	private String value;

	private Presence(String value) {
		this.value = value;
	}

	public String toString() {
		return value;
	}

}
