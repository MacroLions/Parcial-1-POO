/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.rafinha;

/**
 *
 * @author ricky
 */
public class Habitacion {
    private int numCuarto;
    private boolean disponibilidad;
    private Piso piso;
    private double precioBase;
    
    public Habitacion(){
    }
    
    public Habitacion(int numCuarto, Piso piso){
        this.numCuarto= numCuarto;
        this.piso = piso;
    }

    public Habitacion(int numCuarto, boolean disponibilidad, Piso piso, double precioBase) {
        this.numCuarto = numCuarto;
        this.disponibilidad = disponibilidad;
        this.piso = piso;
        this.precioBase = precioBase;
    }

    public int getNumCuarto() {
        return numCuarto;
    }

    public void setNumCuarto(int numCuarto) {
        this.numCuarto = numCuarto;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Piso getPiso() {
        return piso;
    }

    public void setPiso(Piso piso) {
        this.piso = piso;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }
    
}
