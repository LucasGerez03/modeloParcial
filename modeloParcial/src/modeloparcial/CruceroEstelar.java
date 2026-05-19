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
    //atributos
    private int cantidadDePasajeros;
    
    //--------------------------------------------
    //constructor
    
    public CruceroEstelar(int cantidadDePasajeros, String nombre, int capacidadTripulacion, int anioDeLanzamiento) {
        super(nombre, capacidadTripulacion, anioDeLanzamiento);
        this.cantidadDePasajeros = cantidadDePasajeros;
    }
    
    //-------------------------------------------------------------
    //metodos
    @Override
    public String mostrarNave() {
        return "CRUCERO ESTELAR: " + super.mostrarNave() + "Cantidad De Pasajeros: " + this.cantidadDePasajeros;
    }
    
}
