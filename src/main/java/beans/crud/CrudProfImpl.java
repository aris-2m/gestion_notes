package beans.crud;

import beans.crud.ITags.IConnector;
import beans.crud.ITags.ICrud;
import beans.dao.Prof;
import beans.dao.Student;

import java.sql.*;

public class CrudProfImpl implements ICrud<Prof> {

    @Override
    public ResultSet getAll() {
        try{
            IConnector connector = new ConnectorImpl();
            Connection connection = connector.getConnection();

            String sql=" select person.name, person.surname, prof.code, prof.speciality" +
                    " from person " +
                    " inner join prof on person.idPerson = prof.idPerson";

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

            String sql=" select person.idPerson, person.name, person.surname, prof.code, prof.speciality" +
                    " from person " +
                    " inner join prof on person.idPerson = prof.idPerson" +
                    " where person.idPerson=?";


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
    public int insert(Prof prof) {
        try{
            IConnector connector = new ConnectorImpl();
            Connection connection = connector.getConnection();

            String sql="insert into prof(idPerson, fkAccount, code, speciality) values(?,?,?,?)";

            PreparedStatement prepareStatement = connection.prepareStatement(sql);

            prepareStatement.setInt(1, prof.getIdPerson());
            prepareStatement.setInt(2, prof.getFkAccount());
            prepareStatement.setString(3, prof.getCode());
            prepareStatement.setString(4, prof.getSpeciality());

            int result = prepareStatement.executeUpdate();

            return result;
        }
        catch(Exception exception){
            System.out.println(exception);
        }
        return 0;
    }

    @Override
    public int update(Prof prof) {
        try{
            IConnector connector = new ConnectorImpl();
            Connection connection = connector.getConnection();

            String sql="update prof set fkAccount=?, code=?, speciality=? where idPerson=?";

            PreparedStatement prepareStatement = connection.prepareStatement(sql);


            prepareStatement.setInt(1, prof.getFkAccount());
            prepareStatement.setString(2, prof.getCode());
            prepareStatement.setString(3, prof.getSpeciality());
            prepareStatement.setInt(4, prof.getIdPerson());
            int result = prepareStatement.executeUpdate();

            return result;
        }
        catch(Exception exception){
            System.out.println(exception);
        }
        return 0;
    }

    @Override
    public int delete(Prof prof) {
        try{
            IConnector connector = new ConnectorImpl();
            Connection connection = connector.getConnection();

            String sql="delete from prof where idPerson=?";

            PreparedStatement prepareStatement = connection.prepareStatement(sql);

            prepareStatement.setInt(1, prof.getIdPerson());
            int result = prepareStatement.executeUpdate();

            return result;
        }
        catch(Exception exception){
            System.out.println(exception);
        }
        return 0;
    }
}
