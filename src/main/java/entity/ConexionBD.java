package entity;

import jakarta.persistence.*;

public class ConexionBD {

    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    public static EntityManager entityManager = entityManagerFactory.createEntityManager();
    public static EntityTransaction transaction = entityManager.getTransaction();

    public static void endConnection() {

        entityManager.close();
        entityManagerFactory.close();

    }
}
