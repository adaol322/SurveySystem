package Entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
    all wrong, but may be useful in the future ...
 */
public class main {
    public static void main(String args[]){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SystemAnkiet");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Wykladowcy wykladowca = new Wykladowcy("Marian", "Stary", "Magister", "StaryMarian@gmail.com");

        entityManager.getTransaction().begin();
        entityManager.persist(wykladowca);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

    }

}
