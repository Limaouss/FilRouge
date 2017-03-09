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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.dateRencontre == null ? 0 : this.dateRencontre.hashCode());
		result = prime * result + (this.equipeA == null ? 0 : this.equipeA.hashCode());
		result = prime * result + (this.equipeB == null ? 0 : this.equipeB.hashCode());
		result = prime * result + this.idRencontre;
		result = prime * result + (this.phaseFinale == null ? 0 : this.phaseFinale.hashCode());
		result = prime * result + (this.poule == null ? 0 : this.poule.hashCode());
		result = prime * result + this.scoreEquipeA;
		result = prime * result + this.scoreEquipeB;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Rencontre other = (Rencontre) obj;
		if (this.dateRencontre == null) {
			if (other.dateRencontre != null) {
				return false;
			}
		} else if (!this.dateRencontre.equals(other.dateRencontre)) {
			return false;
		}
		if (this.equipeA == null) {
			if (other.equipeA != null) {
				return false;
			}
		} else if (!this.equipeA.equals(other.equipeA)) {
			return false;
		}
		if (this.equipeB == null) {
			if (other.equipeB != null) {
				return false;
			}
		} else if (!this.equipeB.equals(other.equipeB)) {
			return false;
		}
		if (this.idRencontre != other.idRencontre) {
			return false;
		}
		if (this.phaseFinale == null) {
			if (other.phaseFinale != null) {
				return false;
			}
		} else if (!this.phaseFinale.equals(other.phaseFinale)) {
			return false;
		}
		if (this.poule == null) {
			if (other.poule != null) {
				return false;
			}
		} else if (!this.poule.equals(other.poule)) {
			return false;
		}
		if (this.scoreEquipeA != other.scoreEquipeA) {
			return false;
		}
		if (this.scoreEquipeB != other.scoreEquipeB) {
			return false;
		}
		return true;
	}

}
