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
}
