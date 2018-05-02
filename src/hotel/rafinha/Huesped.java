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
    private Reserva reserva1;
    private Reserva reserva2;

    public Huesped() {
    }

    public Reserva getReserva1() {
        return reserva1;
    }

    public void setReserva1(Reserva reserva1) {
        this.reserva1 = reserva1;
    }

    public Reserva getReserva2() {
        return reserva2;
    }

    public void setReserva2(Reserva reserva2) {
        this.reserva2 = reserva2;
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
