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
   
   
   public Huesped CreacionHuesped(){
       Scanner lector = new Scanner(System.in);
       String nombre = lector.nextLine();
       String numeroDui = lector.nextLine();
       String numeroTarjetaCredito = lector.nextLine();
       
       Huesped newHuesped = new Huesped(nombre,numeroDui,numeroTarjetaCredito);
       
       //Se agrega a la lista de huespedes.
       //this.huespedes.add(newHuesped);
       //Este this podría ir en el menú, pero lo dejaré aquí para mientras.
       
       //Return por si se usa luego???? Si no, se cambiaria el tipo de funcion a void.
       return newHuesped;
       
       
   }
   
   public void CreacionReserva(Paquete paquete, Habitacion habitacion){
      Huesped newHuesped =CreacionHuesped();
      //Aquí se creo el huesped con la funcion anterior.
      
      Scanner lector = new Scanner(System.in);
      int dias = lector.nextInt();
      //Dias a reservar, es facil porque solo es un int.
      
      //Ahora el problema es con paquete y habitación. Que no estoy segura si sería una funcion a lo "Escoger paquete" y que se revise la lista. al igual que habitacion.
      Reserva newReserva = new Reserva(newHuesped,paquete,habitacion,dias);
      
   }
   
   public void BorrarPiso(Piso piso){
       //Si quieren hagan este en base al de agregar piso >:3c
       if(this.pisos.contains(piso)){
           int borrador = this.pisos.indexOf(piso);
           this.pisos.remove(borrador);
       }
       else{
           System.out.println("El piso no existe.");
       }
       
   }
   
   public void AgregarPiso(char identificador){
       
       int contador=0;
       boolean pisoExiste=false;
       
       while(contador<=this.pisos.size()){
           for(Piso a: this.pisos){
            if(a.getIdentificador()==identificador){
               System.out.println("El piso ya existe.");
               pisoExiste=true;
            }
           }
       }
       if(pisoExiste==false){
           Piso pisoNuevo =new Piso(identificador);
       }
   }
       
   
   }
