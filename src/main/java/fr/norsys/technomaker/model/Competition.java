package fr.norsys.technomaker.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Competition {

	private final int idCompetion;
	private final Date dateDebut;
	private final Date dateFin;

	public Competition(int idCompetion, Date dateDebut, Date dateFin) {
		super();
		this.idCompetion = idCompetion;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

}
