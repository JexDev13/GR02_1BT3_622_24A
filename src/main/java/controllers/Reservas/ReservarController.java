package controllers.Reservas;

import model.entity.Reserva;
import model.ReservaDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.io.Serializable;

public class ReservarController implements Serializable {
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
        EntityManager em;

            em = Persistence.createEntityManagerFactory("default").createEntityManager();
            em.getTransaction().begin();

            em.persist(reserva);

            em.getTransaction().commit();

        em.close();

//        PersistDatabase persistence = new PersistDatabase();
//        persistence.persist(reserva);
    }
}
