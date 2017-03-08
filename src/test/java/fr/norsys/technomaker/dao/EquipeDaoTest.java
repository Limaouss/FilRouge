package fr.norsys.technomaker.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import dbunit.DataSetUnit;
import fr.norsys.technomaker.dao.impl.EquipeDaoImpl;
import fr.norsys.technomaker.model.Equipe;

public class EquipeDaoTest {

	EquipeDao equipeDao;

	@Before
	public void setup() throws Exception {
		DataSetUnit data = new DataSetUnit();
		this.equipeDao = new EquipeDaoImpl(data.getConnection());
	}

	@Test
	public void shouldReturnListFrancePortugal() throws SQLException {
		assertThat(this.equipeDao.returnTwoTeams().get(0)).isEqualTo(new Equipe(1, "France"));
		assertThat(this.equipeDao.returnTwoTeams().get(1)).isEqualTo(new Equipe(2, "Portugal"));
	}

}
