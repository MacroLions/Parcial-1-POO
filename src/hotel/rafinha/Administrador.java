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

    /*ArrayList donde se almacena toda la informacion que se maneja en el sistema   
     */
    public ArrayList<Piso> pisos = new ArrayList();
    public ArrayList<Reserva> reservas = new ArrayList();
    public ArrayList<Huesped> huespedes = new ArrayList();
    public ArrayList<Paquete> paquetes = new ArrayList();

    /**
     * Crea un nuevo objeto del tipo huesped lo agrega a la lista de huespedes y
     * verifica sus reservaciones.
     *
     * @return newHuesped, que contiene el nombre, numero de DUI y tarjeta de
     * credito del nuevo huesped.
     */
    public Huesped CreacionHuesped() {
        Scanner lector = new Scanner(System.in);
        System.out.print("Ingrese el nombre del cliente ");
        String nombre = lector.nextLine();
        System.out.print("Ingrese numero de DUI ");
        String numeroDui = lector.nextLine();
        System.out.print("Ingrese numero de tarjeta de credito ");
        String numeroTarjetaCredito = lector.nextLine();

        Huesped newHuesped = new Huesped(nombre, numeroDui, numeroTarjetaCredito);

        //Se agrega a la lista de huespedes.
        //verifica que no tenga mas de 2 reservaciones
        this.huespedes.add(newHuesped);
        
        return newHuesped;

    }

    /**
     * Recibe elnombre del paquete a elegir y verifica que este exista.
     *
     * @return Si el paquete existe retorna el paquete solicitado, en otro caso
     * retorna null.
     */
    //´a´ es una variable de tipo paquete donde se almacena los datos del paquete escogido
    public Paquete EscogerPaquete() {
        Scanner input = new Scanner(System.in);
        System.out.print("Paquetes disponibles: ");
        for (Paquete a : this.paquetes) {
            System.out.print(a.getNombre() + ", ");
        }
        System.out.println("");
        System.out.print("Nombre del paquete a escoger: ");
        String NombrePaquete = input.nextLine().toUpperCase();//pide el nombre del paquete que desea

        boolean gato = false;

        while (gato == false) {
            for (Paquete a : this.paquetes) {
                if (a.getNombre().equals(NombrePaquete)) {
                    gato = true;
                }
            }
            if (gato == false) {
                System.out.print("El paquete no existe. Escoja un paquete valido: ");
                NombrePaquete = input.nextLine().toUpperCase();
            }
        }

        for (Paquete a : this.paquetes) {//se recorre el ArrayList "paquete" 
            if (a.getNombre().equals(NombrePaquete) == true) { //compara el nombre del paquete que se agregue para saber si existe dentro de la lista
                System.out.println("");
                return a; //retorna el paquete
            }
        }
        return null;
    }

    /**
     * Recibe el piso y habitacion a elegir y verifica sus existencias.
     *
     * @return retora la habitacion solicitado si esta existe o null en caso
     * contrario.
     */
    public Habitacion EscogerHabitacion() {
        Scanner input = new Scanner(System.in);

        System.out.println("Pisos disponibles: ");
        for (Piso a : this.pisos) {
            System.out.print(a.getIdentificador() + ", ");
        }

        System.out.println("");

        boolean gato = false;
        System.out.print("Ingrese el piso a escoger: ");
        char pisoHabitacion = input.nextLine().toUpperCase().charAt(0);

        while (gato == false) {
            for (Piso a : this.pisos) {
                if (a.getIdentificador() == pisoHabitacion) {
                    gato = true;
                }
            }
            if (gato == false) {
                System.out.print("Piso no existente, por favor ingrese un piso valido: ");
                pisoHabitacion = input.nextLine().toUpperCase().charAt(0);
            }
        }

        System.out.println("");
        System.out.println("Habitaciones diponibles en piso " + pisoHabitacion + ": ");
        for (Piso a : this.pisos) {
            if (a.getIdentificador() == pisoHabitacion) {
                for (Habitacion b : a.getHabitaciones()) {
                    System.out.print("Habitacion #" + b.getNumCuarto() + ", ");
                }
            }
        }
        System.out.println("");
        System.out.print("Ingrese el numero de la habitacion a escoger: ");
        int numHabitacion = input.nextInt();

        boolean gato2 = false;
        while (gato2 == false) {
            for (Piso a : this.pisos) {
                for (Habitacion b : a.getHabitaciones()) {
                    if (b.getNumCuarto() == numHabitacion) {
                        gato2 = true;
                    }
                }

            }
            if (gato2 == false) {
                System.out.print("Habitacion no existente, por favor ingrese una habitacion valida: ");
                numHabitacion = input.nextInt();
            }
        }
        for (Piso a : this.pisos) {
            if (a.getIdentificador() == pisoHabitacion) {
                for (Habitacion b : a.getHabitaciones()) {
                    if (b.getNumCuarto() == numHabitacion) {
                        System.out.println("");
                        return b;
                    }
                }
            }
        }
        return null;
    }

    /**
     *
     * @param paquete
     * @param habitacion
     * @return
     */
    public Reserva CreacionReserva(Paquete paquete, Habitacion habitacion) {
        Huesped newHuesped = CreacionHuesped(); // Modificar SOUTS DE CREACION HUESPED
        //AquÃƒÂ­ se creo el huesped con la funcion anterior.
        System.out.print("Dias a reservar: ");
        Scanner lector = new Scanner(System.in);
        int dias = lector.nextInt();

        //Verifica que no tenga 7 o mas dias reservados
        while (dias > 7) {
            System.out.println("Supera el maximo de dias posibles a reservar.");
            System.out.print("Ingrese cantidad de dias valido: ");
            dias = lector.nextInt();
        }
        //luego de recoger todos los parametros necesario la reserva se hace efectiva, es creadaa

        Reserva newReserva = new Reserva(newHuesped, paquete, habitacion, dias);
        newReserva.calcularPreciototal(ComprobarPisoReserva(newReserva));
        //agrega reserva a su correspondiente ArrayList
        reservas.add(newReserva);

        return newReserva;
    }

    public boolean ComprobarPisoReserva(Reserva reserva) {
        Piso pisoRevisar = reserva.getPiso();//Objeto tipo Piso
        int UltimoPisoID = this.pisos.size() - 1; //obtiene la cantidad de pisos que están creados
        int PenultimoPisoID = UltimoPisoID - 1; //obtiene el penultimo piso

        //verifica si el piso ingresado es el ultimo
        if (pisoRevisar.getIdentificador() == this.pisos.get(UltimoPisoID).getIdentificador()) {//
            return true;
            //verifica si el piso ingresado es el Penultimo
        } else if (pisoRevisar.getIdentificador() == this.pisos.get(PenultimoPisoID).getIdentificador()) {
            return true;
        } else {
            return false;
        }
    }

    //Revisar luego. O hacer uno para ver TODAS LAS RESERVAS.
    public void VerReserva() {
        //imprime todo lo que hay en el array reservas   
        Scanner input = new Scanner(System.in);

        System.out.println("1. Ver todas las reservas || 2. Ver reserva especifica");
        int opc = input.nextInt();

        switch (opc) {
            case 1:
                System.out.println("Todas las reservas: ");

                for (Reserva a : this.reservas) {
                    System.out.println("Reservas: ");
                    System.out.println("");
                    System.out.println("Nombre del Huesped: " + a.getHuesped().getNombre());
                    System.out.println("Paquete: " + a.getPaquete().getNombre());
                    System.out.println("Piso: " + a.getPiso().getIdentificador());
                    System.out.println("Habitacion: " + a.getHabitacion().getNumCuarto());
                    System.out.println("Dias reservados: " + a.getDias());
                    System.out.println("Precio total: " + a.getPrecioTotal());
                    System.out.println("");
                }
                break;

            case 2:

                System.out.println("Ingrese el numero de la reserva: ");
                int numReservaAImprimir = input.nextInt();
                int contador = 0;
                System.out.println("Su reserva: ");

                for (Reserva a : this.reservas) {
                    contador++; //contador ingrementa en uno cada vez que se 
                    if (numReservaAImprimir == contador) {
                        System.out.println("Reserva: ");

                        System.out.println("Nombre del Huesped: " + a.getHuesped().getNombre());
                        System.out.println("Paquete" + a.getPaquete().getNombre());
                        System.out.println("Piso: " + a.getPiso().getIdentificador());
                        System.out.println("Habitacion: " + a.getHabitacion().getNumCuarto());
                        System.out.println("Dias reservados: " + a.getDias());
                        System.out.println("Precio total: " + a.getPrecioTotal());
                    }
                }
                break;
        }
    }

    public void BorrarPiso(char identificador) {//ya
        int contador = 0;
        boolean pisoExiste = false;
        //mientras el contador sea menos a la cantidad de pisos
        while (contador <= this.pisos.size()) {
            for (Piso a : this.pisos) {//se recorren los pisos
                if (a.getIdentificador() == identificador) {//verifica que el identificador del piso solicitado coincida con un ya creado
                    pisoExiste = true;
                    this.pisos.remove(a);//se elimina el piso de la lista PISOS
                    System.out.println("Piso Eliminado");
                    System.out.println("");
                    return;
                }
            }
        }
        if (pisoExiste == false) {//si el identificador del piso ingresado no se encuentra en la lista es porque este no existe
            System.out.println("El piso no existe");
        }
    }

    public void AgregarPiso(char identificador) {

        int contador = 0;
        boolean pisoExiste = false;
        //mientras el contador sea menos que la cantidad de pisos
        for (Piso a : this.pisos) {//se recorren los pisos
            if (a.getIdentificador() == identificador) { //si el identificador ingresado es igual a uno que está en la lista es porque ese piso ya existe
                System.out.println("El piso ya existe.");
                pisoExiste = true;
                System.out.println("");
            }
        }
        if (pisoExiste == false) { //si los identificadores no coinciden entonces se agrega el nuevo piso
            Piso pisoNuevo = new Piso(identificador);
            int hab = 1;
            while (hab <= 10) {
                Habitacion habitacion = new Habitacion(hab, true, pisoNuevo, 200);
                pisoNuevo.habitaciones.add(habitacion);
                hab++;
            }
            this.pisos.add(pisoNuevo);
            System.out.println("Piso agregado!");
            System.out.println("");
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
        for (Piso a : this.pisos) {//recorre los pisos
            if (a.getIdentificador() == identificador) { //verifica que los identificadores sean iguales
                pisoExiste = true;
                for (Habitacion b : a.getHabitaciones()) {//verifica el numero y el identificador ingresados existan en el ArraList
                    if (b.getNumCuarto() == numHabitacion) {
                        habExiste = true;
                        a.getHabitaciones().remove(b);//si existe entonces elimina la habitación de lista
                        System.out.println("La habitacion #" + b.getNumCuarto() + " del piso: " + a.getIdentificador() + " ha sido eliminada.");
                        System.out.println("");
                        break;
                    }
                }
                if (habExiste == false) {
                    System.out.println("La habitacion no existe.");
                    break;
                }
            }
        }
        if (pisoExiste == false) { //cuando el piso no existe
            System.out.println("El piso no existe.");
        } else if (pisoExiste == true && habExiste == false) { //cuando el piso existe pero no existe la habitacion
            System.out.println("La habitacion no existe en el piso");
        }
    }

    /*clasifica las habitaciones por PARES E IMPARES
    si es PAR se modifica el precio
     */
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
        System.out.println("Precio base de habitaciones simples cambiado");
    }

    /*clasifica las habitaciones por PARES E IMPARES
    si es IMPAR se modifica el precio
     */
    public void CambiarPrecioBaseDoble(int newPrecio) {
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
        System.out.println("Precio base de habitaciones doble cambiado");
    }
