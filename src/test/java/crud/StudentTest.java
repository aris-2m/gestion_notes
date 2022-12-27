package crud;

import beans.crud.CrudStudentImpl;
import beans.crud.ITags.ICrud;
import beans.dao.Student;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;


public class StudentTest {
    @Test
    public void testGetAll() throws SQLException {
        ICrud crudStudent = (ICrud) new CrudStudentImpl();

        ResultSet resultSet = crudStudent.getAll();
        String field1 = null;
        while (resultSet.next()) {
            field1 = resultSet.getString(1);
            System.out.println(field1);
        }
        resultSet.close();

//        assertEquals("Aris", field1);
    }

    @Test
    public void testGetById() throws SQLException {
        ICrud crudStudent = (ICrud) new CrudStudentImpl();

        ResultSet resultSet = crudStudent.getById(1);
        int field1 = 0;
        while (resultSet.next()) {
            field1 = resultSet.getInt(1);
        }
        resultSet.close();

        assertEquals(1, field1);
    }

    @Test
    public void testInsert()  {
        ICrud crudStudent = (ICrud) new CrudStudentImpl();

        Student student=new Student();
        student.setIdPerson(2);

        int r=crudStudent.insert(student);
    }

    @Test
    public void testUpdate()  {
        ICrud crudStudent = (ICrud) new CrudStudentImpl();

        Student student=new Student();
        student.setIdPerson(1);
        student.setFkAccount(1);
        student.setFkFieldOfStudy(2);

        int r=crudStudent.update(student);

    }

    @Test
    public void testDelete()  {
        ICrud crudStudent = (ICrud) new CrudStudentImpl();

        Student student=new Student();
        student.setIdPerson(1);
        student.setFkAccount(1);
        student.setFkFieldOfStudy(2);

//        int r=crudStudent.delete(student);

    }
}
