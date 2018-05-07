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
    private ArrayList<Paquete> paquetes = new ArrayList();

    public Huesped CreacionHuesped() {
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingrese el nombre del usuario");
        String nombre = lector.nextLine();
        System.out.println("Ingrese numero de DUI");
        String numeroDui = lector.nextLine();
        System.out.println("Ingrese numero de tarjeta de credito");
        String numeroTarjetaCredito = lector.nextLine();

        Huesped newHuesped = new Huesped(nombre, numeroDui, numeroTarjetaCredito);

        //Se agrega a la lista de huespedes.
        //verifica que no tenga mas de 2 reservaciones
        this.huespedes.add(newHuesped);
        int cont = 0;
        for (int i = 0; i < huespedes.size(); i++) {
            if (cont == 0 || cont == 1) {
                if (huespedes.contains(newHuesped)) {
                    cont++;
                }
            } else {
                System.out.println("No es posible realizar reservaciÃƒÂ³n");
                System.out.println("Huesped alcanzÃƒÂ³ el mÃƒÂ¡ximo nÃƒÂºmero de reservas");
            }
        }
        //Este this podrÃƒÂ­a ir en el menÃƒÂº, pero lo dejarÃƒÂ© aquÃƒÂ­ para mientras
        //Return por si se usa luego???? Si no, se cambiaria el tipo de funcion a void.
        return newHuesped;

    }

    
    public Paquete EscogerPaquete(){
        Scanner input = new Scanner(System.in);
        System.out.print("Nombre del paquete a escoger: ");
        String NombrePaquete = input.nextLine();
        for(Paquete a:this.paquetes){
            if(a.getNombre()== NombrePaquete){
                return a;
            }
            else{
                System.out.println("El paquete no existe.");
                return null;
            }
        }
        return null;
        
    }

    public Habitacion EscogerHabitacion() {
        Scanner input = new Scanner(System.in);
        System.out.print("Identificador de piso: ");
        char pisoHabitacion = input.nextLine().charAt(0);
        System.out.print("Ingrese el numero de la habitacion: ");
        int numHabitacion = input.nextInt();
        for(Piso a:this.pisos){
            if(a.getIdentificador()==pisoHabitacion){
                for(Habitacion b: a.getHabitaciones()){
                    if(b.getNumCuarto()==numHabitacion && b.isDisponibilidad()){
                        return b;
                    }
                    else{
                        System.out.println("La habitacion no existe o no esta disponible.");
                        return null;
                    }
                }
            }
        }
        return null;
    }

    public Reserva CreacionReserva(Paquete paquete, Habitacion habitacion) {
        System.out.println("entramos a funcion crear reserva");///HASTA AQUI SI SE EJECUTA
        Huesped newHuesped = CreacionHuesped(); // Modificar SOUTS DE CREACION HUESPED
        //AquÃƒÂ­ se creo el huesped con la funcion anterior.
        System.out.println("entramos a funcion crear reserva");
        Scanner lector = new Scanner(System.in);
        int dias = lector.nextInt();
        //Dias a reservar, es facil porque solo es un int.   

        //Verifica que no tenga 7 o mas dias reservados
        if (dias > 7) {
            System.out.println("MÃƒÂ¡ximo de dÃƒÂ­as reservados. No es posible reservar mÃƒÂ¡s de 7 dÃƒÂ­as");
        }
        //String Escogio = paquete;

        //Ahora el problema es con paquete y habitaciÃƒÂ³n. Que no estoy segura si serÃƒÂ­a una funcion a lo "Escoger paquete" y que se revise la lista. al igual que habitacion.
        Reserva newReserva = new Reserva(newHuesped, paquete, habitacion, dias);
        newReserva.calcularPreciototal(ComprobarPisoReserva(newReserva));
        //agrega reserva a su correspondiente Array
        reservas.add(newReserva);

        return newReserva;
    }

    public boolean ComprobarPisoReserva(Reserva reserva) {
        Piso pisoRevisar = reserva.getPiso();
        int UltimoPisoID = this.pisos.size();
        int PenultimoPisoID = UltimoPisoID - 1;
        if (pisoRevisar.getIdentificador() == this.pisos.get(UltimoPisoID).getIdentificador()) {
            return true;
        } else if (pisoRevisar.getIdentificador() == this.pisos.get(PenultimoPisoID).getIdentificador()) {
            return true;
        } else {
            return false;
        }
    }
    
    //Revisar luego. O hacer uno para ver TODAS LAS RESERVAS.
    public void VerReserva() {
        //imprime todo lo que hay en el array      

        for (int i = 0; i < this.reservas.size(); i++) {
            System.out.println("Reserva: ");
            System.out.println(this.reservas.get(i));
        }
    }

    public void BorrarPiso(char identificador) {//ya
        int contador = 0;
        boolean pisoExiste = false;

        while (contador <= this.pisos.size()) {
            for (Piso a : this.pisos) {
                if (a.getIdentificador() == identificador) {
                    pisoExiste = true;
                    this.pisos.remove(a);
                    System.out.println("Piso Eliminado");
                }
            }
        }
        if (pisoExiste == false) {
            System.out.println("El piso no existe");
        }
    }

    public void AgregarPiso(char identificador) {//ya

        int contador = 0;
        boolean pisoExiste = false;

        while (contador <= this.pisos.size()) {
            for (Piso a : this.pisos) {
                if (a.getIdentificador() == identificador) {
                    System.out.println("El piso ya existe.");
                    pisoExiste = true;
                }
            }
        }
        if (pisoExiste == false) {
            Piso pisoNuevo = new Piso(identificador);
        }
    }

    public void AgregarHabitacion(char identificador) { //ya
        int contador = 0;
        boolean pisoExiste = false;

        while (contador <= this.pisos.size()) {
            for (Piso a : this.pisos) {
                if (a.getIdentificador() == identificador) {
                    pisoExiste = true;
                    for (Habitacion b : a.getHabitaciones()) {
                        if (a.getHabitaciones() == null) {
                            Habitacion newhab = new Habitacion();
                            newhab.setNumCuarto(1);
                            newhab.setPiso(a);
                            a.getHabitaciones().add(newhab);
                            break;
                        } else {
                            Habitacion newhab = new Habitacion();

                            //AquÃƒÂ­ tomara el numero del tamaÃƒÂ±o de la lista.
                            int numb = a.getHabitaciones().size();
                            newhab.setNumCuarto(numb + 1);
                            newhab.setPiso(a);
                            a.getHabitaciones().add(newhab);
                            break;
                        }
                    }
                }

            }
            if (pisoExiste == false) {
                System.out.println("El piso no Existe");
            }

        }

    }

    public void BorrarHabitacion(char identificador, int numHabitacion) { //ya
        int contador = 0;
        boolean pisoExiste = false;
        boolean habExiste = false;

        while (contador <= this.pisos.size()) {
            for (Piso a : this.pisos) {
                if (a.getIdentificador() == identificador) {
                    pisoExiste = true;
                    for (Habitacion b : a.getHabitaciones()) {
                        if (b.getNumCuarto() == numHabitacion) {
                            habExiste = true;
                            a.getHabitaciones().remove(b);
                            break;
                        }
                    }
                    if (habExiste == false) {
                        System.out.println("La habitacion no existe.");
                        break;
                    }
                }
            }
            if (pisoExiste == false) {
                System.out.println("El piso no existe.");
                break;
            } else if (pisoExiste == true && habExiste == false) {
                System.out.println("La habitacion no existe");
                break;
            }
        }
    }

    public void CambiarPrecioBaseSimple(int newPrecio) { //ya
        int ParImpar = 1;
        for (Piso a : this.pisos) {
            for (Habitacion b : a.getHabitaciones()) {
                if (ParImpar == 1) {
                    b.setPrecioBase(newPrecio);
                    ParImpar = 2;
                } else {
                    ParImpar = 1;
                }
            }
        }
    }

    public void CambiarPrecioBaseDoble(int newPrecio) { //ya
        int ParImpar = 1;
        for (Piso a : this.pisos) {
            for (Habitacion b : a.getHabitaciones()) {
                if (ParImpar == 2) {
                    b.setPrecioBase(newPrecio);
                    ParImpar = 1;
                } else {
                    ParImpar = 2;
                }
            }
        }
    }
