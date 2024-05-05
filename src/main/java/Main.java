
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

        try {
//            EntityManager entityManager = ConexionBD.entityManager;

//            ConexionBD conexionBD = new ConexionBD();
            // Iniciar una transacción
//            ConexionBD.transaction.begin();

            // Crear un nuevo objeto Cliente
            Cliente cliente = new Cliente();
            cliente.setId(192);
            cliente.setNombre("Juan");
            cliente.setApellidos("Perez");

//            entityManager.persist(cliente);

//            ConexionBD.transaction.commit();
        } catch (Exception e) {
            // Manejar cualquier excepción
//            if (ConexionBD.transaction.isActive()) {
//                ConexionBD.transaction.rollback();
//            }
            System.out.println("ASJGDHJASHDJKU");
            System.out.println("Error: " + e.getMessage());
//            e.printStackTrace();
        } finally {
            // Cerrar el EntityManager
//            ConexionBD.endConnection();
        }
    }
}
