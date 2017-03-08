package dbunit;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

public class DataSetUnit {

	private static final String PATH = "/home/mohamed/workspace/filRouge/src/test/resources";
	private static final String URL = "jdbc:h2:mem:test;INIT=runscript from '" + PATH + "/crebas-finalv2.sql'";

	protected Connection connection;
	protected IDatabaseConnection dbUnitConnection;
	protected InputStream inputStreamXML;
	protected FlatXmlDataSetBuilder xmlDSBuilder;
	protected IDataSet dataSet;

	public DataSetUnit() throws Exception {
		Class.forName("org.h2.Driver");
		try {
			this.connection = DriverManager.getConnection(URL, "root", "");
			System.out.println("Creating connection");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			this.dbUnitConnection = new DatabaseConnection(this.connection);
			this.inputStreamXML = new FileInputStream(PATH + "/dataset.xml");
			this.xmlDSBuilder = new FlatXmlDataSetBuilder();
			this.xmlDSBuilder.setCaseSensitiveTableNames(false);
			this.dataSet = this.xmlDSBuilder.build(this.inputStreamXML);

			DatabaseOperation.CLEAN_INSERT.execute(this.dbUnitConnection, this.dataSet);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Connection getConnection() {
		System.out.println("++++" + this.connection);
		return this.connection;
	}

}