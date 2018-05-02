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
    private String numeroDui;
    private String numeroTarjetaCredito;
    private String bancoTarjeta;
    private Reserva reserva1;
    private Reserva reserva2;

    public Huesped() {
    }
    
    public Huesped(String nombre, String numeroDui, String numeroTarjetaCredito, String bancoTarjeta, Reserva reserva1, Reserva reserva2) {
        this.nombre = nombre;
        this.numeroDui = numeroDui;
        this.numeroTarjetaCredito = numeroTarjetaCredito;
        this.bancoTarjeta = bancoTarjeta;
        this.reserva1 = reserva1;
        this.reserva2 = reserva2;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroDui() {
        return numeroDui;
    }

    public void setNumeroDui(String numeroDui) {
        this.numeroDui = numeroDui;
    }

    public String getNumeroTarjetaCredito() {
        return numeroTarjetaCredito;
    }

    public void setNumeroTarjetaCredito(String numeroTarjetaCredito) {
        this.numeroTarjetaCredito = numeroTarjetaCredito;
    }

    public String getBancoTarjeta() {
        return bancoTarjeta;
    }

    public void setBancoTarjeta(String bancoTarjeta) {
        this.bancoTarjeta = bancoTarjeta;
    }

}
