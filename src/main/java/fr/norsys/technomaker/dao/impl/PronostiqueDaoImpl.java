package fr.norsys.technomaker.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.norsys.technomaker.dao.CompetitionDao;
import fr.norsys.technomaker.dao.PronostiqueDao;
import fr.norsys.technomaker.model.Pronostique;
import fr.norsys.technomaker.model.Rencontre;
import fr.norsys.technomaker.model.User;

public class PronostiqueDaoImpl implements PronostiqueDao {

	Connection connection;
	CompetitionDao competitionDao;

	public PronostiqueDaoImpl(Connection conection) throws SQLException {
		this.connection = conection;
	}

	@Override
	public Pronostique insertPronostique(User user, Rencontre rencontre, int ScoreEquipeA, int ScoreEquipeB)
			throws SQLException {

		Pronostique pronostique = new Pronostique();
		String sql = "insert into PRONOSTIQUER values(?,?,?,?)";
		PreparedStatement statement = this.connection.prepareStatement(sql);
		statement.setInt(1, user.getIdUser());
		statement.setInt(2, rencontre.getIdRencontre());
		statement.setInt(3, ScoreEquipeA);
		statement.setInt(4, ScoreEquipeB);

		int isValid = statement.executeUpdate();
		if (isValid != 0) {
			pronostique = new Pronostique(user, rencontre, ScoreEquipeA, ScoreEquipeB);
		}
		return pronostique;
	}
}
