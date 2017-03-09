package fr.norsys.technomaker.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.norsys.technomaker.dao.EquipeDao;
import fr.norsys.technomaker.dao.PhaseFinaleDao;
import fr.norsys.technomaker.dao.PouleDao;
import fr.norsys.technomaker.dao.RecontreDao;
import fr.norsys.technomaker.model.Equipe;
import fr.norsys.technomaker.model.PhaseFinale;
import fr.norsys.technomaker.model.Poule;
import fr.norsys.technomaker.model.Rencontre;

public class RecontreDaoImpl implements RecontreDao {

	Connection connection;
	PouleDao pouleDao;
	PhaseFinaleDao phaseFinaleDao;
	EquipeDao equipeDao;

	public RecontreDaoImpl(Connection conection) throws SQLException {
		this.connection = conection;
		this.pouleDao = new PouleDaoImpl(conection);
		this.phaseFinaleDao = new PhaseFinaleDaoImpl(conection);
		this.equipeDao = new EquipeDaoImpl(conection);
	}

	@Override
	public List<Rencontre> getAllRencontre() throws SQLException {
		String sql = "SELECT ID_RENCONTRE,ID_PHASE_FINALE,ID_POULE,SCOREEQUIPEA,SCOREEQUIPEB FROM RENCONTRE";
		Statement statement = this.connection.createStatement();
		ResultSet RencontreRs = statement.executeQuery(sql);

		return this.findRencontreByResutSet(RencontreRs);
	}

	@Override
	public List<Rencontre> getRencontreByPoule(Poule poule) throws SQLException {
		PreparedStatement statement = this.connection.prepareStatement(
				"SELECT ID_RENCONTRE,ID_PHASE_FINALE,ID_POULE,SCOREEQUIPEA,SCOREEQUIPEB FROM RENCONTRE WHERE ID_POULE = ?");
		statement.setInt(1, poule.getIdPoule());
		ResultSet phasesRs = statement.executeQuery();
		return this.findRencontreByResutSet(phasesRs);
	}

	public List<Equipe> findEquipesByRencontreById(int idRencontre) throws SQLException {
		List<Equipe> equipes = new ArrayList<>();
		String sql;
		sql = "SELECT * from equipe inner JOIN JOUER WHERE jouer.ID_RENCONTRE = ? AND equipe.ID_EQUIPE = jouer.ID_EQUIPE";
		PreparedStatement statement = this.connection.prepareStatement(sql);
		statement.setInt(1, idRencontre);
		ResultSet equipesRs = statement.executeQuery();
		while (equipesRs.next()) {
			Arrays.asList(equipesRs).forEach(equipe -> {
				try {
					equipes.add(new Equipe(equipe.getInt("ID_EQUIPE"), equipe.getString("PAYS")));
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}
		return equipes;
	}

	public List<Rencontre> findRencontreByResutSet(ResultSet resultSet) throws SQLException {
		List<Rencontre> listeRencontre = new ArrayList<>();
		while (resultSet.next()) {
			Arrays.asList(resultSet).forEach(rencontre -> {
				try {

					PhaseFinale phasefinaleRencontre = this.phaseFinaleDao
							.findPhaseFinaleById(rencontre.getInt("ID_PHASE_FINALE"));
					Poule pouleRencontre = this.pouleDao.findPouleById(rencontre.getInt("ID_POULE"));
					Equipe equipeA = this.findEquipesByRencontreById(rencontre.getInt("ID_RENCONTRE")).get(0);
					Equipe equipeB = this.findEquipesByRencontreById(rencontre.getInt("ID_RENCONTRE")).get(1);
					LocalDate localDebut = LocalDate.of(2017, 05, 12);
					Date dateMatch = Date.valueOf(localDebut);
					listeRencontre.add(new Rencontre(rencontre.getInt("ID_RENCONTRE"), phasefinaleRencontre,
							pouleRencontre, dateMatch, rencontre.getInt("SCOREEQUIPEA"),
							rencontre.getInt("SCOREEQUIPEA"), equipeA, equipeB));
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}
		return listeRencontre;
	}

}
