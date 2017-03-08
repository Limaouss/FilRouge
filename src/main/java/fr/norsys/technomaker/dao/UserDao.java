package fr.norsys.technomaker.dao;

import java.sql.SQLException;

import fr.norsys.technomaker.model.User;

public interface UserDao {

	public User returnUser() throws SQLException;
}
