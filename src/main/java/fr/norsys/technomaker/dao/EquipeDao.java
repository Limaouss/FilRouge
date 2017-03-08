package fr.norsys.technomaker.dao;

import java.sql.SQLException;
import java.util.List;

import fr.norsys.technomaker.model.Equipe;

public interface EquipeDao {

	public List<Equipe> returnTwoTeams() throws SQLException;
}
