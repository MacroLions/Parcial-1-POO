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

    public Paquete EscogerPaquete1() {
        Scanner ScannerPaquete = new Scanner(System.in);
        System.out.println("Ingrese el nombre del paquete que desea: ");
        System.out.println("1. PAQUETE BASICO || 2. PAQUETE PREMIUM");

        int SeleccionPaquete = ScannerPaquete.nextInt();

        switch (SeleccionPaquete) {
            case 1:
                System.out.println("** PAQUETE BASICO **");
                System.out.println("DESCRIPCON: \n" + "- Acceso a la piscina\n" + "- Internet Iliminatado");
                System.out.println("Precio Base: $100.00");
                break;
            case 2:
                System.out.println("** PAQUETE PREMIUM **");
                System.out.println("DESCRIPCION: \n" + "- Acceso Buffet de desayuno\n" + "- Acceso Iliminatado a la piscina\n"
                        + "- Servicio a la habitacion\n" + "- Acceso ilimitado al minibar\n" + "- Internet ilimitado");
                System.out.println("Precio Base: $200.00");
                break;
        }

        if (SeleccionPaquete == 1) {
            String NombrePaquete = "Basico";
            this.EscogerPaquete().setNombre(NombrePaquete);
            String descripcion = "";
            this.EscogerPaquete().setSummary(descripcion);
            double PrecioBase = 100.00;
            this.EscogerPaquete().setPrecioExtra(PrecioBase);
        }else if(SeleccionPaquete == 2){
            String NombrePaquete = "PREMIUM";
            this.EscogerPaquete().setNombre(NombrePaquete);
            String descripcion = "";
            this.EscogerPaquete().setSummary(descripcion);
            double PrecioBase = 200.00;
            this.EscogerPaquete().setPrecioExtra(PrecioBase);
        }

        String NombrePaquete = this.EscogerPaquete().getNombre();
        String descripcion = this.EscogerPaquete().getSummary();
        double PrecioBase = this.EscogerPaquete().getPrecioExtra();
        
        Paquete PaqueteEscogido = new Paquete(NombrePaquete, descripcion, PrecioBase);
        return PaqueteEscogido;//el que retornaria ala funcion crearreserva
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
            }
        }
        
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
                    }
                }
            }
        }

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
        System.out.println("1)Paquete Basico");
        System.out.println("2)Paquete Premium");

        Scanner scan = new Scanner(System.in);
        int opc = scan.nextInt();

        switch (opc) {//poruqe no agarra las nuevas variables?
            case 1://Also probablemente no este bien hecho lo que va dentro de los cases.
                Paquete packBasico = new Paquete();
                System.out.print("Ingrese el nombre del paquete: ");
                String nombre = scan.nextLine();
                packBasico.setNombre(nombre);
                System.out.println("\n");
                System.out.println("Descripcion del paquete:");
                String summary = scan.nextLine();
                packBasico.setSummary(summary);
                System.out.println("Precio del paquete: ");
                double precio = scan.nextDouble();
                packBasico.setPrecioExtra(precio);
                this.paquetes.add(packBasico);
                break;
            case 2:
                Paquete packPremium = new Paquete();
                System.out.print("Ingrese el nombre del paquete: ");
                String name = scan.nextLine();
                packPremium.setNombre(name);
                System.out.println("\n");
                System.out.println("Descripcion del paquete:");
                String description = scan.nextLine();
                packPremium.setSummary(description);
                System.out.println("Precio del paquete: ");
                double price = scan.nextDouble();
                packPremium.setPrecioExtra(price);
                this.paquetes.add(packPremium);
                break;
            default:
                System.out.println("Opcion no valida.");
        }
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
        for(Reserva a:this.reservas){
            String Nombre = a.getHuesped().getNombre();
            char piso= a.getPiso().getIdentificador();
            
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
                //VerReserva();
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
