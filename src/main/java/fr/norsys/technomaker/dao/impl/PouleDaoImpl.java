package fr.norsys.technomaker.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.norsys.technomaker.dao.CompetitionDao;
import fr.norsys.technomaker.dao.PouleDao;
import fr.norsys.technomaker.model.Poule;

public class PouleDaoImpl implements PouleDao {

	Connection connection;
	CompetitionDao competitionDao;

	public PouleDaoImpl(Connection conection) throws SQLException {
		this.connection = conection;
		this.competitionDao = new CompetitionDaoImpl(conection);
	}

	@Override
	public List<Poule> findAllPoules() throws SQLException {
		List<Poule> poules = new ArrayList<>();
		String sql;
		sql = "SELECT ID_POULE,ID_COMPETITION,CODE from POULE";
		Statement statement = this.connection.createStatement();
		ResultSet poulesRs = statement.executeQuery(sql);
		while (poulesRs.next()) {
			Arrays.asList(poulesRs).forEach(poule -> {
				try {
					poules.add(new Poule(poulesRs.getInt("ID_POULE"),
							this.competitionDao.findCompetitionById(poulesRs.getInt("ID_COMPETITION")),
							poulesRs.getString("CODE").charAt(0)));
				} catch (Exception e) {
					// TODO Auto-generated catch blocks
					e.printStackTrace();
				}
			});
		}

		return poules;
	}

	public Poule findPouleById(int idPoule) throws SQLException {
		Poule poule = new Poule();
		String sql = "SELECT ID_POULE, ID_COMPETITION,CODE from POULE where ID_POULE = ?";
		PreparedStatement statement = this.connection.prepareStatement(sql);
		statement.setInt(1, idPoule);
		ResultSet pouleRs = statement.executeQuery();
		while (pouleRs.next()) {
			poule = new Poule(pouleRs.getInt("ID_POULE"),
					this.competitionDao.findCompetitionById(pouleRs.getInt("ID_COMPETITION")),
					pouleRs.getString("CODE").charAt(0));
		}
		return poule;
	}

}
