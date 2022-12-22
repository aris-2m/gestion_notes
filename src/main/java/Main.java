

import model.Account;
import model.Person;
import model.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) throws Exception{

        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;

        try {

            entityManagerFactory = Persistence.createEntityManagerFactory("GlobalPersistUnit");
            //Creation de entity manager à partir de la factory
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction trans = entityManager.getTransaction();

            //-----------------------------------------------------------------------------
            System.out.println( "-------------- Insertion dans la BD -----------" );
            //-----------------------------------------------------------------------------

            Account account=new Account();
            account.setPassword("YES");

            trans.begin();
            entityManager.persist(account);
            trans.commit();

            Student student=new Student();
            student.setName("Aris");
            student.setSurname("MONKOUN");

            student.setAccount(account);


            trans.begin();
            entityManager.persist(student);
            trans.commit();

        }

        finally {
            if ( entityManager != null ) entityManager.close();
            if ( entityManagerFactory != null ) entityManagerFactory.close();
        }
    }
}