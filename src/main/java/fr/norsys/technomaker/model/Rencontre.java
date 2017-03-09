package fr.norsys.technomaker.model;

import java.sql.Date;

public class Rencontre {
	private int idRencontre;
	private PhaseFinale phaseFinale;
	private Poule poule;
	private Date dateRencontre;
	private int scoreEquipeA;
	private int scoreEquipeB;
	private Equipe equipeA;
	private Equipe equipeB;

	public Rencontre() {
		super();
	}

	public Rencontre(int idRencontre, PhaseFinale phaseFinale, Poule poule, Date dateRencontre, int scoreEquipeA,
			int scoreEquipeB, Equipe equipeA, Equipe equipeB) {
		super();
		this.idRencontre = idRencontre;
		this.phaseFinale = phaseFinale;
		this.poule = poule;
		this.dateRencontre = dateRencontre;
		this.scoreEquipeA = scoreEquipeA;
		this.scoreEquipeB = scoreEquipeB;
		this.equipeA = equipeA;
		this.equipeB = equipeB;
	}

	public int getIdRencontre() {
		return this.idRencontre;
	}

	public void setIdRencontre(int idRencontre) {
		this.idRencontre = idRencontre;
	}

	public PhaseFinale getPhaseFinale() {
		return this.phaseFinale;
	}

	public void setPhaseFinale(PhaseFinale phaseFinale) {
		this.phaseFinale = phaseFinale;
	}

	public Poule getPoule() {
		return this.poule;
	}

	public void setPoule(Poule poule) {
		this.poule = poule;
	}

	public Date getDateRencontre() {
		return this.dateRencontre;
	}

	public void setDateRencontre(Date dateRencontre) {
		this.dateRencontre = dateRencontre;
	}

	public int getScoreEquipeA() {
		return this.scoreEquipeA;
	}

	public void setScoreEquipeA(int scoreEquipeA) {
		this.scoreEquipeA = scoreEquipeA;
	}

	public int getScoreEquipeB() {
		return this.scoreEquipeB;
	}

	public void setScoreEquipeB(int scoreEquipeB) {
		this.scoreEquipeB = scoreEquipeB;
	}

	public Equipe getEquipeA() {
		return this.equipeA;
	}

	public void setEquipeA(Equipe equipeA) {
		this.equipeA = equipeA;
	}

	public Equipe getEquipeB() {
		return this.equipeB;
	}

	public void setEquipeB(Equipe equipeB) {
		this.equipeB = equipeB;
	}

	@Override
	public String toString() {
		return "Rencontre [idRencontre=" + this.idRencontre + ", phaseFinale=" + this.phaseFinale + ", poule="
				+ this.poule + ", dateRencontre=" + this.dateRencontre + ", scoreEquipeA=" + this.scoreEquipeA
				+ ", scoreEquipeB=" + this.scoreEquipeB + ", equipeA=" + this.equipeA + ", equipeB=" + this.equipeB
				+ "]";
	}

}
