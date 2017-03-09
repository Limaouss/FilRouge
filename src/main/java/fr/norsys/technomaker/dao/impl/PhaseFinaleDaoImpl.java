package fr.norsys.technomaker.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.norsys.technomaker.dao.CompetitionDao;
import fr.norsys.technomaker.dao.PhaseFinaleDao;
import fr.norsys.technomaker.model.PhaseFinale;

public class PhaseFinaleDaoImpl implements PhaseFinaleDao {

	Connection connection;
	CompetitionDao competitionDao;

	public PhaseFinaleDaoImpl(Connection conection) throws SQLException {
		this.connection = conection;
		this.competitionDao = new CompetitionDaoImpl(conection);
	}

	@Override
	public List<PhaseFinale> findAllPhaseFinales() throws SQLException {
		List<PhaseFinale> phaseFinales = new ArrayList<>();
		String sql;
		sql = "SELECT ID_PHASE_FINALE,ID_COMPETITION,TYPE from PHASE_FINALE";
		Statement statement = this.connection.createStatement();
		ResultSet phaseRs = statement.executeQuery(sql);
		while (phaseRs.next()) {
			Arrays.asList(phaseRs).forEach(phase -> {
				try {
					phaseFinales.add(new PhaseFinale(phaseRs.getInt("ID_PHASE"),
							this.competitionDao.findCompetitionById(phaseRs.getInt("ID_COMPETITION")),
							phaseRs.getString("TYPE")));
				} catch (Exception e) {
					// TODO Auto-generated catch blocks
					e.printStackTrace();
				}
			});
		}

		return phaseFinales;
	}

	@Override
	public PhaseFinale findPhaseFinaleById(int idPhaseFinale) throws SQLException {
		PhaseFinale phaseFinale = new PhaseFinale();
		String sql = "SELECT ID_PHASE_FINALE, ID_COMPETITION,TYPE from PHASE_FINALE where ID_PHASE_FINALE = ?";
		PreparedStatement statement = this.connection.prepareStatement(sql);
		statement.setInt(1, idPhaseFinale);
		ResultSet phaseRs = statement.executeQuery();
		while (phaseRs.next()) {
			phaseFinale = new PhaseFinale(phaseRs.getInt("ID_POULE"),
					this.competitionDao.findCompetitionById(phaseRs.getInt("ID_COMPETITION")),
					phaseRs.getString("TYPE"));
		}
		return phaseFinale;
	}
}
