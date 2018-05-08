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

        /*
        LOGIN PRINCIPAL DONDE SE PIDE AL ADMINISTRADOR DEL SISTEM ENGRESAR LAS 
        CREDENCIALES:
        USURARIO: USUARIO
        CONTRASENIA: CONTRASENIA
        
        */
        
        System.out.println("SISTEMA DE ADMINISTRACION DEL HOTEL 'VIÃ‘A RAFINHA'");
        System.out.println("Ingrese sus credenciales por favor");
        System.out.print("Usuario: ");
        String usuario = dato.nextLine().toUpperCase(); //requiere mayusculas
        System.out.print("ContraseÃ±a: ");
        String contra = dato.nextLine().toUpperCase(); //requiere mayusculas

        //Verifica que las credenciales ingresadas (USUARIO Y CONTRASENIA) sean validas para poder ingresar al siguiente menú
        while (usuario != "USUARIO" && contra != "CONTRASENIA") {
            System.out.println("Usuario o contraseÃ±a incorrectos, intentelo de nuevo");
            System.out.print("Usuario: ");
            usuario = dato.nextLine().toUpperCase(); //requiere mayusculas
            System.out.print("ContraseÃ±a: ");
            contra = dato.nextLine().toUpperCase(); //requiere mayusculas
            break;
        }

        System.out.println("Â¡Â¡Â¡Â¡Â¡Â¡Â¡BIENVENIDO ADMINISTRADOR DEL HOTEL 'VIÃ‘A RAFINHA'!!!!!!! :D ");
        

        //OBJETO ADMINISTRADOR que accede a todas las funciones del programa
        Administrador admin = new Administrador();

        //Objetos inicializados de los Paquetes que ofrece el hotel por defecto BASICO Y PREMIUM 
        Paquete Basico = new Paquete("Basico", "Cosas basicas", 10);
        Paquete Premium = new Paquete("Premium", "Cosas premium", 150);
        admin.paquetes.add(Premium);//paquete se agrega a la lista de paquetes ya que puede existir mas de uno
        admin.paquetes.add(Basico);//paquete se agrega a la lista de paquetes ya que puede existir mas de uno

        Piso A = new Piso('A');
        int a = 1;
        while (a <= 10) {
            Habitacion habitacion = new Habitacion(a, A);
            A.habitaciones.add(habitacion);
            a++;
        }
        Piso B = new Piso('B');
        int b = 1;
        while (b <= 10) {
            Habitacion habitacion = new Habitacion(b, B);
            B.habitaciones.add(habitacion);
            b++;
        }
        Piso C = new Piso('C');
        int c = 1;
        while (c <= 10) {
            Habitacion habitacion = new Habitacion(c, C);
            C.habitaciones.add(habitacion);
            c++;
        }
        Piso D = new Piso('D');
        int d = 1;
        while (d <= 10) {
            Habitacion habitacion = new Habitacion(d, D);
            D.habitaciones.add(habitacion);
            d++;
        }
        Piso E = new Piso('E');
        int e = 1;
        while (e <= 10) {
            Habitacion habitacion = new Habitacion(e, E);
            E.habitaciones.add(habitacion);
            e++;
        }
        Piso F = new Piso('F');
        int f = 1;
        while (f <= 10) {
            Habitacion habitacion = new Habitacion(f, F);
            F.habitaciones.add(habitacion);
            f++;
        }
        
        admin.MenuPrincipal();
    }

}
