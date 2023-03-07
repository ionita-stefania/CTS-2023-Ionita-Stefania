package ro.ase.acs.cts.main;

import ro.ase.acs.cts.classes.TableCreator;
import ro.ase.acs.cts.classes.DataInserter;
import ro.ase.acs.cts.classes.DataReader;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            connection.setAutoCommit(false);

            TableCreator tableCreator = new TableCreator();
            tableCreator.createTable(connection);

            DataInserter dataInserter = new DataInserter();
            dataInserter.insertData(connection);

            DataReader dataReader = new DataReader();
            dataReader.readData(connection);

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }






}
