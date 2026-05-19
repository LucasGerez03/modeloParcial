/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloparcial;

/**
 *
 * @author Usuario
 */
public class CruceroEstelar extends Nave {
    //--------------------------------------------
    private int cantidadDePasajeros;
    
    //--------------------------------------------

    public CruceroEstelar(int cantidadDePasajeros, String nombre, int capacidadTripulacion, int anioDeLanzamiento) {
        super(nombre, capacidadTripulacion, anioDeLanzamiento);
        this.cantidadDePasajeros = cantidadDePasajeros;
    }
    
    @Override
    public String mostrarNave() {
        return "CRUCERO ESTELAR: " + super.mostrarNave() + "Cantidad De Pasajeros: " + this.cantidadDePasajeros;
    }
    
}
