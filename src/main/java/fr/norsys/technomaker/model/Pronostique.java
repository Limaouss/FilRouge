package fr.norsys.technomaker.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Pronostique {
	private User user;
	private Rencontre rencontre;
	private int scoreEquipeA;
	private int scoreEquipeB;

	public Pronostique(User user, Rencontre rencontre, int scoreEquipeA, int scoreEquipeB) {
		super();
		this.user = user;
		this.rencontre = rencontre;
		this.scoreEquipeA = scoreEquipeA;
		this.scoreEquipeB = scoreEquipeB;
	}

	public Pronostique() {
		super();
	}

}