//Solo existen dos paquetes. Se deberia entrar a la lista de paquetes.

    //PERMITE MODIFICAR LOS PAQUETE QUE EXISTEN
    public void ModPacks() {

        System.out.println("Elija el paquete a modificar:");
        int contador = 1;

        for (Paquete a : this.paquetes) {//recorre la lista de paquetes que ya hay y los imprime
            System.out.println("Paquete #" + contador + ": Nombre: " + a.getNombre() + " Descripcion: " + a.getSummary() + " Precio: " + a.getPrecioExtra());
            contador++;
        }

        Scanner scan = new Scanner(System.in);
        int opc = scan.nextInt();

        Paquete packEditar = this.paquetes.get(opc - 1);//se quita -1 a opc para poder obtener la posicion correcta

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
        this.paquetes.set(opc - 1, packEditar);

    }

    public void HabilitarHabitacion() { //ya
        int habitacion = 0;
        char piso;
        Scanner input = new Scanner(System.in);

        System.out.println("Pisos existentes: ");
        for (Piso a : this.pisos) {
            System.out.println("Piso: " + a.getIdentificador());
        }
        System.out.print("Piso donde se encuentra habitacion: ");
        piso = input.next().toUpperCase().charAt(0);

        System.out.println("Habitaciones en el piso " + piso + ": ");
        for (Piso b : this.pisos) {
            if (b.getIdentificador() == piso) {
                for (Habitacion c : b.getHabitaciones()) {
                    System.out.println("Habitacion #" + c.getNumCuarto() + " Disponibilidad:" + c.isDisponibilidad());
                }
            }
        }
        System.out.print("Numero de habitacion a Habilitar: ");
        habitacion = input.nextInt();

        for (Piso a : this.pisos) {//se recorren los pisos
            if (a.getIdentificador() == piso) { //si el identificador ingresado coincide con un piso existente
                for (Habitacion b : a.getHabitaciones()) {//se recorren sus habitaciones
                    if (b.getNumCuarto() == habitacion) {//si el numero de cuarto ingresado con un habitacion existemte
                        b.setDisponibilidad(true);//entonces la habitacion está disponible
                        System.out.println("Habitacion: " + b.getNumCuarto() + " En el piso: " + a.getIdentificador() + " habilitada!");
                        System.out.println("");
                    }
                }
            }

        }

    }

    public void DeshabilitarHabitacion() { //ya
        int habitacion = 0;
        char piso;
        Scanner input = new Scanner(System.in);

        System.out.println("Pisos existentes: ");
        for (Piso a : this.pisos) {
            System.out.println("Piso: " + a.getIdentificador());
        }
        System.out.print("Piso donde se encuentra habitacion: ");
        piso = input.next().toUpperCase().charAt(0);

        System.out.println("Habitaciones en el piso " + piso + ": ");
        for (Piso b : this.pisos) {
            if (b.getIdentificador() == piso) {
                for (Habitacion c : b.getHabitaciones()) {
                    System.out.println("Habitacion #" + c.getNumCuarto() + " Disponibilidad:" + c.isDisponibilidad());
                }
            }
        }
        System.out.print("Numero de habitacion a Deshabilitar: ");
        habitacion = input.nextInt();

        for (Piso a : this.pisos) {//se recorren los pisos
            if (a.getIdentificador() == piso) { //si el identificador ingresado coincide con un piso existente
                for (Habitacion b : a.getHabitaciones()) {//se recorren sus habitaciones
                    if (b.getNumCuarto() == habitacion) {//si el numero de cuarto ingresado con un habitacion existemte
                        b.setDisponibilidad(false);//entonces la habitacion está disponible
                        System.out.println("Habitacion: " + b.getNumCuarto() + " En el piso: " + a.getIdentificador() + " deshabilitada!");
                        System.out.println("");
                    }
                }
            }

        }

    }

    public void HabilitarPiso() {//ya
        Scanner input = new Scanner(System.in);
        System.out.println("Pisos existentes: ");
        for (Piso a : this.pisos) {//se recorren los pisos
            System.out.println("Piso: " + a.getIdentificador() + " Disponibilidad: " + a.isDisponibilidad());
        }
        System.out.print("Piso a habilitar: ");
        char piso = input.next().toUpperCase().charAt(0);
        for (Piso a : this.pisos) {//se recorren los pisos
            if (a.getIdentificador() == piso) {//verifica que el piso exista
                for (Habitacion b : a.getHabitaciones()) {//recorre las haitaciones
                    b.setDisponibilidad(true);
                }
                a.setDisponibilidad(true);
            }
        }
        System.out.println("Piso " + piso + " desbloqueado!");
        System.out.println("");
    }

    public void DeshabilitarPiso() { //ya
        Scanner input = new Scanner(System.in);
        System.out.println("Pisos existentes: ");
        for (Piso a : this.pisos) {//recorre los edificios
            System.out.println("Piso: " + a.getIdentificador() + " Disponibilidad: " + a.isDisponibilidad()); //imprime el identificador del piso
        }
        System.out.print("Piso a deshabilitar: ");
        char piso = input.next().toUpperCase().charAt(0);
        for (Piso a : this.pisos) {//recorre los piso
            if (a.getIdentificador() == piso) {//verifica que el piso exista
                for (Habitacion b : a.getHabitaciones()) {//recorre habitaciones
                    b.setDisponibilidad(false);
                }
                a.setDisponibilidad(false);
            }
        }
        System.out.println("Piso " + piso + " bloqueado!");
        System.out.println("");
    }

    public void ModificarReserva() {
        int contador = 1;
        Scanner input = new Scanner(System.in);
        for (Reserva a : this.reservas) {//recorre el ArrayListe de las reservsa
            String Nombre = a.getHuesped().getNombre(); //obtiene el nombre del huesped principal
            char pisoHabitacion = a.getPiso().getIdentificador(); //obtiene el identificador de la habitacion y su piso
            int numeroHabitacion = a.getHabitacion().getNumCuarto(); //obtiene el numero de cuarto
            String paqueteHabitacion = a.getPaquete().getNombre();//obtiene el paquete seleccionado
            int diasPaquete = a.getDias();//obtiene la cantidad de dias a reservar
            System.out.println("Reserva #" + contador + ": Nombre: " + Nombre + " Habitacion: " + pisoHabitacion + numeroHabitacion + " Paquete: " + paqueteHabitacion + " Dias reservados: " + diasPaquete);
            contador++;
        }

        System.out.println("");
        System.out.print("Reserva a editar: ");
        int NumeroReservaAModificar = input.nextInt();
        Reserva ReservaAModificar = this.reservas.get(NumeroReservaAModificar - 1); //-1 para captar la cantidad de elementos del ArrayList

        //MENU que permite cambiar los datos uno por uno sin necesidad de modicar los demas si es que no se desea
        System.out.println("");
        System.out.println("1. Modificar Huesped");
        System.out.println("2. Modificar Habitacion");
        System.out.println("3. Modificar Paquete");
        System.out.println("4. Modificar Dias reservados");
        System.out.print("Ingrese el numero de opcion que desea modificar: ");
        int opcion = input.nextInt();
        System.out.println("");

        //Menu con las funciones en cada case
        switch (opcion) {
            case 1:
                System.out.print("Nuevo propietario de la reserva: ");
                Scanner input2 = new Scanner(System.in);
                String NuevoNombre = input2.nextLine().toUpperCase();
                boolean gato = false;

                for (Huesped a : this.huespedes) {//recorre lista de huespedes buscando el huesped que se quiere cambiar
                    if (a.getNombre().toUpperCase().equals(NuevoNombre)) {
                        ReservaAModificar.setHuesped(a);//si se encuentra se pide ingresa al nuevo
                        this.reservas.set(NumeroReservaAModificar - 1, ReservaAModificar);
                        System.out.println("Propietario de reserva modificado!");
                        System.out.println("");
                        gato = true;
                        break;

                    }
                }
                if (gato == false) {
                    System.out.println("El huesped nuevo no existe.");
                    System.out.println("");
                }
                break;
            case 2:
                System.out.println("");
                System.out.println("Pisos disponibles: ");
                for (Piso a : this.pisos) {
                    System.out.print(a.getIdentificador() + ", ");
                }
                System.out.println("");
                System.out.print("Piso donde se encuenttra la nueva habitacion: ");
                char pisoNuevo = input.next().toUpperCase().charAt(0);
                System.out.print("Numero de la nueva habitacion: ");
                int NuevoNumeroDeHabitacion = input.nextInt();

                for (Piso a : this.pisos) {
                    if (a.getIdentificador() == pisoNuevo) {//ve que el pisoexiste
                        for (Habitacion b : a.getHabitaciones()) {//recorre habitaciones
                            if (b.getNumCuarto() == NuevoNumeroDeHabitacion) {//verifica que el numero de cuarto y que este disponible
                                ReservaAModificar.setHabitacion(b);// si es verdadero pide los datos para modificar habitacion
                                ReservaAModificar.setPiso(a);
                                this.reservas.set(NumeroReservaAModificar - 1, ReservaAModificar);
                                System.out.println("Habitacion modificada!");
                                System.out.println("");
                                break;
                            }
                        }
                    }
                }
                break;
            case 3://sobreescribe paquete
                Scanner input3 = new Scanner(System.in);
                System.out.print("Nuevo paquete para la reserva: ");
                String NuevoNombrePaquete = input3.nextLine().toUpperCase();
                boolean neko = false;

                for (Paquete a : this.paquetes) {
                    if (a.getNombre().equals(NuevoNombrePaquete)) {
                        ReservaAModificar.setPaquete(a);
                        this.reservas.set(NumeroReservaAModificar - 1, ReservaAModificar);
                        System.out.println("Paquete modificado!");
                        System.out.println("");
                        neko = true;
                        break;
                    }
                }
                if (neko == false) {
                    System.out.println("El paquete escogido no existe.");
                }
                break;
            case 4:
                //sobreescribe la cantidad de dias reservados
                System.out.print("Nueva cantidad de dias: ");
                int NuevosDias = input.nextInt();
                if (NuevosDias <= 7) {
                    ReservaAModificar.setDias(NuevosDias);
                    this.reservas.set(NumeroReservaAModificar - 1, ReservaAModificar);
                    System.out.println("Dias modificados!");
                    System.out.println("");
                    break;
                } else {
                    System.out.println("La cantidad de dias no es valida");
                    break;
                }
        }

    }
