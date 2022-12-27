package beans.crud;

import beans.crud.ITags.IConnector;
import beans.crud.ITags.ICrud;
import beans.dao.Student;

import java.sql.*;

public class CrudStudentImpl implements ICrud<Student> {
    @Override
    public ResultSet getAll() {
        try{
            IConnector connector = new ConnectorImpl();
            Connection connection = connector.getConnection();

            String sql=" select person.name, person.surname,fieldofstudy.name" +
                       " from person " +
                       " inner join student on person.idPerson = student.idPerson" +
                       " inner join fieldofstudy on fieldofstudy.idFieldOfStudy = student.fkFieldOfStudy";

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

            String sql=" select person.idPerson, person.name, person.surname,fieldofstudy.name" +
                       " from person " +
                       " inner join student on person.idPerson = student.idPerson" +
                       " inner join fieldofstudy on fieldofstudy.idFieldOfStudy = student.fkFieldOfStudy" +
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
    public int insert(Student student) {
        try{
            IConnector connector = new ConnectorImpl();
            Connection connection = connector.getConnection();

            String sql="insert into student(idPerson, fkAccount, fkFieldOfStudy) values(?,?,?)";

            PreparedStatement prepareStatement = connection.prepareStatement(sql);

            prepareStatement.setInt(1, student.getIdPerson());
            prepareStatement.setInt(2, student.getFkAccount());
            prepareStatement.setInt(3, student.getFkFieldOfStudy());

            int result = prepareStatement.executeUpdate();

            return result;
        }
        catch(SQLIntegrityConstraintViolationException exception){
            System.out.println(exception);
        }
        catch(Exception exception){
            System.out.println(exception);
        }
        return 0;
    }

    @Override
    public int update(Student student) {
        try{
            IConnector connector = new ConnectorImpl();
            Connection connection = connector.getConnection();

            String sql="update student set fkAccount=?, fkFieldOfStudy=? where idPerson=?";

            PreparedStatement prepareStatement = connection.prepareStatement(sql);

            prepareStatement.setInt(1, student.getFkAccount());
            prepareStatement.setInt(2, student.getFkFieldOfStudy());
            prepareStatement.setInt(3, student.getIdPerson());
            int result = prepareStatement.executeUpdate();

            return result;
        }
        catch(Exception exception){
            System.out.println(exception);
        }
        return 0;
    }

    @Override
    public int delete(Student student) {
        try{
            IConnector connector = new ConnectorImpl();
            Connection connection = connector.getConnection();

            String sql="delete from student where idPerson=?";

            PreparedStatement prepareStatement = connection.prepareStatement(sql);

            prepareStatement.setInt(1, student.getIdPerson());
            int result = prepareStatement.executeUpdate();

            return result;
        }
        catch(Exception exception){
            System.out.println(exception);
        }
        return 0;
    }

}
