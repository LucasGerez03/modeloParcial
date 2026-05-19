package modeloparcial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;

public class EstacionEspacial implements Exploracion {

    //-------------------------------------------------------------
    //atributos
    ArrayList<Nave> navesEnEstacion;

    //-------------------------------------------------------------
    //constructor
    public EstacionEspacial() {
        this.navesEnEstacion = new ArrayList<>();
    }

    //-------------------------------------------------------------
    //getter
    public ArrayList<Nave> getNavesEnEstacion() {
        return navesEnEstacion;
    }

    //----------------------------------------------------------
    //metodos
    private boolean yaEstaEnEstacion(String nombreNave, int unAnio) {
        for (Nave n1 : this.navesEnEstacion) {
            if (n1.getNombre().equalsIgnoreCase(nombreNave) && n1.getAnioDeLanzamiento() == unAnio) {
                return true;
            }
        }
        return false;
    }

    //----------------------------------------------------------
    //opcion 1
    public void agregarNave(Scanner scanner) {

        Nave naveAgregar = null;

        System.out.println("\n--- Tipo de nave ---");
        System.out.println("1. Nave de exploración");
        System.out.println("2. Carguero");
        System.out.println("3. Crucero estelar");
        System.out.print("Seleccione tipo de nave: ");
        try {
            int tipo = Integer.parseInt(scanner.nextLine());
            while (!(1 <= tipo && tipo <= 3)) {
                System.out.println("XXXXXX VALOR INCORRECTO: Ingrese un numero entre (1 - 3) XXXXXX\n");
                tipo = Integer.parseInt(scanner.nextLine());
            }

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Capacidad de tripulación: ");
            int tripulacion = Integer.parseInt(scanner.nextLine());

            System.out.print("Año de lanzamiento: ");
            int anio = Integer.parseInt(scanner.nextLine());

            while (yaEstaEnEstacion(nombre, anio)) {
                System.out.println("***ADVERTENCIA***: los datos ingresados pertenece una nave existente en la Estacion Espacial");
                System.out.println("Porfavor Ingrese los datos nuevamente de su nave (nombre y anio)");
                System.out.print("Nombre: ");
                nombre = scanner.nextLine();
                System.out.print("Año de lanzamiento: ");
                anio = Integer.parseInt(scanner.nextLine());
            }

            switch (tipo) {
                case 1:
                    System.out.println("Tipos de misión (1. CARTOGRAFIA, 2. INVESTIGACION, 3. CONTACTO):");
                    Mision misionNave;
                    int opMision = Integer.parseInt(scanner.nextLine());

                    while (!( 1 <= opMision && opMision <= 3)) {
                        System.out.println("Ingrese un numero entre (1 - 3)\n");
                        opMision = Integer.parseInt(scanner.nextLine());
                    }

                    if (opMision == 1) {
                        misionNave = Mision.CARTOGRAFIA;
                    } else if (opMision == 2) {
                        misionNave = Mision.INVESTIGACION;
                    } else {
                        misionNave = Mision.CONTACTO;
                    }

                    naveAgregar = new NaveExploracion(misionNave, nombre, tripulacion, anio);
                    break;
                    
                case 2:
                    System.out.print("Capacidad de carga (100 a 500): ");
                    int carga = Integer.parseInt(scanner.nextLine());

                    naveAgregar = new Carguero(carga, nombre, tripulacion, anio);
                    break;
                    
                case 3:
                    System.out.print("Cantidad de pasajeros: ");
                    int pasajeros = Integer.parseInt(scanner.nextLine());
                    naveAgregar = new CruceroEstelar(pasajeros, nombre, tripulacion, anio);
                    break;
                    
                default:
                    System.out.println("XXXXXX VALOR INCORRECTO: Ingrese un numero entre (1 - 3) XXXXXX\n");
            }
            
            if (naveAgregar != null) {
                this.navesEnEstacion.add(naveAgregar);
                System.out.println("Nave agregada con éxito.");
            }
        } catch (Exception e) {
            System.out.println("XXXXXXX ERROR: " + e.getMessage() + " Reintentar Opcion XXXXXXX\n");
        }
    }

    //----------------------------------------------------------
    //opcion 2
    public void mostrarNaves() {
        for (Nave n : this.navesEnEstacion) {
            System.out.println(n.mostrarNave());
        }
    }
    
    private void mostrarNaves(ArrayList<Nave> n1) { //solo se usa para mostrar las naves en la opcion 4, 5 y 6
        for (Nave n : n1) {
            System.out.println(n.mostrarNave());
        }
    }

    //----------------------------------------------------------
    //opcion 3
    @Override
    public void iniciarExploracion() {
        NaveExploracion ne;
        Carguero c;
        
        System.out.println("------- INICIANDO EXPLORACION ESPACIAL DE NAVES CARGUEROS Y DE EXPLORACION -------");
        System.out.println("**** ADVERTENCIA: las naves de tipo Crucero Estelar NO PUEDEN REALIZAR EXPLORACIONES ****\n");
        for (Nave n : this.navesEnEstacion) {
            if (n instanceof Carguero) {
                c = (Carguero) n;
                c.iniciarExploracion();

            } else if (n instanceof NaveExploracion) {
                ne = (NaveExploracion) n;
                ne.iniciarExploracion();
            }
        }
        System.out.println("\n--------- Exploracion espacial completada con exito ---------\n");
    }

    //----------------------------------------------------------
    //opcion 4
    public void mostrarNavesPorNombre() {
        ArrayList<Nave> navesOrdenadas = new ArrayList<>(getNavesEnEstacion());
        Collections.sort(navesOrdenadas); //ordeno con el compareTo de la clase Nave
        mostrarNaves(navesOrdenadas);   //uso el metodo sobrecargado de la clase
    }

    //----------------------------------------------------------
    //opcion 5
    public void mostrarNavesAnioDesc(){
        ArrayList<Nave> navesAnioDesc = new ArrayList<>(getNavesEnEstacion());
        Collections.sort(navesAnioDesc, (n1, n2) -> n2.getAnioDeLanzamiento() - n1.getAnioDeLanzamiento()); 
        mostrarNaves(navesAnioDesc); // ^ utilizo una funcion lambda que devuelva en orden DESC las naves por anio de lanzamiento
    }                               //uso el metodo sobrecargado de la clase
    
    //----------------------------------------------------------
    //opcion 6
    public void mostrarNavesTripDesc(){
        ArrayList<Nave> navesTripDesc = new ArrayList<>(getNavesEnEstacion());
        Collections.sort(navesTripDesc, (n1, n2) -> n2.getCapacidadTripulacion() - n1.getCapacidadTripulacion());
        mostrarNaves(navesTripDesc);
    }
    //----------------------------------------------------------
}