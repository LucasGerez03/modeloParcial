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
            if (n1.getNombre().equals(nombreNave) && n1.getAnioDeLanzamiento() == unAnio) {
                return true;
            }
        }
        return false;
    }

    //----------------------------------------------------------
    //opcion 1
    public void agregarNave() {
        Scanner scanner = new Scanner(System.in);

        Nave naveAgregar = null;

        System.out.println("\n--- Tipo de nave ---");
        System.out.println("1. Nave de exploración");
        System.out.println("2. Carguero");
        System.out.println("3. Crucero estelar");
        System.out.print("Seleccione tipo de nave: ");
        try {
            int tipo = scanner.nextInt();
            while (!(1 <= tipo && tipo <= 3)) {
                System.out.println("XXXXXX VALOR INCORRECTO: Ingrese un numero entre (1 - 3) XXXXXX\n");
                tipo = scanner.nextInt();
            }

            System.out.print("Nombre: ");
            String nombre = scanner.next();

            System.out.print("Capacidad de tripulación: ");
            int tripulacion = scanner.nextInt();

            System.out.print("Año de lanzamiento: ");
            int anio = scanner.nextInt();

            while (yaEstaEnEstacion(nombre, anio)) {
                System.out.println("***ADVERTENCIA***: los datos ingresados pertenece una nave existente en la Estacion Espacial");
                System.out.println("Porfavor Ingrese los datos nuevamente de su nave (nombre y anio)");
                System.out.print("Nombre: ");
                nombre = scanner.next();
                System.out.print("Año de lanzamiento: ");
                anio = scanner.nextInt();

            }

            switch (tipo) {
                case 1:
                    System.out.println("Tipos de misión (1. CARTOGRAFIA, 2. INVESTIGACION, 3. CONTACTO):");
                    Mision misionNave;
                    int opMision = scanner.nextInt();

                    while (!( 1 <= opMision && opMision <= 3)) {
                        System.out.println("Ingrese un numero entre (1 - 3)\n");
                        opMision = scanner.nextInt();
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
                    int carga = scanner.nextInt();

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
            this.navesEnEstacion.add(naveAgregar);
        } catch (Exception e) {
            System.out.println("XXXXXXX ERROR: " + e + " Reintentar Opcion XXXXXXX\n");
        }

    }

    //----------------------------------------------------------
    //opcion 2
    public void mostrarNaves() {
        for (Nave n : this.navesEnEstacion) {
            System.out.println(n.mostrarNave());
        }
    }
    
    private void mostrarNaves(ArrayList<Nave> n1) { //solo se usa para mostrar las naves en la opcion 4 y 5
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
                System.out.println(c.mostrarNave());

            } else if (n instanceof NaveExploracion) {
                ne = (NaveExploracion) n;
                System.out.println(ne.mostrarNave());
            }
        }
        System.out.println("\n--------- Exploracion espacial completada con exito ---------\n");
    }

    //----------------------------------------------------------
    //opcion 4
    public void mostrarNavesPorNombre() {;
        ArrayList<Nave> navesOrdenadas = new ArrayList<>(getNavesEnEstacion());
        Collections.sort(navesOrdenadas);
        
        mostrarNaves(navesOrdenadas);
        
    }

    //----------------------------------------------------------
    //opcion 5
    
    public void mostrarNavesAnioDesc(){
        ArrayList<Nave> navesAnioDesc = new ArrayList<>(getNavesEnEstacion());
        
        Collections.sort(navesAnioDesc, (n1, n2) -> n2.getAnioDeLanzamiento()- n1.getAnioDeLanzamiento());
        
        mostrarNaves(navesAnioDesc);
        
        
    }
    //----------------------------------------------------------
    //opcion 6
    
    public void mostrarNavesTripDesc(){
        ArrayList<Nave> navesTripDesc = new ArrayList<>(getNavesEnEstacion());
        
        Collections.sort(navesTripDesc, (n1, n2) -> n2.getCapacidadTripulacion()- n1.getCapacidadTripulacion());
        
        mostrarNaves(navesTripDesc);
    }
    //----------------------------------------------------------
}
