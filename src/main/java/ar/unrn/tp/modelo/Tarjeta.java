package ar.unrn.tp.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tarjeta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private int numero;

    public Tarjeta(String nombre, int numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    public Tarjeta(String nombre) {
        this.nombre = nombre;
    }

    protected Tarjeta() {

    }

    public boolean esTarjeta(Tarjeta tarjeta) {
        return this.nombre.equals(tarjeta.nombre());
    }

    private String nombre() {
        return this.nombre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}