/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.rafinha;

import java.util.Scanner;

/**
 *
 * @author Maishi
 */
public class Reserva {
    private Paquete paquete;
    private Piso piso;
    private Habitacion habitacion;
    private double precioTotal;
    private Huesped huesped;
    private int dias;
    
    Reserva(Huesped huesped, Paquete paquete, Habitacion habitacion, int dias){
        this.huesped=huesped;
        this.paquete=paquete;
        this.habitacion=habitacion;
        this.dias=dias;
        
    }
    
    public void validarReserva(){
        if(this.habitacion.isDisponibilidad()== true && this.huesped.getReserva1() == null ){
            System.out.println("La reserva es valida.");
            
        }
        if(this.habitacion.isDisponibilidad()== true && this.huesped.getReserva2() == null ){
            System.out.println("La reserva es valida.");
        }
        else{
            System.out.println("Escoja otra habitación o cambie huesped.");
            
        }
    }
    public void calcularPreciototal(boolean comprobador){
        
        if(comprobador==false){
            this.precioTotal=(this.habitacion.getPrecioBase() + this.paquete.getPrecioExtra())*this.dias;
        }
        else{
            this.precioTotal = (this.habitacion.getPrecioBase() + this.paquete.getPrecioExtra() + (this.habitacion.getPrecioBase()*0.1))*this.dias;
        }
        
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public Piso getPiso() {
        return piso;
    }

    public void setPiso(Piso piso) {
        this.piso = piso;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }
    
    
}

