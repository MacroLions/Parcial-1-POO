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
        USUARIO: USUARIO
        PASSWORD: PASSWORD
        
        */
        
        String TrueUsuario="USUARIO";
        String TruePassword="PASSWORD";
        
        System.out.println("SISTEMA DE ADMINISTRACION DEL HOTEL RAFINHA'");
        System.out.println("Ingrese sus credenciales por favor");
        System.out.print("Usuario: ");
        String usuario = dato.nextLine().toUpperCase(); //requiere mayusculas
        System.out.print("Password: ");
        String contra = dato.nextLine().toUpperCase(); //requiere mayusculas

        //Verifica que las credenciales ingresadas (USUARIO Y CONTRASENIA) sean validas para poder ingresar al siguiente menú
        while (contra.equals(TruePassword)== false || usuario.equals(TrueUsuario)== false) {
            System.out.println("");
            System.out.println("Usuario o password incorrectos, intentelo de nuevo");
            System.out.print("Usuario: ");
            usuario = dato.nextLine().toUpperCase(); //requiere mayusculas
            System.out.print("Password: ");
            contra = dato.nextLine().toUpperCase(); //requiere mayusculas
        }
        
        System.out.println("");
        System.out.println("¡BIENVENIDO ADMINISTRADOR DEL HOTEL 'RAFINHA'! :D ");
        

        //OBJETO ADMINISTRADOR que accede a todas las funciones del programa
        Administrador admin = new Administrador();

        //Objetos inicializados de los Paquetes que ofrece el hotel por defecto BASICO Y PREMIUM 
        Paquete Basico = new Paquete("BASICO", "Cosas basicas", 10);
        Paquete Premium = new Paquete("PREMIUM", "Cosas premium", 150);
        admin.paquetes.add(Premium);//paquete se agrega a la lista de paquetes ya que puede existir mas de uno
        admin.paquetes.add(Basico);//paquete se agrega a la lista de paquetes ya que puede existir mas de uno

        Piso A = new Piso('A');
        int a = 1;
        while (a <= 10) {
            Habitacion habitacion = new Habitacion(a,true, A,200.0);
            A.habitaciones.add(habitacion);
            a++;
        }
        admin.pisos.add(A);
        Piso B = new Piso('B');
        int b = 1;
        while (b <= 10) {
            Habitacion habitacion = new Habitacion(b,true, B,200.0);
            B.habitaciones.add(habitacion);
            b++;
        }
        admin.pisos.add(B);
        Piso C = new Piso('C');
        int c = 1;
        while (c <= 10) {
            Habitacion habitacion = new Habitacion(c,true, C,200);
            C.habitaciones.add(habitacion);
            c++;
        }
        admin.pisos.add(C);
        Piso D = new Piso('D');
        int d = 1;
        while (d <= 10) {
            Habitacion habitacion = new Habitacion(d,true, D,200);
            D.habitaciones.add(habitacion);
            d++;
        }
        admin.pisos.add(D);
        Piso E = new Piso('E');
        int e = 1;
        while (e <= 10) {
            Habitacion habitacion = new Habitacion(e,true, E,200);
            E.habitaciones.add(habitacion);
            e++;
        }
        admin.pisos.add(E);
        Piso F = new Piso('F');
        int f = 1;
        while (f <= 10) {
            Habitacion habitacion = new Habitacion(f,true, F,200);
            F.habitaciones.add(habitacion);
            f++;
        }
        admin.pisos.add(F);
        
        boolean menu = true;
        
        while(menu==true){
            admin.MenuPrincipal();    
        }
        
    }

}
