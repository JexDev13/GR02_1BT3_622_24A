package serverlets;

import controllers.Reservas.ReservarController;
import entity.Cliente;
import entity.Reserva;

//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityTransaction;\
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import entity.ConexionBD;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name="reservarservlet", urlPatterns = {"/reservar-servlet"})
public class ReservarServlet extends HttpServlet {

    public EntityManagerFactory entityManagerFactory;
    public EntityManager entityManager;
    public EntityTransaction transaction;

    public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("prueba");
        // Obtener los parámetros enviados desde el formulario HTML
        String numeroHabitacion = req.getParameter("numeroHabitacion");
        String cedula = req.getParameter("cedula");
        String checkIn =req.getParameter("checkIn");
        String checkOut = req.getParameter("checkOut");
        String cantidadPersonas = req.getParameter("cantidadPersonas");

        // Crear una nueva instancia de ReservarController
        ReservarController reservarController = new ReservarController(
                Integer.parseInt(cedula),
                Integer.parseInt(numeroHabitacion),
                checkIn,
                checkOut,
                Integer.parseInt(cantidadPersonas)
        );

        reservarController.reservar();
    }

    public void destroy() {
    }
}
