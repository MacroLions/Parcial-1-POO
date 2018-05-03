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
public class Piso {
    private char identificador;
    private boolean disponibilidad;
    private ArrayList<Habitacion> habitaciones = new ArrayList();

    public char getIdentificador() {
        return identificador;
    }

    public void setIdentificador(char identificador) {
        this.identificador = identificador;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }
    
    public void agregarHabitaciones(Habitacion habitacion){
        this.habitaciones.add(habitacion);
    }
    
    
    
    
}
