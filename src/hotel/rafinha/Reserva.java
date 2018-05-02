/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.rafinha;

/**
 *
 * @author Maishi
 */
public class Reserva {
    private Paquete paquete;
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
    public void calcularPreciototal(){
        this.precioTotal=(this.habitacion.getPrecioBase() + this.paquete.getPrecioExtra())*this.dias;
        
    }
    
    
}
