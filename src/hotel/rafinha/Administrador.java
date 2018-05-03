/*
 * To change this lic
ense hage hotel.rafinha;
import java.util.ArrayList;
import eader, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.rafinha;
import java.util.ArrayList;
import java.util.Scanner;
/*
 *
 * @author Diana
 */
public class Administrador {
   private ArrayList<Piso> pisos = new ArrayList();     
   private ArrayList<Reserva> reservas = new ArrayList(); 
   private ArrayList<Huesped> huespedes = new ArrayList();     
   
   //MENU
   public void menuPrincipal(){
       System.out.println("** MENU PRINCIPAL **");
       int opcion = 0;
       switch(opcion){
           case 1:
               System.out.println("** MENU RESERVACION **");
               System.out.println("1. Agregar Reservacion ");
               System.out.println("2. Eliminar reservacion ");
               System.out.println("3. Ver reservacion ");
               System.out.println("4. Modificar reservacion");
               System.out.println("5. Verificar Reserva");
               break;
           case 2:
               System.out.println("** ADMINISTRADOR **");
               System.out.println("1. Agregar Piso ");
               System.out.println("2. Eliminar Piso ");
               System.out.println("3. Agregar huesped");

               break;
}    

   }
   
   
   public void Creacionhuesped(){
       Scanner lector = new Scanner(System.in);
       String nombre = lector.nextLine();
       String numeroDui = lector.nextLine();
       String numeroTarjetaCredito = lector.nextLine();
       
       Huesped newHuesped = new Huesped(nombre,numeroDui,numeroTarjetaCredito);
        
   }
   
   public void CreacionReserva(Huesped huesped, Paquete paquete, Habitacion habitacion, int dias){
    
   }
   
}