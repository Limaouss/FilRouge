package fr.norsys.technomaker.model;

import java.sql.Date;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.dateDebut == null ? 0 : this.dateDebut.hashCode());
		result = prime * result + (this.dateFin == null ? 0 : this.dateFin.hashCode());
		result = prime * result + this.idCompetion;
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
		Competition other = (Competition) obj;
		if (this.dateDebut == null) {
			if (other.dateDebut != null) {
				return false;
			}
		} else if (!this.dateDebut.equals(other.dateDebut)) {
			return false;
		}
		if (this.dateFin == null) {
			if (other.dateFin != null) {
				return false;
			}
		} else if (!this.dateFin.equals(other.dateFin)) {
			return false;
		}
		if (this.idCompetion != other.idCompetion) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Competition [idCompetion=" + this.idCompetion + ", dateDebut=" + this.dateDebut + ", dateFin="
				+ this.dateFin + "]";
	}

}
