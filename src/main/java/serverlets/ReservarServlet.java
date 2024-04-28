package serverlets;

import web.Reseva;
import entity.ConexionBD;
import entity.Habitacione;

import jakarta.servlet.annotation.WebServlet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

@WebServlet(name="ReservarServlet", urlPatterns = {"/index"})
public class ReservarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtener los parámetros enviados desde el formulario HTML
        String cedula = req.getParameter("cedula");
        String checkIn =req.getParameter("checkIn");
        String checkOut = req.getParameter("checkOut");
        String cantidadPersonas = req.getParameter("cantidadPersonas");
        String numeroHabitacion = req.getParameter("numeroHabitacion");

        // Crear una nueva reserva con los datos recibidos
        Reseva reserva = new Reseva(cedula, numeroHabitacion, checkIn, checkOut, cantidadPersonas);

        // Obtener el EntityManager y la transacción
        EntityManager entityManager = ConexionBD.entityManager;
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            // Iniciar la transacción
            transaction.begin();

            // Obtener la habitación correspondiente a partir del número de habitación
            Habitacione habitacion = entityManager.find(Habitacione.class, numeroHabitacion);

            // Asignar la habitación a la reserva
            reserva.setNum_habitacion(numeroHabitacion);

            // Guardar la reserva en la base de datos
            entityManager.persist(reserva);

            // Confirmar la transacción
            transaction.commit();

            // Redirigir a una página de éxito o mostrar un mensaje de éxito
            resp.sendRedirect("index.jsp");
        } catch (Exception e) {
            // Si ocurre algún error, realizar un rollback de la transacción
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            // Redirigir a una página de error o mostrar un mensaje de error
            resp.sendRedirect("error.jsp");
        } finally {
            // Cerrar el EntityManager
            entityManager.close();
        }
    }

}
