package modeloparcial;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        EstacionEspacial estacion = new EstacionEspacial();
        estacion.navesEnEstacion.add(new NaveExploracion(Mision.INVESTIGACION, "LA PEPONA", 123, 1233));
        estacion.navesEnEstacion.add(new NaveExploracion(Mision.INVESTIGACION, "STAR UARS", 77, 12343));
        estacion.navesEnEstacion.add(new CruceroEstelar(2000, "titanic", 213, 5000));
        estacion.navesEnEstacion.add(new Carguero(5, "Felipe Cargas", 15, 7777));
        
        

        StringBuilder sb = new StringBuilder("");
        sb.append("-------- Iniciando programa de naves --------\n");
        sb.append("-------- INGRESE UNA OPCION (1 - 7) --------\n");
        sb.append("1. Agregar nave (Exploracion, Carguero o Crucero Estelar)\n"
                + "2. Mostrar todas las naves registradas.\n"
                + "3. Iniciar mision de exploracion\n"
                + "4. Mostrar naves ordenadas por nombre (Comparable)\n"
                + "5. Mostrar naves ordenadas por anio de lanzamiento descendente.\n"
                + "6. Mostrar naves ordenadas por capacidad de tripulacion descendente.\n"
                + "7. Salir del Sistema");
        
        while (true) {

            System.out.println(sb);
            try {

                int optn = 0;
                Scanner sc = new Scanner(System.in);

                optn = sc.nextInt();

                switch (optn) {
                    case 1:
                        
                        estacion.agregarNave();
                        break;
                    case 2:
                        
                        estacion.mostrarNaves();
                        break;
                    case 3:
                        
                        estacion.iniciarExploracion();
                        break;
                    case 4:
                        estacion.mostrarNavesPorNombre();
                        break;
                    case 5:
                        estacion.mostrarNavesAnioDesc();
                        break;
                    case 6:
                        estacion.mostrarNavesTripDesc();
                        break;
                    case 7:
                        System.out.println("------------------ PROGRAMA FINALIZADO ------------------");
                        return;
                    default:
                        System.out.println("XXXXXX VALOR INCORRECTO: Ingrese un numero entre (1 - 7) XXXXXX\n");
                        continue;

                }
                if(!continuar()){
                    return;
                };
            
            } catch (Exception e) {
                System.out.println("XXXXXXX ERROR: " + e + " Reintentar Opcion XXXXXXX\n");
            }
            
        }
    }

    public static boolean continuar() {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> opciones = new ArrayList<>();
        opciones.add("S");
        opciones.add("N");
        opciones.add("Y");

        String continuar = sc.next();
        while (!opciones.contains(continuar.toUpperCase())) {
            System.out.println("Desea Continuar? Y/N: ");
            continuar = sc.next();
        }

        if (continuar.equalsIgnoreCase("N")) {
            System.out.println("Programa Finalizado.");
            sc.close();
            return false;
        } else {
            sc.close();
            return true;
        }

    }

}
