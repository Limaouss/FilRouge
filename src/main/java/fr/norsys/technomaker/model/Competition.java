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

}
