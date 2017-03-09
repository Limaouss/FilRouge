package fr.norsys.technomaker.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.norsys.technomaker.dao.PouleDao;
import fr.norsys.technomaker.dao.RecontreDao;
import fr.norsys.technomaker.model.Rencontre;

public class RecontreDaoImpl implements RecontreDao {

	Connection connection;
	PouleDao pouleDao;

	public RecontreDaoImpl(Connection conection) throws SQLException {
		this.connection = conection;
		this.pouleDao = new PouleDaoImpl(conection);
	}

	public List<Rencontre> getAllRencontre() throws SQLException {
	        List<Rencontre> listeRencontre = new ArrayList<>();
	        ResultSet listRencontreSet = null;
	        String sql = "SELECT ID_RECONTRE,ID_PHASE_FINALE,ID_POULE,SCOREEQUIPEA,SCOREEQUIPEB FROM RENCONTRE";
	        Statement statement = this.connection.createStatement();
	        listRencontreSet = statement.executeQuery(sql);
	        while (listRencontreSet.next()) {
	            Arrays.asList(listeRencontre).forEach(rencontre -> {
	                try{
	                    listeRencontre.add(new Rencontre(listRencontreSet.getInt("ID_RENCONTRE"),))
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            });
	        }        return listeRencontre;
	    }

	@Override
	public List<Rencontre> getRencontreByPoule(Poule poule) throws SQLException {
		List<Rencontre> listeRencontre = new ArrayList<>();
		this.preparedStatement = this.connexion.prepareStatement("SELECT * FROM RENCONTRE WHERE id_poule = ?");
		this.preparedStatement.setInt(1, poule.getIdPoule());
		// TODO completer hadchi
		return listeRencontre;
	}
}
