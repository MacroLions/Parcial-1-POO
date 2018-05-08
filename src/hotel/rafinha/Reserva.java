/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.rafinha;

import java.util.Scanner;

/**
 *Clase que contiene los objetos necesarios para crear una nueva reserva y las funciones que se utilizaran para esto.
 * @author Maishi
 */
public class Reserva {
    private Paquete paquete;
    private Piso piso;
    private Habitacion habitacion;
    private double precioTotal;
    private Huesped huesped;
    private int dias;
    private String TipoPaquete;
    
    /**
     * Constructor en el cual se inicializan los objetos de la clase Reserva.
     * @param huesped objeto del tipo huesped heredando todos los atributos de su respectiva clase.
     * @param paquete objeto del tipo paquete heredando todos los atributos de su respectiva clase.
     * @param habitacion objeto del tipo habitacion heredando todos los atributos de su respectiva clase.
     * @param dias objeto del tipo int para guardar los dias que tomara la reserva del huesped.
     * @param piso Se obtendra segun la habitacion establecida.
     */
    Reserva(Huesped huesped, Paquete paquete, Habitacion habitacion, int dias){
        this.huesped=huesped;
        this.paquete=paquete;
        this.habitacion=habitacion;
        this.dias=dias;
        this.piso=habitacion.getPiso();
        
    }
    
    /**
     * Valida que el huesped tenga como maximo dos reservas.
     */
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
    
    /**
     * Calcula el precio total a pagar por el huesped al final de su estadia.
     * @param comprobador se utiliza para comprobar si el huesped se hospeda en alguno de los dos ultimos pisos o no.
     */
    public void calcularPreciototal(boolean comprobador){
        
        if(comprobador==false){
            this.precioTotal=(this.habitacion.getPrecioBase() + this.paquete.getPrecioExtra())*this.dias;
        }
        else{
            this.precioTotal = (this.habitacion.getPrecioBase() + this.paquete.getPrecioExtra() + (this.habitacion.getPrecioBase()*0.1))*this.dias;
        }
    }
   
    /**
     * Nos sirve para obtener una instancia del objeto Paquete para poder utilizarlo.
     * @return retorna una variable del tipo Paquete.
     */
    public Paquete getPaquete() {
        return paquete;
    }
    
    /**
     * Metodo set del objeto Paquete, que nos permite asignarle un valor inicial a este.
     * @param paquete se utiliza como parametro para asignarle un valor al objeto Paquete.
     */
    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }
    
    /**
     * Nos sirve para obtener una instancia del objeto Piso para poder utilizarlo.
     * @return retorna una variable del tipo Piso.
     */
    public Piso getPiso() {
        return piso;
    }
    
    /**
     * Metodo set del objeto Piso, que nos permite asignarle un valor inicial a este.
     * @param piso Se utiliza como variable para asignarle un valor al objeto Piso.
     */
    public void setPiso(Piso piso) {
        this.piso = piso;
    }
    
    /**
     * Nos sirve para obtener una instancia del objeto Habitacion para poder utilizarlo.
     * @return retorna una variable del tipo Habitacion.
     */
    public Habitacion getHabitacion() {
        return habitacion;
    }
    
    /**
     * Metodo set del objeto Habitacion, que nos permite asignarle un valor inicial a este.
     * @param habitacion Se utiliza como variable para asignarle un valor al objeto Habitacion.
     */
    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }
    
    /**
     * Nos sirve para obtener una instancia del objeto PrecioTotal para poder utilizarlo.
     * @return retorna una variable del tipo PrecioTotal.
     */
    public double getPrecioTotal() {
        return precioTotal;
    }
    
    /**
     * Metodo set del objeto PrecioTotal, que nos permite asignarle un valor inicial a este.
     * @param precioTotal Se utiliza como variable para asignarle un valor al objeto PrecioTotal.
     */
    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }
    
    /**
     * Nos sirve para obtener una instancia del objeto Huesped para poder utilizarlo.
     * @return retorna una variable del tipo Huesped.
     */
    public Huesped getHuesped() {
        return huesped;
    }
    
    /**
     * Metodo set del objeto Huesped, que nos permite asignarle un valor inicial a este.
     * @param huesped Se utiliza como variable para asignarle un valor al objeto Huesped.
     */
    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }
    
    /**
     * Nos sirve para obtener una instancia del objeto Dias para poder utilizarlo.
     * @return retorna una variable del tipo int.
     */
    public int getDias() {
        return dias;
    }
    
    /**
     * Metodo set del objeto Dias, que nos permite asignarle un valor inicial a este.
     * @param dias Se utiliza como variable para asignarle un valor al objeto Dias.
     */
    public void setDias(int dias) {
        this.dias = dias;
    }
    
    /**
     * Nos sirve para obtener una instancia del objeto TipoPaquete para poder utilizarlo.
     * @return retorna una variable del tipo String.
     */
    public String getTipoPaquete() {
        return TipoPaquete;
    }
    
    /**
     * Metodo set del objeto TipoPaquete, que nos permite asignarle un valor inicial a este.
     * @param TipoPaquete Se utiliza como variable para asignarle un valor al objeto TipoPaquete.
     */
    public void setTipoPaquete(String TipoPaquete) {
        this.TipoPaquete = TipoPaquete;
    }
    
    
}

