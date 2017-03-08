package fr.norsys.technomaker.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import dbunit.DataSetUnit;
import fr.norsys.technomaker.dao.impl.CompetitionDaoImpl;
import fr.norsys.technomaker.model.Competition;

public class CompetionFindByIdTest {

	private CompetitionDao competitionDao;
	private Date datedebut;

	@Before
	public void setup() throws Exception {
		DataSetUnit dataSource = new DataSetUnit();
		this.competitionDao = new CompetitionDaoImpl(dataSource.getConnection());
	}

	@Test
	public void shouldReturnCompetitionOnewhenOne() throws SQLException {
		Competition competitionOne = new Competition(1, new Date(2017, 05, 12), new Date(2017, 06, 12));
		assertThat(this.competitionDao.findCompetitionById(1)).isEqualTo(competitionOne);
	}
}
