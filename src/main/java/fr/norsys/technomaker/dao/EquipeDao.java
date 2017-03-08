package fr.norsys.technomaker.dao;

import java.sql.SQLException;
import java.util.List;

import fr.norsys.technomaker.model.Equipe;
import fr.norsys.technomaker.model.Poule;

public interface EquipeDao {

	public List<Equipe> findEquipesParPoule(Poule poule) throws SQLException;
}
