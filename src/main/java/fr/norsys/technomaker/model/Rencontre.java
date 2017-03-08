package fr.norsys.technomaker.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Rencontre {
	private int idRencontre;
	private PhaseFinale phaseFinale;
	private Poule poule;
	private Date dateRencontre;
	private int scoreEquipeA;
	private int scoreEquipeB;
	private Equipe equipeA;
	private Equipe equipeB;

}
