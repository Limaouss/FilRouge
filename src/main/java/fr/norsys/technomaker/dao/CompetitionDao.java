package fr.norsys.technomaker.dao;

import java.sql.SQLException;

import fr.norsys.technomaker.model.Competition;

public interface CompetitionDao {
	public Competition findCompetitionById(int id) throws SQLException;
}
