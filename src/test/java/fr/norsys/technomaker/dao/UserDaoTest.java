package fr.norsys.technomaker.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import dbunit.DataSetUnit;
import fr.norsys.technomaker.dao.impl.UserDaoImpl;

public class UserDaoTest {

	UserDao userDao;

	@Before
	public void setup() throws Exception {
		DataSetUnit data = new DataSetUnit();
		this.userDao = new UserDaoImpl(data.getConnection());
	}

	@Test
	public void shouldReturnListFrancePortugal() throws SQLException {
		System.out.println(this.userDao.returnUser());
		assertThat(this.userDao.returnUser().getUsername()).isEqualTo("mohamed");
	}
}
