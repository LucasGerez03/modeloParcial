package modeloparcial;

public class Carguero extends Nave implements Exploracion{

    private double capacidadDeCarga;

    public Carguero(double capacidadDeCarga, String nombre, int capacidadTripulacion, int anioDeLanzamiento) {
        super(nombre, capacidadTripulacion, anioDeLanzamiento);
        this.capacidadDeCarga = validarCarga();
    }

    public void iniciarExploracion() {
        System.out.println("Iniciando exploracion de la nave " + getNombre() + "de tipo Carguero" + "con capacidad de " + this.capacidadDeCarga + "toneladas");
    }

    private double validarCarga() {
        if (this.capacidadDeCarga < 100) {
            System.out.println("****ADVERTENCIA****\n Carga inferior al limite, carga seleccionada: 100");
            return 100;
        } else if (this.capacidadDeCarga > 500) {
            System.out.println("****ADVERTENCIA****\n Carga superior al limite, carga seleccionada: 500");
            return 500;
        }else{
            return capacidadDeCarga;
        }
    }
    
    @Override
    public String mostrarNave() {
        return "NAVE CARGUERO: " + super.mostrarNave() + "Capacidad de carga: " + this.capacidadDeCarga + " Toneladas";
    }

}
