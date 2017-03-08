package fr.norsys.technomaker.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Equipe {
	public Equipe(int id, String pays) {
		this.idEquipe = id;
		this.paysEquipe = pays;
	}

	private final int idEquipe;
	private final String paysEquipe;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.idEquipe;
		result = prime * result + (this.paysEquipe == null ? 0 : this.paysEquipe.hashCode());
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
		Equipe other = (Equipe) obj;
		if (this.idEquipe != other.idEquipe) {
			return false;
		}
		if (this.paysEquipe == null) {
			if (other.paysEquipe != null) {
				return false;
			}
		} else if (!this.paysEquipe.equals(other.paysEquipe)) {
			return false;
		}
		return true;
	}

	public int getIdEquipe() {
		return this.idEquipe;
	}

	public String getPaysEquipe() {
		return this.paysEquipe;
	}

}
