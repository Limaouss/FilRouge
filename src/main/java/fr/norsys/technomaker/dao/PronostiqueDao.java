package fr.norsys.technomaker.dao;

import java.sql.SQLException;

import fr.norsys.technomaker.model.Pronostique;
import fr.norsys.technomaker.model.Rencontre;
import fr.norsys.technomaker.model.User;

public interface PronostiqueDao {
	public Pronostique insertPronostique(User user, Rencontre rencontre, int ScoreEquipeA, int ScoreEquipeB)
			throws SQLException;
}
