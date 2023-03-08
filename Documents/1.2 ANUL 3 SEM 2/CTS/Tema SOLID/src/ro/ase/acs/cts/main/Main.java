package ro.ase.acs.cts.main;

import ro.ase.acs.cts.classes.DataInserterWithParams;
import ro.ase.acs.cts.classes.TableCreator;
import ro.ase.acs.cts.classes.DataInserter;
import ro.ase.acs.cts.classes.DataReader;
import ro.ase.acs.cts.interfaces.Creator;
import ro.ase.acs.cts.interfaces.Inserter;
import ro.ase.acs.cts.interfaces.Reader;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            connection.setAutoCommit(false);

            Creator tableCreator = new TableCreator();
            tableCreator.createTable(connection);

            Inserter dataInserter = new DataInserter();
            dataInserter.insertData(connection);

            Inserter dataInserterWithParams = new DataInserterWithParams();
            dataInserterWithParams.insertData(connection);

            Reader dataReader = new DataReader();
            dataReader.readData(connection);

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