//elimina una reserva de la lista donde se almancenan
// Merlin y Solomon estuvieron aqui.
    public void EliminarReserva() {
        int contador = 0;
        Scanner input = new Scanner(System.in);
        for (Reserva a : this.reservas) {//busca la reserva y si la encuentra la imprime
            System.out.println("Reserva #" + (contador + 1) + " Huesped:" + a.getHuesped().getNombre() + " Paquete:" + a.getPaquete().getNombre() + " Habitacion: " + a.getPiso().getIdentificador() + a.getHabitacion().getNumCuarto() + " Cantidad de dias: " + a.getDias());
        }
        System.out.print("Numero de reserva a eliminar: ");
        int reserva = input.nextInt();
        this.reservas.remove(reserva - 1);//elimina la reserva de la lista
        System.out.println("Se elimino la reserva! :D");
        System.out.println("");

    }

    /*
    EXISTEN DOS MENU PRINCIPALES
    UNO (MENU CONFIGURACION)DONDE SE REALIZAN TODAS LAS CONFIGURACIONES QUE SE PUEDE HACER A LAS HABITACIONES,
    PISOS, RESERVACIONES Y PRECIOS
    Y OTRO MENU(MENU RESERVA) DONDE SE PUEDE CREAR LAS RESERVAS Y TAMBIEN SE PUEDEN VER
     */
    public void MenuConfiguracion() {
        Scanner lector = new Scanner(System.in);
//IMPRIME TODAS LAS OPCIONES DIPONIBLES EN EL MENU CONFIGURACION
        System.out.println("** MENU CONFIGURACION **");
        System.out.println("1. Eliminar reservacion ");
        System.out.println("2. Modificar reserva ");
        System.out.println("3. Crear Huesped");
        System.out.println("4. Agregar Piso ");
        System.out.println("5. Eliminar Piso ");
        System.out.println("6. Borrar Habitacion");
        System.out.println("7. Habilitar Habitacion");
        System.out.println("8. Desabilitar Habitacion");
        System.out.println("9. Habilitar piso");
        System.out.println("10.Deshabilitar piso");
        System.out.println("11.Cambiar Precio Base Simple");
        System.out.println("12.Cambiar Precio Base Doble");
        System.out.println("13.Salir");
        System.out.print("Opcion: ");
        Scanner input = new Scanner(System.in);
//SWITCH CON TODAS LAS FUNCIONES NECESARIAS
        int opcion;
        opcion = lector.nextInt();
        switch (opcion) {
            case 1:
                EliminarReserva();
                break;
            case 2:
                System.out.println("");
                ModificarReserva();
                break;
            case 3:
                CreacionHuesped();
                break;
            case 4:
                System.out.print("Cual es el identificador del piso que desea agregar: ");
                char piso = input.next().toUpperCase().charAt(0);
                AgregarPiso(piso);
                break;
            case 5:
                System.out.println("Pisos existentes: ");
                for (Piso a : this.pisos) {
                    System.out.print(a.getIdentificador() + " ");
                }
                System.out.println("");
                System.out.print("Ingrese el identificador del piso que desea eliminar: ");
                char piso1 = input.next().toUpperCase().charAt(0);//Obtiene el identidicador que se desea eliminar
                BorrarPiso(piso1);
                break;
            case 6:
                for (Piso a : this.pisos) {
                    System.out.println("Piso: " + a.getIdentificador() + " Cantidad de habitaciones: " + a.getHabitaciones().size());
                }
                System.out.print("Ingrese el identificador del piso donde esta ubicada la habitacion a eliminar: ");
                char pisoEliminar = input.next().toUpperCase().charAt(0);
                System.out.print("Ingrese el numero de habitacion que desea borrar: ");
                int num = lector.nextInt();

                BorrarHabitacion(pisoEliminar, num);
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
                System.out.println("");
                DeshabilitarPiso();
                break;
            case 11:
                int newPrecio;
                System.out.print("Nuevo precio base para habitaciones simples: ");
                newPrecio = lector.nextInt();
                CambiarPrecioBaseSimple(newPrecio);
                break;
            case 12:
                int newPrecio1;
                System.out.print("Nuevo precio base para habitaciones dobles: ");
                newPrecio1 = lector.nextInt();
                CambiarPrecioBaseDoble(newPrecio1);
                break;
            case 13:
                break;
        }
    }
