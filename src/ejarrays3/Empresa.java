/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejarrays3;

import numeros.Numeros;
import textos.Textos;

/**
 *
 * @author dam
 */
public class Empresa {

    Entrada[] tabla;
    Vendedor[] vendedores;

    public Empresa() {
        /*   tabla=new Entrada[5];
        tabla[0]=new Entrada (10000f,0.05f);
        tabla[1]=new Entrada (15000f,0.1f);
        tabla[2]=new Entrada (20000f,0.15f);
        tabla[3]=new Entrada (25000f,0.2f);
        tabla[4]=new Entrada (Float.MAX_VALUE,0.25f);
        vendedores= new Vendedor[5];       
         */
        tabla = new Entrada[]{
            new Entrada(10000f, 0.05f),
            new Entrada(15000f, 0.1f),
            new Entrada(20000f, 0.15f),
            new Entrada(25000f, 0.2f),
            new Entrada(Float.MAX_VALUE, 0.25f)};
        vendedores = new Vendedor[5];

    }

    public Empresa(int nvendedores) {
        tabla = new Entrada[]{
            new Entrada(10000f, 0.05f),
            new Entrada(15000f, 0.1f),
            new Entrada(20000f, 0.15f),
            new Entrada(25000f, 0.2f),
            new Entrada(Float.MAX_VALUE, 0.25f)};
        vendedores = new Vendedor[nvendedores];

    }
/*
    private void crearVendedores() {
        for (int pos = 0; pos < vendedores.length; pos++) {
            vendedores[pos] = new Vendedor();
        }
    }
*/
    public void pedirNombres() {
        String nombre;
        for (int pos = 0; pos < vendedores.length; pos++) {
            nombre = Textos.pedirString("Nombre del vendedor " + pos + ": ");
            vendedores[pos] = new Vendedor(nombre);
            //vendedores[pos]=new Vendedor ();
            //vendedores[pos]=setNombre(nombre);
        }
    }

    public void ventas() {
        float importe;
        int codVendedor;
        codVendedor = Numeros.pedirNumero("Código Vendedor; -1 Salir: ", -1,
                vendedores.length - 1);
        while (codVendedor != -1) {
            importe = Numeros.pedirNumeroReal("Ventas de "
                    + vendedores[codVendedor].getNombre()+" :", 0);

            vendedores[codVendedor].acumularVentas(importe);

            codVendedor = Numeros.pedirNumero("Código Vendedor; -1 Salir: ", -1,
                    vendedores.length - 1);

        }

    }

    public void informe() {
        float porcentaje;
        float importeComision;
        System.out.println("NOMBRE \t\t VENTAS \t IMPORTE COMISION ");
        for (int pos = 0; pos < vendedores.length; pos++) {
            porcentaje = buscarPorcentaje(vendedores[pos].getVentas());
            importeComision = vendedores[pos].getVentas() * porcentaje;
            System.out.println(vendedores[pos].getNombre()
                    + "\t\t" + vendedores[pos].getVentas() + "\t\t\t" 
                    + importeComision);
        }
    }

    /**
     * Este metodo busca el porcentaje a aplicar a las ventas del vendedor
     *
     * @param ventas de un vendedor
     * @return porcentaje a aplicar.
     */
    private float buscarPorcentaje(float ventas) {
        int pos = 0;
        float porcentaje;
        boolean encontrado = false;
        while (!encontrado) {
            if (ventas < tabla[pos].getHasta()) {
                encontrado = true;
            } else {
                pos++;
            }
        }
        return tabla[pos].getPorcentaje();
    }

    public String buscarMejorVendedor() {
        int mayor = 0;
        for (int pos = 1; pos < vendedores.length; pos++) {
            if (vendedores[pos].getVentas() > vendedores[mayor].getVentas()) {
                mayor = pos;
            }
        }
        return vendedores[mayor].getNombre();
    }

    public String buscarPeorVendedor() {
        int menor =0 ;
        for (int pos = 1; pos < vendedores.length; pos++) {
            if (vendedores[pos].getVentas() < vendedores[menor].getVentas()) {
                menor = pos;
            }
        }
        return vendedores[menor].getNombre();
    }
}
