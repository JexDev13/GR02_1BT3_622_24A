package utils;

import entity.ConexionBD;
import jakarta.persistence.EntityManager;

public class PersistDatabase {
    public PersistDatabase() {
    }

    public int persist(Object object) {
        int transactionResult;

        try {
            createConection();
            ConexionBD.entityManager.persist(object);
            commitTransaction();
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

    private void commitTransaction() {
        ConexionBD.transaction.commit();
    }
}
