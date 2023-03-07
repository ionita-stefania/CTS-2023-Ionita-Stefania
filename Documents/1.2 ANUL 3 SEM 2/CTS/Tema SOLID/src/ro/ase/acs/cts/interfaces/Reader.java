package ro.ase.acs.cts.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface Reader {
    void readData(Connection connection) throws SQLException;
}
