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
public class HotelRafinha {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner dato = new Scanner(System.in);
        System.out.println("SISTEMA DE ADMINISTRACION DEL HOTEL 'VIÑA RAFINHA'");
        System.out.println("Ingrese sus credenciales por favor");
        System.out.print("Usuario: ");
        String usuario = dato.nextLine().toUpperCase();
        System.out.print("Contraseña: ");
        String contra = dato.nextLine().toUpperCase();

        while (usuario != "USUARIO" && contra != "CONTRASENIA") {
            System.out.println("Usuario o contraseña incorrectos, intentelo de nuevo");
            System.out.print("Usuario: ");
            usuario = dato.nextLine().toUpperCase();
            System.out.print("Contraseña: ");
            contra = dato.nextLine().toUpperCase();
            break;
        }

        System.out.println("¡¡¡¡¡¡¡BIENVENIDO ADMINISTRADOR DEL HOTEL 'VIÑA RAFINHA'!!!!!!! :D ");
        //Aqui iria el menu y los submenus.... ¡Es tu momento de brillar mango Dianita! ¡Make it shineee! Ref. Victorius cancion inicial

        //MENU
        System.out.println("** MENU PRINCIPAL **");
        
        System.out.println("** 1. MENU RESERVACION || 2. MENU ADMINISTRACION ** ");
        
        Scanner lector = new Scanner(System.in);
        int opcion = 0;
        opcion = lector.nextInt();
        
        //aun falta que se agregen los metodos dentro de cada uno
        switch (opcion) {
            case 1:
                System.out.println("** MENU RESERVACION **");
                System.out.println("1. Agregar Reservacion ");
                System.out.println("2. Eliminar reservacion ");
                System.out.println("3. Ver reservacion ");
                System.out.println("4. Modificar reservacion");
                System.out.println("5. Verificar Reserva");
                break;
            case 2:
                System.out.println("** MENU ADMINISTRADOR **");
                System.out.println("1. Agregar Piso ");
                System.out.println("2. Eliminar Piso ");
                System.out.println("3. Agregar huesped");

                break;
        }

    }
    
}
