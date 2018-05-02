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
public class Paquete {
    private String nombre;
    private String summary;
    private double precioExtra;
    
    public Paquete(){
    }

    public Paquete(String nombre, String summary, double precioExtra) {
        this.nombre = nombre;
        this.summary = summary;
        this.precioExtra = precioExtra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public double getPrecioExtra() {
        return precioExtra;
    }

    public void setPrecioExtra(double precioExtra) {
        this.precioExtra = precioExtra;
    }
    
    
    
}
