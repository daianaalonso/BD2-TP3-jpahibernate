package ar.unrn.tp.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Marca {

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;

    public Marca(String nombre) {
        this.nombre = nombre;
    }

    protected Marca() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public boolean esMarca(Marca marca) {
        return this.nombre.equals(marca.nombre());
    }

    private String nombre() {
        return this.nombre;
    }
}
