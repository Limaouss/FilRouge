package fr.norsys.technomaker.dao;

import java.sql.SQLException;
import java.util.List;

import fr.norsys.technomaker.model.Poule;
import fr.norsys.technomaker.model.Rencontre;

public interface RecontreDao {

	public List<Rencontre> getAllRencontre() throws SQLException;

	public List<Rencontre> getRencontreByPoule(Poule poule) throws SQLException;

}
