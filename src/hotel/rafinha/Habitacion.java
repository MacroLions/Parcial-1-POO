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
    private String codigo;
    private int numCuarto;
    private boolean disponibilidad;
    //private piso piso;
    private double precioBase;
    
    public Habitacion(){
    }

    public Habitacion(String codigo, int numCuarto, boolean disponibilidad, /*piso piso, */double precioBase) {
        this.codigo = codigo;
        this.numCuarto = numCuarto;
        this.disponibilidad = disponibilidad;
        //this.piso = piso;
        this.precioBase = precioBase;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    /*public piso getPiso() {
        return piso;
    }

    public void setPiso(piso piso) {
        this.piso = piso;
    }*/

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }
    
    
}