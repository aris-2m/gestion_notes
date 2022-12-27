package beans.crud;

import beans.crud.ITags.IConnector;
import beans.crud.ITags.ICrud;
import beans.dao.Account;

import java.sql.*;

public class CrudAccountImpl implements ICrud<Account> {

    IConnector connector=null;

    @Override
    public ResultSet getAll() {
        try{
            IConnector connector = new ConnectorImpl();
            Connection connection = connector.getConnection();

            String sql="select * from account";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            return resultSet;
        }
        catch(Exception exception){
            System.out.println(exception);
        }
        return null;
    }

    @Override
    public ResultSet getById(int id) {
        try{
            IConnector connector = new ConnectorImpl();
            Connection connection = connector.getConnection();

            String sql="select * from account where idAccount=?";

            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1,id);
            ResultSet resultSet = prepareStatement.executeQuery();

            return resultSet;
        }
        catch(Exception exception){
            System.out.println(exception);
        }
        return null;
    }

    @Override
    public int insert(Account account) {
        try{
            IConnector connector = new ConnectorImpl();
            Connection connection = connector.getConnection();

            String sql="insert into account(password) values(?)";

            PreparedStatement prepareStatement = connection.prepareStatement(sql);

            prepareStatement.setString(1, account.getPassword());
            int result = prepareStatement.executeUpdate();

            return result;
        }
        catch(Exception exception){
            System.out.println(exception);
        }
        return 0;
    }

    @Override
    public int update(Account account) {
        try{
            IConnector connector = new ConnectorImpl();
            Connection connection = connector.getConnection();

            String sql="update account set password=? where idAccount=?";

            PreparedStatement prepareStatement = connection.prepareStatement(sql);

            prepareStatement.setString(1, account.getPassword());
            prepareStatement.setInt(2, account.getIdAccount());
            int result = prepareStatement.executeUpdate();

            return result;
        }
        catch(Exception exception){
            System.out.println(exception);
        }
        return 0;
    }

    @Override
    public int delete(Account account) {
        try{
            IConnector connector = new ConnectorImpl();
            Connection connection = connector.getConnection();

            String sql="delete from account where idAccount=?";

            PreparedStatement prepareStatement = connection.prepareStatement(sql);

            prepareStatement.setInt(1, account.getIdAccount());
            int result = prepareStatement.executeUpdate();

            return result;
        }
        catch(Exception exception){
            System.out.println(exception);
        }
        return 0;
    }
}
