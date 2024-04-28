package entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @Column(name = "codigo", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cedula_cliente")
    private int cedulaCliente;

    @Column(name = "numero_habitacion")
    private Integer numeroHabitacion;

    @Column(name = "dia_entrada")
    private LocalDate diaEntrada;

    @Column(name = "dia_salida")
    private LocalDate diaSalida;

    @Column(name = "cantidad_personas")
    private Integer cantidadPersonas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(int cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public Integer getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(Integer numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public LocalDate getDiaEntrada() {
        return diaEntrada;
    }

    public void setDiaEntrada(LocalDate diaEntrada) {
        this.diaEntrada = diaEntrada;
    }

    public LocalDate getDiaSalida() {
        return diaSalida;
    }

    public void setDiaSalida(LocalDate diaSalida) {
        this.diaSalida = diaSalida;
    }

    public Integer getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(Integer cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

}