package org.example.Hotel_reservas_Demo.serverlets;

import model.entity.Reserva;
import model.services.ReservaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import serverlets.ReservarServlet;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class ReservarServletTest {

    private ReservarServlet reservarServlet;
    private Reserva mockReserva;
    private ReservaService reservaService;

    @BeforeEach
    void setUp() {
        reservarServlet = new ReservarServlet();
        mockReserva = Mockito.mock(Reserva.class);
        reservaService = new ReservaService();
    }
    @Test
    void testCreateReserva() {
        // Configura el objeto mock para devolver valores específicos cuando se llamen sus métodos
        Mockito.when(mockReserva.getCantidadPersonas()).thenReturn(2);
        Mockito.when(mockReserva.getCedulaCliente()).thenReturn(12345678);
        Mockito.when(mockReserva.getDiaEntrada()).thenReturn(java.time.LocalDate.parse("2022-12-01"));
        Mockito.when(mockReserva.getDiaSalida()).thenReturn(java.time.LocalDate.parse("2022-12-05"));
        Mockito.when(mockReserva.getNumeroHabitacion()).thenReturn(101);
        Mockito.when(mockReserva.getEstaReservado()).thenReturn(true);

        // Llama al método que estás probando
        Reserva result = reservarServlet.createReserva(
                "101",
                "12345678",
                "2022-12-01",
                "2022-12-05",
                "2"
        );

        // Comprueba que los resultados son los esperados
        assertEquals(mockReserva.getCantidadPersonas(), result.getCantidadPersonas());
        assertEquals(mockReserva.getCedulaCliente(), result.getCedulaCliente());
        assertEquals(mockReserva.getDiaEntrada(), result.getDiaEntrada());
        assertEquals(mockReserva.getDiaSalida(), result.getDiaSalida());
        assertEquals(mockReserva.getNumeroHabitacion(), result.getNumeroHabitacion());
        assertEquals(mockReserva.getEstaReservado(), result.getEstaReservado());
    }


    @Test
    public void testPartialFilter() {
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
        Reserva reserva1 = Mockito.mock(Reserva.class);
        Reserva reserva2 = Mockito.mock(Reserva.class);

        when(reserva1.getEstaReservado()).thenReturn(false);
        when(reserva2.getEstaReservado()).thenReturn(false);

        List<Reserva> allReservas = Arrays.asList(reserva1, reserva2);

        List<Reserva> availableReservas = reservaService.filterAvailableRooms(allReservas);

        assertEquals(0, availableReservas.size());
    }
}