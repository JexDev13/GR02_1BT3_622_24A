package controllers.Reservas;

import entity.Cliente;
import entity.ConexionBD;
import entity.Reserva;
import entity.ReservaDTO;
import jakarta.persistence.EntityManager;
import utils.PersistDatabase;

import java.time.LocalDate;

public class ReservarController {
    private final Reserva reserva;

    public ReservarController(
            ReservaDTO reservaDTO
    ) {
        reserva = reservaDTO.createReserva(
                reservaDTO.getCedula(),
                reservaDTO.getNumeroHabitacion(),
                reservaDTO.getCheckIn(),
                reservaDTO.getCheckOut(),
                reservaDTO.getCantidadPersonas()
        );
    }

    public void reservar() {
        PersistDatabase persistence = new PersistDatabase();
        persistence.persist(reserva);
    }
}
