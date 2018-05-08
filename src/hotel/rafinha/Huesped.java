/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.rafinha;

/**
 *Clase denominada Huesped que contiene sus atributos, constructores y metodos set y get
 * @author Nuria
 */

public class Huesped {
    //Atributos relacionados a huesped declarados privados 
    private String nombre;
    private String numeroDui;
    private String numeroTarjetaCredito;
    private Reserva reserva1;
    private Reserva reserva2;
    
    /**
     * Constructor vacio de la clase para inicializar el objeto con valores por default
     */

    public Huesped() {
    }
    
    /**
     * Constructor de la clase para inicializar el objeto con valores predeterminados
     * @param nombre nombre del huesped
     * @param numeroDui numero de DUI del huesped
     * @param numeroTarjetaCredito numero de la tarjeta de credito del huesped
     */
    public Huesped(String nombre, String numeroDui, String numeroTarjetaCredito) {
        this.nombre = nombre;
        this.numeroDui = numeroDui;
        this.numeroTarjetaCredito = numeroTarjetaCredito;
    }

    /**
     * Metodo get para obtener una de las reservas del huesped
     * @return el dato obtenido de reserva1
     */
    public Reserva getReserva1() {
        return reserva1;
    }

    /**
     * Metodo set para acceder al atributo reserva1 del huesped
     * @param reserva1 valor de la reserva1
     */
    public void setReserva1(Reserva reserva1) {
        this.reserva1 = reserva1;
    }

    /**
     * Metodo get para obtener una de las reservas del huesped
     * @return el dato obtenido de reserva2
     */
    public Reserva getReserva2() {
        return reserva2;
    }

    /**
     * Metodo set para acceder al atributo reserva2 del huesped
     * @param reserva2 valor de la reserva2
     */
    public void setReserva2(Reserva reserva2) {
        this.reserva2 = reserva2;
    }

    /**
     * Metodo get para obtener el nombre del huesped
     * @return el dato obtenido para la variable nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo set para acceder al atributo nombre del huesped
     * @param nombre nombre del huesped que solicita la reserva
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo get para obtener el numero de DUI del huesped
     * @return el dato obtenido para la variable numeroDui
     */
    public String getNumeroDui() {
        return numeroDui;
    }

    /**
     * Metodo set para acceder al atributo numeroDui del huesped
     * @param numeroDui el numero del DUI del huesped que solicita la reserva
     */
    public void setNumeroDui(String numeroDui) {
        this.numeroDui = numeroDui;
    }

    /**
     * Metodo get para obtener el numero de la tarjeta de credito con la que cancelara el huesped
     * @return el dato obtenido para la variable numeroTarjetaCredito
     */
    public String getNumeroTarjetaCredito() {
        return numeroTarjetaCredito;
    }

    /**
     * Metodo set para acceder al atributo numeroTarjetaCredito del huesped
     * @param numeroTarjetaCredito el numero de la tarjeta de credito del huesped que solicita la reserva
     */
    public void setNumeroTarjetaCredito(String numeroTarjetaCredito) {
        this.numeroTarjetaCredito = numeroTarjetaCredito;
    }

}
