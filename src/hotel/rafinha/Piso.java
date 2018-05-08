/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.rafinha;

import java.util.ArrayList;

/**
 *
 * @author Maishi
 */

/*
La clase piso contiene las variables necesarias para poder contruir, habilitar y desabilitar los mismos
*/
public class Piso {
    private char identificador; //Es único
    private boolean disponibilidad; //Determina si el piso puede ser utilizado o no
    public ArrayList<Habitacion> habitaciones = new ArrayList(); //Lista de todas las habitaciones que hay en deteminado piso
    
    //Constructor personalizado
    public Piso(char identificador){
        this.identificador=identificador;
        this.disponibilidad=true;
    }
/*
    SETTERS Y GETTERS DE LA CLASE PISO
    */
    //get por defecto
    public char getIdentificador() {
        return identificador;
    }
 
    //Set personzalido
    public void setIdentificador(char identificador) {
        this.identificador = identificador;
    }
    //get por defecto
    public boolean isDisponibilidad() {
        return disponibilidad;
    }
    //Set personzalido
    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    //get por defecto
    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }
    //Set personzalido
    public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }  
    
    
}
