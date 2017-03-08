package fr.norsys.technomaker.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.SQLException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import dbunit.DataSetUnit;
import fr.norsys.technomaker.dao.impl.EquipeDaoImpl;
import fr.norsys.technomaker.model.Competition;
import fr.norsys.technomaker.model.Poule;

public class EquipeFindEquipesByPouleTest {

	EquipeDao equipeDao;
	Competition competition;

	@Before
	public void setup() throws Exception {
		DataSetUnit data = new DataSetUnit();
		this.equipeDao = new EquipeDaoImpl(data.getConnection());
		this.competition = new Competition(1, new Date(), new Date());
	}

	@Test
	public void shouldReturnListFrancePortugal() throws SQLException {
		Poule pouleA = new Poule(1, this.competition, 'A');
		assertThat(this.equipeDao.findEquipesParPoule(pouleA).size()).isEqualTo(4);
	}

}
