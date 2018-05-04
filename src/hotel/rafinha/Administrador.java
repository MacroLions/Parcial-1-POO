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
      newReserva.calcularPreciototal(ComprobarPisoReserva(newReserva));
      //agrega reserva a su correspondiente Array
      reservas.add(newReserva);
      
      //imprime todo lo que hay en el array
      for ( int i = 0; i < reservas.size(); i++ )
          System.out.println(reservas.get(i));
   }
   
   public boolean ComprobarPisoReserva(Reserva reserva){
       Piso pisoRevisar=reserva.getPiso();
       int UltimoPisoID=this.pisos.size();
       int PenultimoPisoID=UltimoPisoID-1;
       if(pisoRevisar.getIdentificador()==this.pisos.get(UltimoPisoID).getIdentificador()){
           return true;
       }
       else if(pisoRevisar.getIdentificador()==this.pisos.get(PenultimoPisoID).getIdentificador()){
           return true;
       }
       else{
           return false;
       }
   }
   
   public void VerReserva(){
       System.out.println("Ingrese numero de reserva: ");
       
       for (int numReserva = 0; numReserva < reservas.size(); numReserva++)
           System.out.println("Reserva es: ");
       
   }
   
   public void BorrarPiso(char identificador){
       int contador=0;
       boolean pisoExiste = false;
       
       while(contador<=this.pisos.size()){
           for(Piso a: this.pisos){
                if(a.getIdentificador()==identificador){
                    pisoExiste = true;
                    this.pisos.remove(a);
                    System.out.println("Piso Eliminado");
                }
           }
       }if(pisoExiste==false){
           System.out.println("El piso no existe");
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
   
      public void AgregarHabitacion(char identificador){
       int contador = 0;
       boolean pisoExiste = false;
       
       while(contador <= this.pisos.size()){
           for(Piso a: this.pisos){
               if(a.getIdentificador() == identificador){
                   pisoExiste = true;
                   for(Habitacion b: a.getHabitaciones()){
                       if(a.habitaciones == null){
                           Habitacion newhab = new(Habitacion);
                           newhab.setNumCuarto(1);
                           newhab.setPiso(a);
                           a.habitaciones.add(contador, newhab);
                           break;
                       }else{
                           Habitacion newhab = new(Habitacion);
                           newhab.setNumCuarto();//No se que como ponerle para que tome el numero despues del ultimo.
                           newhab.setPiso(a);
                           a.habitaciones.add(contador, newhab);
                           break;
                       }
                   }
               }
               
           }if(pisoExiste == false){
               System.out.println("El piso no Existe");
           }
           
       }       
       
   }
   
   public void CambiarPrecioBaseSimple(int newPrecio){
       int ParImpar =1;
       for(Piso a: this.pisos){
           for(Habitacion b:a.getHabitaciones()){
               if(ParImpar==1){
                    b.setPrecioBase(newPrecio);
                    ParImpar=2;
               }
               else{
                   ParImpar=1;
               }
           }
       }
   }
   
   public void CambiarPrecioBaseDoble(int newPrecio){
       int ParImpar=1;
       for(Piso a: this.pisos){
           for(Habitacion b:a.getHabitaciones()){
               if(ParImpar==2){
                   b.setPrecioBase(newPrecio);
                   ParImpar=1;
               }
               else{
                   ParImpar=2;
               }
           }
       }
   }
       
   
   }
