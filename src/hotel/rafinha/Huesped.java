/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.rafinha;

/**
 *
 * @author Nuria
 */
public class Huesped {
    private String nombre;
    private DUI dui;
    private TarjetaDeCredito tarjeta;
    private reserva reserva1;
    private reserva reserva2;

    public Huesped() {
    }

    public Huesped(String nombre, DUI dui, TarjetaDeCredito tarjeta) {
        this.nombre = nombre;
        this.dui = dui;
        this.tarjeta = tarjeta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public DUI getDui() {
        return dui;
    }

    public void setDui(DUI dui) {
        this.dui = dui;
    }

    public TarjetaDeCredito getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(TarjetaDeCredito tarjeta) {
        this.tarjeta = tarjeta;
    }
    
}
