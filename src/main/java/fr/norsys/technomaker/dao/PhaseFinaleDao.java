package fr.norsys.technomaker.dao;

import java.sql.SQLException;
import java.util.List;

import fr.norsys.technomaker.model.PhaseFinale;

public interface PhaseFinaleDao {

	public List<PhaseFinale> findAllPhaseFinales() throws SQLException;

	public PhaseFinale findPhaseFinaleById(int idPhaseFinale) throws SQLException;

}
