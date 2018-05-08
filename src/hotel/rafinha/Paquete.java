/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.rafinha;

/**
 *Clase denominada Paquete que contiene sus atributos, constructores y metodos set y get
 * @author ricky
 */
public class Paquete {
    //Atributos relacionados a paquete declarados privados 
    private String nombre;
    private String summary;
    private double precioExtra;

    /**
     * Constructor vacio de la clase para inicializar el objeto con valores por default
     */
    public Paquete() {
    }

    /**
     * Constructor de la clase para inicializar el objeto con valores predeterminados
     * @param nombrePaquete nombre que tiene asignado el paquete a ofrecer
     * @param summary descripcion de los servicios que incluye el paquete
     * @param precioExtra costo adicional por dia que tiene el paquete
     */
    public Paquete(String nombrePaquete, String summary, double precioExtra) {
        this.nombre = nombrePaquete;
        this.summary = summary;
        this.precioExtra = precioExtra;
    }

    /**
     * Metodo get para obtener el nombre del paquete elegido
     * @return el dato obtenido para la variable nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo set para acceder al atributo nombre del paquete elegido
     * @param nombre nombre que tiene el paquete escogido
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo get para obtener la descripcion del paquete elegido
     * @return el dato obtenido para la variable summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     * Metodo set para acceder al atributo summary del paquete elegido
     * @param summary descripcion de lo que incluye el paquete escogido
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * Metodo get para obtener el precio adicional del paquete elegido
     * @return el dato obtenido para la variable precioExtra
     */
    public double getPrecioExtra() {
        return precioExtra;
    }

    /**
     * Metodo set para acceder al atributo precioExtra del paquete elegido
     * @param precioExtra precio adicional diario propio de cada paquete
     */
    public void setPrecioExtra(double precioExtra) {
        this.precioExtra = precioExtra;
    }

}
