package org.example.Hotel_reservas_Demo.serverlets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import model.entity.Reserva;
import serverlets.ReservarServlet;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ReservarServletTest {

    private ReservarServlet reservarServlet;
    private Reserva mockReserva;

    @BeforeEach
    void setUp() {
        reservarServlet = new ReservarServlet();
        mockReserva = Mockito.mock(Reserva.class);
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

}