package fr.norsys.technomaker.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import dbunit.DataSetUnit;
import fr.norsys.technomaker.dao.impl.RecontreDaoImpl;

public class RecontreFindAllTest {

	private RecontreDao recontreDao;
	private Date dateDebut;
	private Date dateFin;

	@Before
	public void setup() throws Exception {
		DataSetUnit dataSource = new DataSetUnit();
		this.recontreDao = new RecontreDaoImpl(dataSource.getConnection());

		LocalDate dateMatch = LocalDate.of(2017, 05, 12);
		this.dateDebut = Date.valueOf(dateMatch);

	}

	@Test
	public void shouldReturn6whenmatchesAre6() throws SQLException {
		assertThat(this.recontreDao.getAllRencontre().size()).isEqualTo(6);
	}

}
