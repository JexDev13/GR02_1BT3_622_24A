package test.model.services;

import model.entity.Reserva;
import model.services.ReservaService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.List;

public class ReservaServiceTest {
    private ReservaService reservaService;

    @Test
    public void testPartialFilter() {
        reservaService = new ReservaService();
        Reserva reserva1 = Mockito.mock(Reserva.class);
        Reserva reserva2 = Mockito.mock(Reserva.class);
        Reserva reserva3 = Mockito.mock(Reserva.class);

        when(reserva1.getEstaReservado()).thenReturn(true);
        when(reserva2.getEstaReservado()).thenReturn(false);
        when(reserva3.getEstaReservado()).thenReturn(true);

        List<Reserva> allReservas = Arrays.asList(reserva1, reserva2, reserva3);

        List<Reserva> availableReservas = reservaService.filterAvailableRooms(allReservas);

        assertEquals(2, availableReservas.size());
        assertTrue(availableReservas.contains(reserva1));
        assertTrue(availableReservas.contains(reserva3));
    }

    @Test
    public void testCompleteFilter() {
        reservaService = new ReservaService();
        Reserva reserva1 = Mockito.mock(Reserva.class);
        Reserva reserva2 = Mockito.mock(Reserva.class);

        when(reserva1.getEstaReservado()).thenReturn(true);
        when(reserva2.getEstaReservado()).thenReturn(true);

        List<Reserva> allReservas = Arrays.asList(reserva1, reserva2);

        List<Reserva> availableReservas = reservaService.filterAvailableRooms(allReservas);

        assertEquals(2, availableReservas.size());
        assertTrue(availableReservas.contains(reserva1));
        assertTrue(availableReservas.contains(reserva2));
    }

    @Test
    public void testEmptyFilter() {
        reservaService = new ReservaService();
        Reserva reserva1 = Mockito.mock(Reserva.class);
        Reserva reserva2 = Mockito.mock(Reserva.class);

        when(reserva1.getEstaReservado()).thenReturn(false);
        when(reserva2.getEstaReservado()).thenReturn(false);

        List<Reserva> allReservas = Arrays.asList(reserva1, reserva2);

        List<Reserva> availableReservas = reservaService.filterAvailableRooms(allReservas);

        assertEquals(0, availableReservas.size());
    }
}