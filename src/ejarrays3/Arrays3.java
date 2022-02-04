/*
 Un concesionario de automóviles paga a sus empleados una comisión dependiendo
del importe de las ventas que han efectuado. Para ello se pide:

• Introducir los nombres de los vendedores.

• Introducir los importes de las diferentes ventas que han efectuado los 
vendedores hasta que el operador pulse –1 como código del vendedor.
Un mismo vendedor puede haber efectuado varias ventas por lo que la 
comisión se hará en función de la suma de todas las ventas.

• Obtener el siguiente informe:

NOMBRE VENDEDOR     IMPORTE VENTAS      IMPORTE COMISIÓN

Donde la comisión se obtiene de la siguiente tabla:

IMPORTE (Hasta) % COMISIÓN
Hasta 10000 € 5%
Hasta 15000 € 10%
Hasta 20000 € 15%
Hasta 25000 € 20%
Más de 25000 € 25%

Además, se quiere visualizar el nombre del vendedor con más comisión,
así como el nombre del vendedor con menos comisión.
 */
package ejarrays3;

/**
 *
 * @author dam
 */
public class Arrays3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Empresa miEmpresa=new Empresa();
       
       miEmpresa.pedirNombres();
       miEmpresa.ventas();
       miEmpresa.informe();
        System.out.println("Mejor vendedor es: "+
                miEmpresa.buscarMejorVendedor());
         System.out.println("Peor vendedor es: "+
                miEmpresa.buscarPeorVendedor());
    }
    
}
