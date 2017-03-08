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
}
