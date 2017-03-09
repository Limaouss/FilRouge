package fr.norsys.technomaker.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.norsys.technomaker.dao.UserDao;
import fr.norsys.technomaker.model.User;

public class UserDaoImpl implements UserDao {
	Connection connection;

	public UserDaoImpl(Connection conection) throws SQLException {
		this.connection = conection;
	}

	@Override
	public User findUserByUsername(String username) throws SQLException {
		User user = new User();
		String sql = "SELECT ID_USER, USERNAME,PASSWORD,POINTS from USER where USERNAME = ?";
		PreparedStatement statement = this.connection.prepareStatement(sql);
		statement.setString(1, username);
		ResultSet rsUser = statement.executeQuery();
		while (rsUser.next()) {
			user = new User(rsUser.getInt("ID_USER"), rsUser.getString("USERNAME"), rsUser.getString("PASSWORD"),
					rsUser.getInt("POINTS"));
		}
		return user;
	}

}
