package beans.crud;

import beans.crud.ITags.IConnector;
import beans.crud.ITags.ICrud;
import beans.dao.FieldOfStudy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CrudFieldOfStudyImpl implements ICrud<FieldOfStudy> {
    @Override
    public ResultSet getAll() {
        try{
            IConnector connector = new ConnectorImpl();
            Connection connection = connector.getConnection();

            String sql=" select fieldofstudy.name from fieldofstudy";

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
        return null;
    }

    @Override
    public int insert(FieldOfStudy fieldOfStudy) {
        return 0;
    }

    @Override
    public int update(FieldOfStudy fieldOfStudy) {
        return 0;
    }

    @Override
    public int delete(FieldOfStudy fieldOfStudy) {
        return 0;
    }
}
