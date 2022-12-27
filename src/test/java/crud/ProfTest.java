package crud;

import beans.crud.CrudProfImpl;
import beans.crud.CrudStudentImpl;
import beans.crud.ITags.ICrud;
import beans.dao.Prof;
import beans.dao.Student;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class ProfTest {
    @Test
    public void testGetAll() throws SQLException {
        ICrud crudProf = (ICrud) new CrudProfImpl();

        ResultSet resultSet = crudProf.getAll();
        String field1 = null;
        while (resultSet.next()) {
            field1 = resultSet.getString(1);
        }
        resultSet.close();

        assertEquals("Mohamed", field1);
    }

    @Test
    public void testGetById() throws SQLException {
        ICrud crudProf = (ICrud) new CrudProfImpl();

        ResultSet resultSet = crudProf.getById(4);
        int field1 = 0;
        while (resultSet.next()) {
            field1 = resultSet.getInt(1);
            System.out.println(field1);
        }
        resultSet.close();

        assertEquals(4, field1);
    }

    @Test
    public void testUpdate() throws SQLException{
        ICrud crudProf = (ICrud) new CrudProfImpl();

        Prof prof=new Prof();
        prof.setIdPerson(4);
        prof.setFkAccount(4);
        prof.setCode("ENSAPROF_1");
        prof.setSpeciality("Software Process");

        int r=crudProf.update(prof);
    }
}
