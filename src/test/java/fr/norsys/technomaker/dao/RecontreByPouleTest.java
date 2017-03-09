package fr.norsys.technomaker.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import dbunit.DataSetUnit;
import fr.norsys.technomaker.dao.impl.RecontreDaoImpl;
import fr.norsys.technomaker.model.Competition;
import fr.norsys.technomaker.model.Poule;

public class RecontreByPouleTest {
	private RecontreDao recontreDao;
	private Date dateDebut;
	private Date dateFin;
	Competition competition;

	@Before
	public void setup() throws Exception {
		DataSetUnit dataSource = new DataSetUnit();
		this.recontreDao = new RecontreDaoImpl(dataSource.getConnection());

		LocalDate date1 = LocalDate.of(2017, 05, 12);
		this.dateDebut = Date.valueOf(date1);
		LocalDate date2 = LocalDate.of(2017, 06, 15);
		this.dateFin = Date.valueOf(date2);
		this.competition = new Competition(1, this.dateDebut, this.dateFin);
	}

	@Test
	public void shouldReturn4whenPouleIs1() throws SQLException {
		Poule pouleA = new Poule(1, this.competition, 'A');
		assertThat(this.recontreDao.getRencontreByPoule(pouleA).size()).isEqualTo(4);
	}
}
