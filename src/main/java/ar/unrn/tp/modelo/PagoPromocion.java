package ar.unrn.tp.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("pago")
public class PagoPromocion extends Promocion {

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Tarjeta tarjeta;


    public PagoPromocion(LocalDate fechaInicio, LocalDate fechaFin, Double porcentaje, Tarjeta tarjeta) {
        super(fechaInicio, fechaFin, porcentaje);
        this.tarjeta = tarjeta;
    }

    protected PagoPromocion() {
    }

    public double aplicarDescuento(double total, Tarjeta tarjeta) {
        if (tarjeta.esTarjeta(this.tarjeta))
            return total - (total * descuento());
        return total;
    }

    private double descuento() {
        if (estaEnCurso())
            return super.porcentaje();
        return 0;
    }

    public boolean suTarjetaEs(Tarjeta tarjeta) {
        return this.tarjeta.esTarjeta(tarjeta);
    }
}