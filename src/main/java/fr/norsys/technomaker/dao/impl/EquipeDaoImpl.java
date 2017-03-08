package fr.norsys.technomaker.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.norsys.technomaker.dao.EquipeDao;
import fr.norsys.technomaker.model.Equipe;
import fr.norsys.technomaker.model.Poule;

public class EquipeDaoImpl implements EquipeDao {

	Connection connection;

	public EquipeDaoImpl(Connection conection) throws SQLException {
		this.connection = conection;
	}

	@Override
	public List<Equipe> findEquipesParPoule(Poule poule) throws SQLException {
		List<Equipe> equipes = new ArrayList<>();
		String sql;
		sql = "SELECT ID_EQUIPE,PAYS,ID_POULE from EQUIPE where ID_POULE = ?";
		PreparedStatement statement = this.connection.prepareStatement(sql);
		statement.setInt(1, poule.getIdPoule());
		ResultSet equipesRs = statement.executeQuery();
		while (equipesRs.next()) {
			Arrays.asList(equipesRs).forEach(equipe -> {
				try {
					equipes.add(new Equipe(equipe.getInt("ID_EQUIPE"), equipe.getString("PAYS")));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		}

		return equipes;
	}
}
