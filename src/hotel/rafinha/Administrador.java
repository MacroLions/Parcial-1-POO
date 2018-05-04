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
        String nombre = lector.nextLine();
        String numeroDui = lector.nextLine();
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
                System.out.println("No es posible realizar reservación");
                System.out.println("Huesped alcanzó el máximo número de reservas");
            }
        }
        //Este this podría ir en el menú, pero lo dejaré aquí para mientras
        //Return por si se usa luego???? Si no, se cambiaria el tipo de funcion a void.
        return newHuesped;

    }

    public void CreacionReserva(Paquete paquete, Habitacion habitacion) {
        Huesped newHuesped = CreacionHuesped();
        //Aquí se creo el huesped con la funcion anterior.

        Scanner lector = new Scanner(System.in);
        int dias = lector.nextInt();
        //Dias a reservar, es facil porque solo es un int.   

        //Verifica que no tenga 7 o mas dias reservados
        if (dias > 7) {
            System.out.println("Máximo de días reservados. No es posible reservar más de 7 días");
        }

        //Ahora el problema es con paquete y habitación. Que no estoy segura si sería una funcion a lo "Escoger paquete" y que se revise la lista. al igual que habitacion.
        Reserva newReserva = new Reserva(newHuesped, paquete, habitacion, dias);
        newReserva.calcularPreciototal(ComprobarPisoReserva(newReserva));
        //agrega reserva a su correspondiente Array
        reservas.add(newReserva);

        /*//imprime todo lo que hay en el array
      for ( int i = 0; i < reservas.size(); i++ )
          System.out.println(reservas.get(i));*/
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
    //DIANA: TERMINA ESTO

    public void VerReserva() {
        System.out.println("Ingrese numero de reserva: ");
        Scanner lee = new Scanner(System.in);
        int numReserva = lee.nextInt();

        for (numReserva = 0; numReserva < reservas.size(); numReserva++) {
            System.out.println("Reserva es: ");
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

                            //Aquí tomara el numero del tamaño de la lista.
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
        System.out.print("Piso donde se encuentra habitación: ");
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
        System.out.print("Piso donde se encuentra habitación: ");
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

    }

    public void EliminarReserva() {
        int contador = 0;
        Scanner input = new Scanner(System.in);
        for (Reserva a : this.reservas) {
            System.out.println("Reserva #" + (contador + 1) + " Huesped:" + a.getHuesped() + " Paquete:" + a.getPaquete().getNombre() + " Habitación" + a.getPiso().getIdentificador() + a.getHabitacion().getNumCuarto() + " Cantidad de dias: " + a.getDias());
        }
        System.out.print("Número de reserva a eliminar: ");
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
                VerReserva();
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
                Paquete paquete;
                Habitacion habitacion;
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
