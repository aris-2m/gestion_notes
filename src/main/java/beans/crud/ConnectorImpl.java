package beans.crud;

import beans.crud.ITags.IConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorImpl implements IConnector {
    @Override
    public Connection getConnection() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/gestion_notes","root","");
            return conn;
        }catch(Exception ex){
            System.out.println(ex);
            return null;
        }
    }

    @Override
    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }
}
