package crud;

import beans.crud.CrudFieldOfStudyImpl;
import beans.crud.CrudProfImpl;
import beans.crud.ITags.ICrud;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class FieldOfStudyTest {
    @Test
    public void testGetAll() throws SQLException {
        ICrud crudFieldOfStudy = (ICrud) new CrudFieldOfStudyImpl();

        ResultSet resultSet = crudFieldOfStudy.getAll();
        String field1 = null;

        while (resultSet.next()) {
            field1 = resultSet.getString(1);
            System.out.println(field1);
        }
        resultSet.close();

//        assertEquals("IID", field1);
    }
}
