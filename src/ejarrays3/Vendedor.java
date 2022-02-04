/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejarrays3;

/**
 *
 * @author dam
 */
public class Vendedor {
    private String nombre;
    private float ventas;

    public Vendedor() {
    }

    public Vendedor(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public float getVentas() {
        return ventas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void acumularVentas(float importe){
        ventas =ventas+importe;
    }
    
    
    
}
