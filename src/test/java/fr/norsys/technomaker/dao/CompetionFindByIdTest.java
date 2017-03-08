package fr.norsys.technomaker.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import dbunit.DataSetUnit;
import fr.norsys.technomaker.dao.impl.CompetitionDaoImpl;
import fr.norsys.technomaker.model.Competition;

public class CompetionFindByIdTest {

	private CompetitionDao competitionDao;
	private Date dateDebut;
	private Date dateFin;

	@Before
	public void setup() throws Exception {
		DataSetUnit dataSource = new DataSetUnit();
		this.competitionDao = new CompetitionDaoImpl(dataSource.getConnection());

		LocalDate localDebut = LocalDate.of(2017, 05, 12);
		LocalDate localFin = LocalDate.of(2017, 06, 15);
		this.dateDebut = Date.valueOf(localDebut);
		this.dateFin = Date.valueOf(localFin);

	}

	@Test
	public void shouldReturnCompetitionOnewhenOne() throws SQLException {
		Competition competitionOne = new Competition(1, this.dateDebut, this.dateFin);
		assertThat(this.competitionDao.findCompetitionById(1)).isEqualTo(competitionOne);
	}
}
