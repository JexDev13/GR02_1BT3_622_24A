package serverlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.entity.Reserva;
import model.services.ReservaService;


@WebServlet(name="reservarservlet", urlPatterns = {"/reservar-servlet"})
public class ReservarServlet extends HttpServlet {
    private ReservaService reservaService;
    public void init() {
        reservaService = new ReservaService(mockPersistDatabase);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String numeroHabitacion = req.getParameter("numeroHabitacion");
        String cedula = req.getParameter("cedula");
        String checkIn = req.getParameter("checkIn");
        String checkOut = req.getParameter("checkOut");
        String cantidadPersonas = req.getParameter("cantidadPersonas");

        Reserva newReserva = createReserva(
                numeroHabitacion,
                cedula,
                checkIn,
                checkOut,
                cantidadPersonas
        );

        reservaService.registrarReserva(newReserva);
    }

    // En tu clase ReservarServlet
    public void doPostPublic(HttpServletRequest request, HttpServletResponse response) {
        doPost(request, response);
    }

    public Reserva createReserva(
            String numeroHabitacion,
            String cedula,
            String checkIn,
            String checkOut,
            String cantidadPersonas
    ) {
        Reserva newReserva = new Reserva();

        newReserva.setCantidadPersonas(
                Integer.parseInt(cantidadPersonas)
        );
        newReserva.setCedulaCliente(
                Integer.parseInt(cedula)
        );
        newReserva.setDiaEntrada(
                java.time.LocalDate.parse(checkIn)
        );
        newReserva.setDiaSalida(
                java.time.LocalDate.parse(checkOut)
        );
        newReserva.setNumeroHabitacion(
                Integer.parseInt(numeroHabitacion)
        );
        newReserva.setEstaReservado(true);
        return newReserva;
    }



    public void destroy() {
    }
}
