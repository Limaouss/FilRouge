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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.rencontre == null ? 0 : this.rencontre.hashCode());
		result = prime * result + this.scoreEquipeA;
		result = prime * result + this.scoreEquipeB;
		result = prime * result + (this.user == null ? 0 : this.user.hashCode());
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
		Pronostique other = (Pronostique) obj;
		if (this.rencontre == null) {
			if (other.rencontre != null) {
				return false;
			}
		} else if (!this.rencontre.equals(other.rencontre)) {
			return false;
		}
		if (this.scoreEquipeA != other.scoreEquipeA) {
			return false;
		}
		if (this.scoreEquipeB != other.scoreEquipeB) {
			return false;
		}
		if (this.user == null) {
			if (other.user != null) {
				return false;
			}
		} else if (!this.user.equals(other.user)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Pronostique [user=" + this.user + ", rencontre=" + this.rencontre + ", scoreEquipeA="
				+ this.scoreEquipeA + ", scoreEquipeB=" + this.scoreEquipeB + "]";
	}

}
