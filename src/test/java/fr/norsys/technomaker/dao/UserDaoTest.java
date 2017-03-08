package fr.norsys.technomaker.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import dbunit.DataSetUnit;
import fr.norsys.technomaker.dao.impl.UserDaoImpl;
import fr.norsys.technomaker.model.User;

public class UserDaoTest {

	UserDao userDao;
	User Mohamed;

	@Before
	public void setup() throws Exception {
		DataSetUnit data = new DataSetUnit();
		this.userDao = new UserDaoImpl(data.getConnection());
	}

	@Test
	public void shouldReturnMohamedWhenArgIsMohamed() throws SQLException {
		User Mohamed = new User(3, "mohamed", "123456789", 0);
		assertThat(this.userDao.findUserByUsername("mohamed")).isEqualTo(Mohamed);
	}

}
