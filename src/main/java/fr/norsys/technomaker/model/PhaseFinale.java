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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.competition == null ? 0 : this.competition.hashCode());
		result = prime * result + this.idPhaseFinale;
		result = prime * result + (this.typePhaseFinale == null ? 0 : this.typePhaseFinale.hashCode());
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
		PhaseFinale other = (PhaseFinale) obj;
		if (this.competition == null) {
			if (other.competition != null) {
				return false;
			}
		} else if (!this.competition.equals(other.competition)) {
			return false;
		}
		if (this.idPhaseFinale != other.idPhaseFinale) {
			return false;
		}
		if (this.typePhaseFinale == null) {
			if (other.typePhaseFinale != null) {
				return false;
			}
		} else if (!this.typePhaseFinale.equals(other.typePhaseFinale)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "PhaseFinale [idPhaseFinale=" + this.idPhaseFinale + ", competition=" + this.competition
				+ ", typePhaseFinale=" + this.typePhaseFinale + "]";
	}

}
