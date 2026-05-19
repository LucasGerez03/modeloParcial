package modeloparcial;

public class NaveExploracion extends Nave implements Exploracion{
    //--------------------------------------------
    //atributos
    private Mision tipoMision;
    
    //--------------------------------------------
    //constuctor
    public NaveExploracion(Mision tipoMision, String nombre, int capacidadTripulacion, int anioDeLanzamiento) {
        super(nombre, capacidadTripulacion, anioDeLanzamiento);
        this.tipoMision = tipoMision;
    }
    
    //--------------------------------------------
    //metodos
    @Override
    public void iniciarExploracion() {
        System.out.println("Iniciando exploracion de la nave " + getNombre() + "de tipo Crucero Estelar" + "con mision: " + this.tipoMision );
    }

    @Override
    public String mostrarNave() {
        return "NAVE DE EXPLORACION: " + super.mostrarNave() + "tipo de Mision: " + this.tipoMision;
    }
    
    
    
    
}

enum Mision {
    CARTOGRAFIA, INVESTIGACION,
    CONTACTO
}
