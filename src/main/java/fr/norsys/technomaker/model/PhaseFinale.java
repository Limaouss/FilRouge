package fr.norsys.technomaker.model;

public class PhaseFinale {
	private int idPhaseFinale;
	private Competition competition;
	private String typePhaseFinale;

	public PhaseFinale() {
		super();
	}

	public PhaseFinale(int idPhaseFinale, Competition competition, String typePhaseFinale) {
		super();
		this.idPhaseFinale = idPhaseFinale;
		this.competition = competition;
		this.typePhaseFinale = typePhaseFinale;
	}

}
