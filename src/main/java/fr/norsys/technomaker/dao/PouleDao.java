package fr.norsys.technomaker.dao;

import java.sql.SQLException;
import java.util.List;

import fr.norsys.technomaker.model.Poule;

public interface PouleDao {
	public List<Poule> findAllPoules() throws SQLException;

	public Poule findPouleById(int idPoule) throws SQLException;
}
