package modeloparcial;

public abstract class Nave implements Comparable<Nave> {

    private String nombre;
    private int capacidadTripulacion;
    private int anioDeLanzamiento;

    public Nave(String nombre, int capacidadTripulacion, int anioDeLanzamiento) {
        this.nombre = nombre;
        this.capacidadTripulacion = capacidadTripulacion;
        this.anioDeLanzamiento = anioDeLanzamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidadTripulacion() {
        return capacidadTripulacion;
    }

    public int getAnioDeLanzamiento() {
        return anioDeLanzamiento;
    }

    
    public String mostrarNave() {
        return "Nombre: " + nombre + ", Cant. Tripulacion: " + capacidadTripulacion + " Pasajeros" + ", Anio de Lanzamiento:" + anioDeLanzamiento + ",";
    }

    @Override
    public int compareTo(Nave otraNave){
        return this.nombre.compareToIgnoreCase(otraNave.getNombre());
    };

    

}
