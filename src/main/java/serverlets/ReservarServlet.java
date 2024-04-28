package serverlets;

import entity.Cliente;
import entity.Reserva;

import jakarta.servlet.annotation.WebServlet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

import entity.ConexionBD;


@WebServlet(name="ReservarServlet", urlPatterns = {"/ReservarServlet"})
public class ReservarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("prueba");
        // Obtener los parámetros enviados desde el formulario HTML
        String numeroHabitacion = req.getParameter("numeroHabitacion");
        String cedula = req.getParameter("cedula");
        String checkIn =req.getParameter("checkIn");
        String checkOut = req.getParameter("checkOut");
        String cantidadPersonas = req.getParameter("cantidadPersonas");

        Reserva reserva = new Reserva();
        reserva.setCedulaCliente(Integer.parseInt(cedula));
        reserva.setNumeroHabitacion(Integer.parseInt(numeroHabitacion));
        reserva.setDiaEntrada(LocalDate.parse(checkIn));
        reserva.setDiaSalida(LocalDate.parse(checkOut));
        reserva.setCantidadPersonas(Integer.parseInt(cantidadPersonas));

        System.out.println("prueba");

        try {
            // Iniciar la transacción
            ConexionBD.transaction.begin();

            // Guardar la reserva en la base de datos
            ConexionBD.entityManager.persist(reserva);

            // Confirmar la transacción
            ConexionBD.transaction.commit();

            System.out.println("Exito");
            // Redireccionar a una página de éxito
            //resp.sendRedirect("exito.jsp");
        } catch (Exception e) {
            // Manejar cualquier excepción
            if (ConexionBD.transaction.isActive()) {
                ConexionBD.transaction.rollback();
                System.out.println("Exito if");
            }
            e.printStackTrace();

            // Redireccionar a una página de error
           // resp.sendRedirect("error.jsp");
            System.out.println("Fallo");
        } finally {
            // Cerrar la conexión
            ConexionBD.endConnection();
        }


    }

}