//segundo MENU

    public void MenuReserva() {
        System.out.println("** MENU RESERVA **");
        System.out.println("1. Crear Reservacion ");
        System.out.println("2. Ver reservaciones");

        Scanner lector = new Scanner(System.in);
        int eleccion;
        System.out.print("Opcion: ");
        eleccion = lector.nextInt();
        switch (eleccion) {
            case 1:
                System.out.println("");
                Paquete paquete = EscogerPaquete();
                Habitacion habitacion = EscogerHabitacion();
                CreacionReserva(paquete, habitacion);
                System.out.println("");
                System.out.println("Reserva Creada! :D");
                System.out.println("");
                break;
            case 2:
                System.out.println("");
                VerReserva();
                break;
        }

    }

    //PRINCIAPAL DONDE LOS MENU CONFIGURACION Y RESERVA SE EJECUTAN
    public boolean MenuPrincipal() {
        System.out.println("** MENU PRINCIPAL **");

        System.out.println("** 1. MENU RESERVACION || 2. MENU CONFIGURACION || 3. SALIR ** ");

        Scanner lector = new Scanner(System.in);

        int opcion = 0;
        System.out.print("Opcion: ");
        opcion = lector.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("");
                MenuReserva();
                return true;
            case 2:
                System.out.println("");
                MenuConfiguracion();
                return true;
            case 3:
                return false;
        }
        return false;
    }

}
