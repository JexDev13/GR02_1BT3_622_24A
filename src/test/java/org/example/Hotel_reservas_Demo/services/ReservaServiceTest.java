package org.example.Hotel_reservas_Demo.services;

import model.entity.Reserva;
import model.services.ReservaService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import utils.PersistDatabase;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

public class ReservaServiceTest {
    private ReservaService reservaService;

    @Mock
    private PersistDatabase mockPersistDatabase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        reservaService = new ReservaService(mockPersistDatabase);
    }

    @Test
    public void testPartialFilter() {
        reservaService = new ReservaService(mockPersistDatabase);
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
        reservaService = new ReservaService(mockPersistDatabase);
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
        reservaService = new ReservaService(mockPersistDatabase);
        Reserva reserva1 = Mockito.mock(Reserva.class);
        Reserva reserva2 = Mockito.mock(Reserva.class);

        when(reserva1.getEstaReservado()).thenReturn(false);
        when(reserva2.getEstaReservado()).thenReturn(false);

        List<Reserva> allReservas = Arrays.asList(reserva1, reserva2);

        List<Reserva> availableReservas = reservaService.filterAvailableRooms(allReservas);

        assertEquals(0, availableReservas.size());
    }



    @org.junit.jupiter.api.Test
    void testRegistrarReserva() {
        Reserva mockReserva = Mockito.mock(Reserva.class);

        when(mockPersistDatabase.persist(mockReserva)).thenReturn(0);

        reservaService.registrarReserva(mockReserva);

        verify(mockPersistDatabase, times(1)).persist(mockReserva);
    }

    @org.junit.jupiter.api.Test
    void testGetAvailableRooms() {
        Reserva mockReserva1 = Mockito.mock(Reserva.class);
        Reserva mockReserva2 = Mockito.mock(Reserva.class);

        when(mockReserva1.getEstaReservado()).thenReturn(true);
        when(mockReserva2.getEstaReservado()).thenReturn(false);

        List<Reserva> allReservas = Arrays.asList(mockReserva1, mockReserva2);

        when(mockPersistDatabase.getAll(Reserva.class)).thenReturn(allReservas);

        List<Reserva> availableReservas = reservaService.getAvailableRooms();

        assertEquals(1, availableReservas.size());
        assertTrue(availableReservas.contains(mockReserva1));
    }

}