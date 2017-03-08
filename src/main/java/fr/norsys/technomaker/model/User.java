package fr.norsys.technomaker.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	private int idUser;
	private String username;
	private String password;
	private int points;

	public User() {

	}

	public User(int id, String username, String password, int points) {
		this.idUser = id;
		this.username = username;
		this.password = password;
		this.points = points;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.idUser;
		result = prime * result + (this.password == null ? 0 : this.password.hashCode());
		result = prime * result + this.points;
		result = prime * result + (this.username == null ? 0 : this.username.hashCode());
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
		User other = (User) obj;
		if (this.idUser != other.idUser) {
			return false;
		}
		if (this.password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!this.password.equals(other.password)) {
			return false;
		}
		if (this.points != other.points) {
			return false;
		}
		if (this.username == null) {
			if (other.username != null) {
				return false;
			}
		} else if (!this.username.equals(other.username)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "User [idUser=" + this.idUser + ", username=" + this.username + ", password=" + this.password
				+ ", points=" + this.points + "]";
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPoints() {
		return this.points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

}
