package entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "habitaciones")
public class Habitacione {

    @Override
    public String toString() {
        return "Habitacione{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", capacidad=" + capacidad +
                ", reservas=" + reservas +
                '}';
    }

    @Id
    @Column(name = "numero_habitacion", nullable = false)
    private Integer id;

    @Size(max = 100)
    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "precio", precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(name = "capacidad")
    private Integer capacidad;

    @OneToMany(mappedBy = "numeroHabitacion")
    private Set<Reserva> reservas = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Set<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(Set<Reserva> reservas) {
        this.reservas = reservas;
    }

}