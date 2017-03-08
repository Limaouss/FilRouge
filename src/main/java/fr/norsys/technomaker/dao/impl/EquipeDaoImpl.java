package fr.norsys.technomaker.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.norsys.technomaker.dao.EquipeDao;
import fr.norsys.technomaker.model.Equipe;

public class EquipeDaoImpl implements EquipeDao {

	Connection connection;
	Statement stmt;

	public EquipeDaoImpl(Connection conection) throws SQLException {
		this.connection = conection;
		this.stmt = conection.createStatement();
	}

	@Override
	public List<Equipe> returnTwoTeams() throws SQLException {
		List<Equipe> equipes = new ArrayList<>();
		String sql, sql2;
		sql = "SELECT * from EQUIPE where PAYS='France'";
		sql2 = "SELECT * from EQUIPE where PAYS='Portugal'";
		ResultSet rsFrance = this.stmt.executeQuery(sql);
		while (rsFrance.next())

		{
			Equipe france = new Equipe(rsFrance.getInt("ID_EQUIPE"), rsFrance.getString("PAYS"));
			equipes.add(france);
		}
		ResultSet rsPortugal = this.stmt.executeQuery(sql2);
		while (rsPortugal.next())

		{
			Equipe portugal = new Equipe(rsPortugal.getInt("ID_EQUIPE"), rsPortugal.getString("PAYS"));
			equipes.add(portugal);
		}
		return equipes;
	}
}
