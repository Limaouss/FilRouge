package fr.norsys.technomaker.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.norsys.technomaker.dao.UserDao;
import fr.norsys.technomaker.model.User;

public class UserDaoImpl implements UserDao {
	Connection connection;

	public UserDaoImpl(Connection conection) throws SQLException {
		this.connection = conection;
		System.out.println("*****" + this.connection);
	}

	@Override
	public User returnUser() throws SQLException {
		User user = new User();
		String sql = "SELECT ID_USER, USERNAME,PASSWORD,POINTS";
		ResultSet rsUser = this.stmt.executeQuery(sql);
		System.out.println("ffffff" + rsUser.next());
		while (rsUser.next()) {
			user = new User(rsUser.getInt("ID_USER"), rsUser.getString("USERNAME"), rsUser.getInt("POINTS"));
			System.out.println("-----" + user);
		}
		return user;
	}

}
