package serverlets;

import controllers.Reservas.ReservarController;

import model.ReservaDTO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name="reservarservlet", urlPatterns = {"/reservar-servlet"})
public class ReservarServlet extends HttpServlet {

    public void init() {
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("prueba");
        // Obtener los parámetros enviados desde el formulario HTML
        String numeroHabitacion = req.getParameter("numeroHabitacion");
        String cedula = req.getParameter("cedula");
        String checkIn = req.getParameter("checkIn");
        String checkOut = req.getParameter("checkOut");
        String cantidadPersonas = req.getParameter("cantidadPersonas");

        ReservaDTO reservaDTO = new ReservaDTO(
            Integer.parseInt(cedula),
            Integer.parseInt(numeroHabitacion),
            checkIn,
            checkOut,
            Integer.parseInt(cantidadPersonas)
        );

        reservar(reservaDTO);
    }

    private void reservar(
        ReservaDTO reservaDTO
    ){
        ReservarController reservarController = new ReservarController(reservaDTO);
        reservarController.reservar();
    }

    public void destroy() {
    }
}
