/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.rafinha;

/**
 *Clase utilizada para crear objetos del tipo habitacion, esta contiene sus atributos, constructores, setters y getters.
 * @author ricky
 */
public class Habitacion {
    private int numCuarto;
    private boolean disponibilidad;
    private Piso piso;
    private double precioBase;
    
    /**
     * Constructor Vacio para incializar objetos de la clase Habitacion.
     */
    
    public Habitacion(){
        
    }
    
    /**
     * Constructor en el que se inicializan los objetos de la clase habitacion.
     * @param numCuarto
     * @param disponibilidad
     * @param piso
     * @param precioBase 
     */
    public Habitacion(int numCuarto, boolean disponibilidad, Piso piso, double precioBase) {
        this.numCuarto = numCuarto;
        this.disponibilidad = disponibilidad;
        this.piso = piso;
        this.precioBase = precioBase;
    }
    
    
    /**
     * Nos sirve para obtener una instancia del objeto NumCuarto para poder utilizarlo.
     * @return retorna una variable del tipo int.
     */
    public int getNumCuarto() {
        return numCuarto;
    }
    
    /**
     * Metodo set del objeto NumCuarto, que nos permite asignarle un valor inicial a este.
     * @param numCuarto Se utiliza como variable para asignarle un valor al objeto NumCuarto.
     */
    public void setNumCuarto(int numCuarto) {
        this.numCuarto = numCuarto;
    }
    
    /**
     * Nos sirve para verificar si el objeto que se utilize, esta dsiponible o no.
     * @return retorna una variable del tipo boolean.
     */
    public boolean isDisponibilidad() {
        return disponibilidad;
    }
    
    /**
     * Metodo set del objeto Disponibilidad, que nos permite asignarle un valor inicial a este.
     * @param disponibilidad Se utiliza como variable para asignarle un valor al objeto Disponibilidad.
     */
    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
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
     * Nos sirve para obtener una instancia del objeto PrecioBase para poder utilizarlo.
     * @return retorna una variable del tipo PrecioBase.
     */
    public double getPrecioBase() {
        return precioBase;
    }
    
    /**
     * Metodo set del objeto PrecioBase, que nos permite asignarle un valor inicial a este.
     * @param precioBase Se utiliza como variable para asignarle un valor al objeto PrecioBase.
     */
    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }
    
}
