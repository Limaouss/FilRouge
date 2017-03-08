package fr.norsys.technomaker.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Competition {

	private int idCompetion;
	private Date dateDebut;
	private Date dateFin;

	public Competition(int idCompetion, Date dateDebut, Date dateFin) {
		super();
		this.idCompetion = idCompetion;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public Competition() {
	}

}
