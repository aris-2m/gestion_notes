package beans.crud.ITags;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConnector {
    public Connection getConnection();

    public void closeConnection(Connection connection) throws SQLException;
}
