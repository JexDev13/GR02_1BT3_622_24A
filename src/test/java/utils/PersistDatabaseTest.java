package utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PersistDatabaseTest {

    @InjectMocks
    private PersistDatabase persistDatabase;

    @Mock
    private ConexionBD mockConexionBD;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPersistSuccess() {
        Object testObject = new Object();

        when(mockConexionBD.persist(testObject)).thenReturn(Integer.valueOf(0));

        int result = persistDatabase.persist(testObject);

        assertEquals(0, result);
        verify(mockConexionBD, times(1)).persist(testObject);
    }

    @Test
    void testPersistFailure() {
        Object testObject = new Object();

        when(mockConexionBD.persist(testObject)).thenReturn(Integer.valueOf(1));

        int result = persistDatabase.persist(testObject);

        assertEquals(1, result);
        verify(mockConexionBD, times(1)).persist(testObject);
    }

    @Test
    void testGetAll() {
        List<Object> expectedList = Arrays.asList(new Object(), new Object());

        when(mockConexionBD.getAll(Object.class)).thenReturn(expectedList);

        List<Object> result = persistDatabase.getAll(Object.class);

        assertEquals(expectedList, result);
        verify(mockConexionBD, times(1)).getAll(Object.class);
    }
}