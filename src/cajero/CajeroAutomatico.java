package cajero;
import mock.*;
import banco.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import banco.CuentaBancaria;
import mock.GeneradorAleatorioDeMovimientos;
public class CajeroAutomatico {

    private CuentaBancaria cuentaBancariaActual;

    protected CajeroAutomatico(String identificador, String password){
        double cantidadAleatoria = ThreadLocalRandom.current().nextDouble(0,50000);
        cuentaBancariaActual = new CuentaAhorro("Nombre Cualquiera", cantidadAleatoria);
    }

    protected void mostraSaldo(){
        System.out.println("Su saldo actual es: "+cuentaBancariaActual.obtenerSaldo());
    }

    protected void ingresarDinero(){
        System.out.println("Cuento dinero desea ingresar ?");
        Scanner sc = new Scanner(System.in);
        double cantidad = sc.nextDouble();
        cuentaBancariaActual.ingresarDinero(cantidad);
    }

    protected void sacarDinero(){
        System.out.println("Cuanto dinero quiere sacar? ");
        Scanner sc = new Scanner(System.in);
        double cantidad = sc.nextDouble();
        cuentaBancariaActual.sacarDinero(cantidad);
    }

    protected void consultarUltimosMovimientos(){
        GeneradorAleatorioDeMovimientos generadorAleatorioDeMovimientos = new GeneradorAleatorioDeMovimientos();
        System.out.println("Cuanto movimientos quiere consultar?");
        Scanner sc = new Scanner(System.in);
        int numeroDeMovimientos = sc.nextInt();

        ArrayList<String> movimientos = generadorAleatorioDeMovimientos.obtenerMovimiento(numeroDeMovimientos, "Dolares");
        mostrarMovimientos(movimientos);
    }

    private void mostrarMovimientos(ArrayList<String> movimientos){
        for (String movimiento: movimientos) {
            System.out.println(movimiento);
        }
    }

    protected void mostrarCondicionesLegales(){
        cuentaBancariaActual.informarSobreCondicionesLegales();
    }


    protected void salir(){
        System.out.println("Muchas gracias por utilizar nuestros servicios");
    }
}
