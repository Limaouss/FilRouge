package fr.norsys.technomaker.dao;

import java.sql.DriverManager;
import java.sql.Statement;

public class AConnectionClass {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/fil_rouge";
	static final String USER = "root";
	static final String PASS = "slighlmazi";

	protected java.sql.Connection conn = null;
	public Statement stmt = null;

	public AConnectionClass() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			this.conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public java.sql.Connection getConn() {
		return this.conn;
	}

}
