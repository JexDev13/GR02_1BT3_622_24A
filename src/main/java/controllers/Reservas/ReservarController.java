package controllers.Reservas;

import entity.Cliente;
import entity.ConexionBD;
import entity.Reserva;
import jakarta.persistence.EntityManager;
import utils.PersistDatabase;

import java.time.LocalDate;

public class ReservarController {

    private Reserva reserva;

    public ReservarController(
            int cedula,
            int numeroHabitacion,
            String checkIn,
            String checkOut,
            int cantidadPersonas
    ) {
        reserva = new Reserva();
        reserva.setId(123456789);
        reserva.setCedulaCliente(cedula);
        reserva.setNumeroHabitacion(numeroHabitacion);
        reserva.setDiaEntrada(LocalDate.parse(checkIn));
        reserva.setDiaSalida(LocalDate.parse(checkOut));
        reserva.setCantidadPersonas(cantidadPersonas);
    }

    public void reservar() {
        PersistDatabase persistence = new PersistDatabase();
        persistence.persist(reserva);
    }

}
