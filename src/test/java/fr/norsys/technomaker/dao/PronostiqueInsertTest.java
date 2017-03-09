package fr.norsys.technomaker.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import dbunit.DataSetUnit;
import fr.norsys.technomaker.dao.impl.RecontreDaoImpl;
import fr.norsys.technomaker.dao.impl.UserDaoImpl;
import fr.norsys.technomaker.model.User;

public class PronostiqueInsertTest {
	UserDao userdao;
	PronostiqueDao pronostiqueDao;
	RecontreDao recontreDao;

	@Before
	public void setup() throws Exception {
		DataSetUnit dataSource = new DataSetUnit();
		this.userdao = new UserDaoImpl(dataSource.getConnection());
		this.recontreDao = new RecontreDaoImpl(dataSource.getConnection());
	}

	@Test
	public void shouldReturnCompetitionOnewhenOne() throws SQLException {
		User user = this.userdao.findUserByUsername("mohamed");
		System.out.println("user" + user);
		System.out.println("match" + this.recontreDao.getAllRencontre().get(0));
		assertThat(this.pronostiqueDao.insertPronostique(user, this.recontreDao.getAllRencontre().get(0), 3, 2))
				.isEqualTo(1);
	}
}
