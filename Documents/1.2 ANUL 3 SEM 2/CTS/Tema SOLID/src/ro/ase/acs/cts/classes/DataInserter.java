package ro.ase.acs.cts.classes;

import ro.ase.acs.cts.interfaces.Inserter;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class DataInserter implements Inserter {
    @Override
    public void insertData(Connection connection) throws SQLException {
        String sqlInsert = "INSERT INTO employees VALUES(1, 'Popescu Ion', 'Bucharest', 4000)";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sqlInsert);
        statement.close();
        connection.commit();
    }
}
