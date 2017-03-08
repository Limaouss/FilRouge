package fr.norsys.technomaker.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.norsys.technomaker.dao.CompetitionDao;
import fr.norsys.technomaker.model.Competition;

public class CompetitionDaoImpl implements CompetitionDao {

	Connection connection;

	public CompetitionDaoImpl(Connection conection) throws SQLException {
		this.connection = conection;
		System.out.println("*****" + this.connection);
	}

	@Override
	public Competition findCompetitionById(int id) throws SQLException {
		Competition competition = new Competition();
		String sql = "SELECT ID_COMPETITION, DATE_DEBUT,DATE_FIN from COMPETITION where ID_COMPETITION = ?";
		PreparedStatement statement = this.connection.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet competitionRs = statement.executeQuery();
		while (competitionRs.next()) {
			competition = new Competition(competitionRs.getInt("ID_USER"), competitionRs.getDate("USERNAME"),
					competitionRs.getDate("DATE_FIN"));
		}
		return competition;
	}
}
