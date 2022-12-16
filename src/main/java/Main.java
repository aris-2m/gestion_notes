import model.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) throws Exception{

        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;

        try {

            entityManagerFactory = Persistence.createEntityManagerFactory("AccountUnit");
            //Creation de entity manager à partir de la factory
            entityManager = entityManagerFactory.createEntityManager();

            //-----------------------------------------------------------------------------
            System.out.println( "-------------- Insertion dans la BD -----------" );
            //-----------------------------------------------------------------------------

            Person person= new Person();
            person.setName("Aris");
            person.setSurname("MONKOUN");
            person.setPassword("YES");
            person.setTypeAccount("Student");

            EntityTransaction trans = entityManager.getTransaction();
            trans.begin();
            entityManager.persist(person);
            trans.commit();

        }

        finally {
            if ( entityManager != null ) entityManager.close();
            if ( entityManagerFactory != null ) entityManagerFactory.close();
        }
    }
}