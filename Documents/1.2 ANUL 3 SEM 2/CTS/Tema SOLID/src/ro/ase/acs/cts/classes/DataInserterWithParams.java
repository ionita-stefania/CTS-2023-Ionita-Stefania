package ro.ase.acs.cts.classes;

import ro.ase.acs.cts.interfaces.Inserter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataInserterWithParams implements Inserter {
    @Override
    public void insertData(Connection connection) throws SQLException {
        String sqlInsertWithParams = "INSERT INTO employees VALUES (?,?,?,?)";
        PreparedStatement preparedStatement =
                connection.prepareStatement(sqlInsertWithParams);
        preparedStatement.setInt(1, 2);
        preparedStatement.setString(2, "Ionescu Vasile");
        preparedStatement.setString(3, "Brasov");
        preparedStatement.setDouble(4, 4500);
        preparedStatement.executeUpdate();
        preparedStatement.close();

        connection.commit();
    }
}

