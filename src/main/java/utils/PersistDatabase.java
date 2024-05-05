package utils;

import entity.ConexionBD;
import jakarta.persistence.EntityManager;

public class PersistDatabase {
    public PersistDatabase() {
    }

    public int persist(Object object) {
        int transactionResult;

        try {
            persistObject(object);
            transactionResult = 0;
        } catch (Exception e) {
            if (ConexionBD.transaction.isActive()) {
                ConexionBD.transaction.rollback();
            }
            transactionResult = 1;
        } finally {
            ConexionBD.endConnection();
        }

        return transactionResult;
    }

    private void createConection() {
        ConexionBD.transaction.begin();
    }
    private void persistObject(Object object) {
        createConection();
        ConexionBD.entityManager.persist(object);
        commitTransaction();
    }

    private void commitTransaction() {
        ConexionBD.transaction.commit();
    }
}
