package fr.norsys.technomaker.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import dbunit.DataSetUnit;
import fr.norsys.technomaker.dao.impl.PouleDaoImpl;
import fr.norsys.technomaker.model.Competition;
import fr.norsys.technomaker.model.Poule;

public class PouleFindAllPouleTest {

	PouleDao pouleDao;
	private Competition competition;
	Date dateDebut;
	Date dateFin;

	@Before
	public void setup() throws Exception {
		LocalDate localDebut = LocalDate.of(2017, 05, 12);
		LocalDate localFin = LocalDate.of(2017, 06, 15);
		this.dateDebut = Date.valueOf(localDebut);
		this.dateFin = Date.valueOf(localFin);
		DataSetUnit data = new DataSetUnit();
		this.pouleDao = new PouleDaoImpl(data.getConnection());
		this.competition = new Competition(1, this.dateDebut, this.dateFin);

	}

	@Test
	public void shouldReturn4AsTotalNumber() throws SQLException {
		assertThat(this.pouleDao.findAllPoules().size()).isEqualTo(4);
	}

	@Test
	public void shouldReturnMachingPoules() throws SQLException {
		Poule pouleA = new Poule(1, this.competition, 'A');
		Poule pouleB = new Poule(2, this.competition, 'B');
		Poule pouleC = new Poule(3, this.competition, 'C');
		Poule pouleD = new Poule(4, this.competition, 'D');

		assertThat(this.pouleDao.findAllPoules().get(0)).isEqualTo(pouleA);
		assertThat(this.pouleDao.findAllPoules().get(1)).isEqualTo(pouleB);
		assertThat(this.pouleDao.findAllPoules().get(2)).isEqualTo(pouleC);
		assertThat(this.pouleDao.findAllPoules().get(3)).isEqualTo(pouleD);
	}
}
