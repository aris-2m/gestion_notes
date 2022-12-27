package beans.crud;

import beans.crud.ITags.ICrud;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        ICrud crudStudent= (ICrud) new CrudStudentImpl();

        ResultSet resultSet= crudStudent.getById(1);
        while (resultSet.next()) {
            String name1 = resultSet.getString(1);
            String name2 = resultSet.getString(2);
            String name3 = resultSet.getString(3);
//            int name1 = resultSet.getInt(1);
//            int name2 = resultSet.getInt(2);
//            int name3 = resultSet.getInt(3);

            System.out.println("name1:" + name1);
            System.out.println("name2:" + name2);
            System.out.println("name3:" + name3);
        }
        resultSet.close();


//        ICrud crudAccount= (ICrud) new CrudAccountImpl();
//
//        Account account=new Account();
//        account.setIdAccount(5);
//        account.setPassword("1234");
//
//        int r=crudAccount.delete(account);
//        System.out.println(r);

//        ResultSet resultSet= crudAccount.getById(1);
//
//        while (resultSet.next()) {
//            Integer empId = resultSet.getInt(1);
//            String firstName = resultSet.getString(2);
//
//            System.out.println("empId:" + empId);
//            System.out.println("firstName:" + firstName);
//        }
//        resultSet.close();

    }
}