//Solo existen dos paquetes. Se deberia entrar a la lista de paquetes.
    public void ModPacks() {
        
        System.out.println("Elija el paquete a modificar:");
        int contador = 1;
        
        for(Paquete a: this.paquetes){
            System.out.println("Paquete #"+contador+": Nombre: "+a.getNombre()+" Descripcion: "+a.getSummary()+" Precio: "+a.getPrecioExtra());
            contador++;
        }

        Scanner scan = new Scanner(System.in);
        int opc = scan.nextInt();
        
        Paquete packEditar = this.paquetes.get(opc);
        
        System.out.print("Ingrese el nombre del paquete: ");
        String nombre = scan.nextLine();
        packEditar.setNombre(nombre);
        System.out.println("");
        
        System.out.print("Descripcion del paquete:");
        String summary = scan.nextLine();
        packEditar.setSummary(summary);
        System.out.println("");
        
        System.out.println("Precio del paquete: ");
        double precio = scan.nextDouble();
        packEditar.setPrecioExtra(precio);
        
        //Aqui el paquete remplazara al anterior.
        this.paquetes.set(opc, packEditar);

    }

    public void HabilitarHabitacion() { //ya
        int habitacion = 0;
        char piso;

        Scanner input = new Scanner(System.in);
        for (Piso a : this.pisos) {
            for (Habitacion b : a.getHabitaciones()) {
                System.out.println("Numero de habitacion: " + b.getNumCuarto() + " Piso de habitacion: " + b.getPiso() + " Disponibilidad: " + b.isDisponibilidad());
            }
        }
        System.out.print("Piso donde se encuentra habitaciÃƒÂ³n: ");
        piso = input.next().charAt(0);
        System.out.print("Numero de habitacion: ");
        habitacion = input.nextInt();

        for (Piso a : this.pisos) {
            if (a.getIdentificador() == piso) {
                for (Habitacion b : a.getHabitaciones()) {
                    if (b.getNumCuarto() == habitacion) {
                        b.setDisponibilidad(true);
                    }
                }
            }

        }

    }

    public void DeshabilitarHabitacion() {//ya
        int habitacion = 0;
        char piso;

        Scanner input = new Scanner(System.in);
        for (Piso a : this.pisos) {
            for (Habitacion b : a.getHabitaciones()) {
                System.out.println("Numero de habitacion: " + b.getNumCuarto() + " Piso de habitacion: " + b.getPiso() + " Disponibilidad: " + b.isDisponibilidad());
            }
        }
        System.out.print("Piso donde se encuentra habitaciÃƒÂ³n: ");
        piso = input.next().charAt(0);
        System.out.print("Numero de habitacion: ");
        habitacion = input.nextInt();

        for (Piso a : this.pisos) {
            if (a.getIdentificador() == piso) {
                for (Habitacion b : a.getHabitaciones()) {
                    if (b.getNumCuarto() == habitacion) {
                        b.setDisponibilidad(false);
                    }
                }
            }

        }

    }

    public void HabilitarPiso() {//ya
        Scanner input = new Scanner(System.in);
        System.out.println("Pisos existentes: ");
        for (Piso a : this.pisos) {
            System.out.println("Piso: " + a.getIdentificador());
        }
        System.out.print("Piso a bloquear: ");
        char piso = input.next().charAt(0);
        for (Piso a : this.pisos) {
            if (a.getIdentificador() == piso) {
                for (Habitacion b : a.getHabitaciones()) {
                    b.setDisponibilidad(true);
                }
            }
        }

    }

    public void DeshabilitarPiso() { //ya
        Scanner input = new Scanner(System.in);
        System.out.println("Pisos existentes: ");
        for (Piso a : this.pisos) {
            System.out.println("Piso: " + a.getIdentificador());
        }
        System.out.print("Piso a bloquear: ");
        char piso = input.next().charAt(0);
        for (Piso a : this.pisos) {
            if (a.getIdentificador() == piso) {
                for (Habitacion b : a.getHabitaciones()) {
                    b.setDisponibilidad(false);
                }
            }
        }
    }

    public void ModificarReserva() {
        int contador =1;
        Scanner input = new Scanner(System.in);
        for(Reserva a:this.reservas){
            String Nombre = a.getHuesped().getNombre();
            char pisoHabitacion= a.getPiso().getIdentificador();
            int numeroHabitacion = a.getHabitacion().getNumCuarto();
            String paqueteHabitacion=a.getPaquete().getNombre();
            int diasPaquete = a.getDias();
            System.out.println("Reserva #"+contador+": Nombre: "+Nombre+" Habitacion: "+pisoHabitacion+numeroHabitacion+" Paquete: "+paqueteHabitacion+" Dias reservados: "+diasPaquete);
        }
        
        System.out.print("Reserva a editar: ");
        int NumeroReservaAModificar = input.nextInt();
        Reserva ReservaAModificar = this.reservas.get(NumeroReservaAModificar-1);
                
        System.out.println("1. Modificar Huesped");
        System.out.println("2. Modificar Habitacion");
        System.out.println("3. Modificar Paquete");
        System.out.println("4. Modificar Dias reservados");
        System.out.print("Ingrese el numero de opcion que desea modificar: ");
        int opcion = input.nextInt();
        
        switch(opcion){
            case 1:
                System.out.print("Nuevo propietario de la reserva: ");
                String NuevoNombre = input.nextLine();
                
                for(Huesped a:this.huespedes){
                    if(a.getNombre()==NuevoNombre){
                        ReservaAModificar.setHuesped(a);
                        this.reservas.set(NumeroReservaAModificar, ReservaAModificar);
                        break;
                    }
                    else{
                        System.out.println("El huesped no existe.");
                        break;
                    }
                }
            case 2:
                System.out.print("Piso donde se encuenttra la nueva habitacion: ");
                char piso = input.nextLine().charAt(0);
                System.out.print("Numero de la nueva habitacion: ");
                int NuevoNumeroDeHabitacion= input.nextInt();
                
                for(Piso a:this.pisos){
                    if(a.getIdentificador()==piso){
                        for(Habitacion b:a.getHabitaciones()){
                            if(b.getNumCuarto()==NuevoNumeroDeHabitacion && b.isDisponibilidad()){
                                ReservaAModificar.setHabitacion(b);
                                this.reservas.set(NumeroReservaAModificar, ReservaAModificar);
                                break;
                            }
                            else{
                                System.out.println("La habitacion no esxiste o no se encuentra disponible");
                                break;
                            }
                        }
                    }
                }
            case 3:
                System.out.print("Nuevo paquete para la reserva: ");
                String NuevoNombrePaquete = input.nextLine();
                
                for(Paquete a:this.paquetes){
                    if(a.getNombre()==NuevoNombrePaquete){
                        ReservaAModificar.setPaquete(a);
                        this.reservas.set(NumeroReservaAModificar, ReservaAModificar);
                        break;
                    }
                    else{
                        System.out.println("El paquete no existe.");
                        break;
                    }
                }
            case 4:
                System.out.print("Nueva cantidad de dias: ");
                int NuevosDias= input.nextInt();
                if(NuevosDias <=7){
                    ReservaAModificar.setDias(NuevosDias);
                    this.reservas.set(NumeroReservaAModificar, ReservaAModificar);
                    break;
                }
                else{
                    System.out.println("La cantidad de dias no es valida");
                    break;
                }
        }

    }

    public void EliminarReserva() {
        int contador = 0;
        Scanner input = new Scanner(System.in);
        for (Reserva a : this.reservas) {
            System.out.println("Reserva #" + (contador + 1) + " Huesped:" + a.getHuesped() + " Paquete:" + a.getPaquete().getNombre() + " HabitaciÃƒÂ³n" + a.getPiso().getIdentificador() + a.getHabitacion().getNumCuarto() + " Cantidad de dias: " + a.getDias());
        }
        System.out.print("NÃƒÂºmero de reserva a eliminar: ");
        int reserva = input.nextInt();
        this.reservas.remove(reserva);

    }

    public void MenuConfiguracion() {
        Scanner lector = new Scanner(System.in);

        System.out.println("** MENU CONFIGURACION **");
        System.out.println("1. Eliminar reservacion ");
        System.out.println("2. Ver reservacion ");
        System.out.println("3. Ver reservaciones ");
        System.out.println("4. Agregar Piso ");
        System.out.println("5. Eliminar Piso ");
        System.out.println("6.Borrar Habitacion");
        System.out.println("7. Habilitar Habitacion");
        System.out.println("8. Desabilitar Habitacion");
        System.out.println("9.Habilitar piso");
        System.out.println("10.Deshabilitar piso");
        System.out.println("11.Cambiar Precio Base Simple");
        System.out.println("12.Cambiar Precio Base Doble");
        System.out.println("13.Salir");

        Scanner input = new Scanner(System.in);

        int opcion;
        opcion = lector.nextInt();
        switch (opcion) {
            case 1:
                EliminarReserva();
                break;
            case 2:
                ModificarReserva();
                break;
            case 3:
                //VER RESERVA
                break;
            case 4:
                System.out.println("Cual es el identificador del piso que desea agregar: ");
                char piso = input.next().charAt(0);
                AgregarPiso(piso);
                break;
            case 5:
                System.out.println("Ingrese el identificador del piso que desea eliminar: ");
                char piso1 = input.next().charAt(0);
                BorrarPiso(piso1);
                break;
            case 6:
                System.out.println("Ingrese el identificador de la habitacion que desea borrar");
                char habitacion = input.next().charAt(0);
                System.out.println("Ingrese el numero del cuarto que desea borrar");
                int num = lector.nextInt();
                BorrarHabitacion(habitacion, num);
                break;
            case 7:
                HabilitarHabitacion();
                break;
            case 8:
                DeshabilitarHabitacion();
                break;
            case 9:
                HabilitarPiso();
                break;
            case 10:
                DeshabilitarPiso();
                break;
            case 11:
                int newPrecio;
                newPrecio = lector.nextInt();
                CambiarPrecioBaseSimple(newPrecio);
                break;
            case 12:
                int newPrecio1;
                newPrecio1 = lector.nextInt();
                CambiarPrecioBaseDoble(newPrecio1);
                break;
            case 13:
                break;
        }
    }

    public void MenuReserva() {
        System.out.println("** MENU RESERVA **");
        System.out.println("1. Crear Reservacion ");
        System.out.println("2. Ver reservaciones");

        Scanner lector = new Scanner(System.in);
        int eleccion;
        eleccion = lector.nextInt();
        switch (eleccion) {
            case 1:
                Paquete paquete = EscogerPaquete();
                Habitacion habitacion = EscogerHabitacion();
                CreacionReserva(paquete, habitacion);
                break;
            case 2:
                VerReserva();
                break;
        }

    }

    public void MenuPrincipal() {
        System.out.println("** MENU PRINCIPAL **");

        System.out.println("** 1. MENU RESERVACION || 2. MENU CONFIGURACION ** ");

        Scanner lector = new Scanner(System.in);

        int opcion = 0;
        opcion = lector.nextInt();
        switch (opcion) {
            case 1:
                MenuReserva();
                break;
            case 2:
                MenuConfiguracion();
                break;

        }
    }
}
