package fr.norsys.technomaker.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Poule {
	private int idPoule;
	private Competition competition;
	private char code;

	public int getIdPoule() {
		return this.idPoule;
	}

	public void setIdPoule(int idPoule) {
		this.idPoule = idPoule;
	}

	public Competition getCompetition() {
		return this.competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	public char getCode() {
		return this.code;
	}

	public void setCode(char code) {
		this.code = code;
	}

	public Poule(int id, Competition competition, char code) {
		this.idPoule = id;
		this.competition = competition;
		this.code = code;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.code;
		result = prime * result + (this.competition == null ? 0 : this.competition.hashCode());
		result = prime * result + this.idPoule;
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
		Poule other = (Poule) obj;
		if (this.code != other.code) {
			return false;
		}
		if (this.competition == null) {
			if (other.competition != null) {
				return false;
			}
		} else if (!this.competition.equals(other.competition)) {
			return false;
		}
		if (this.idPoule != other.idPoule) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Poule [idPoule=" + this.idPoule + ", competition=" + this.competition + ", code=" + this.code + "]";
	}

}
