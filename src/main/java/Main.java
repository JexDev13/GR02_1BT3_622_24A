
import entity.Cliente;
import entity.ConexionBD;
import entity.Habitacione;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        /*try {
            ConexionBD.transaction.begin();

            Cliente cliente = new Cliente();
            cliente.setId(171010102);
            cliente.setNombre("Samantha");
            cliente.setApellidos("Arias");

            ConexionBD.entityManager.persist(cliente);

            ConexionBD.transaction.commit();
        } finally {
            if(ConexionBD.transaction.isActive()) {
                ConexionBD.transaction.rollback();
            }
            ConexionBD.entityManager.close();
            ConexionBD.entityManagerFactory.close();
        }*/

        try {
            EntityManager entityManager = ConexionBD.entityManager;

            // Iniciar una transacción
            ConexionBD.transaction.begin();

            // Ejecutar la consulta para obtener todas las habitaciones
            List<Habitacione> habitaciones = entityManager.createQuery("SELECT h FROM Habitacione h", Habitacione.class).getResultList();

            // Imprimir las habitaciones obtenidas
            for (Habitacione habitacion : habitaciones) {
                System.out.println(habitacion.toString());
            }

            // Confirmar la transacción
            ConexionBD.transaction.commit();
        } catch (Exception e) {
            // Manejar cualquier excepción
            if (ConexionBD.transaction.isActive()) {
                ConexionBD.transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            // Cerrar el EntityManager
            ConexionBD.endConnection();
        }







    }
}
