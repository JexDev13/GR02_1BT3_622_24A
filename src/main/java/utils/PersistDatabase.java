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
            rollbackTransaction();
            transactionResult = 1;
        } finally {
            ConexionBD.endConnection();
        }

        return transactionResult;
    }


    private void rollbackTransaction() {
        if (ConexionBD.transaction.isActive()) {
            ConexionBD.transaction.rollback();
        }
    }

    private void persistObject(Object object) {
        ConexionBD.transaction.begin();
        ConexionBD.entityManager.persist(object);
        ConexionBD.transaction.commit();
    }

}
