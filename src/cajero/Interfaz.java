package cajero;

import cajero.CajeroAutomatico;

import java.util.Scanner;

public class Interfaz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor introduzca su numero de identificación ");
        String identificador = sc.nextLine();
        System.out.println("Por favor introduzca su contraseña");
        String contrasena = sc.nextLine();
        CajeroAutomatico cajero = new CajeroAutomatico(identificador, contrasena);

        int opcionSeleccionada;
        do{
            System.out.println("Elija una de las siguientes opciones :");
            System.out.println("    Escriba 1 para consultar su saldo");
            System.out.println("    Escriba 2 para ingresar dinero");
            System.out.println("    Escriba 3 para sacar dinero");
            System.out.println("    Escriba 4 para consultar ultimos movimientos");
            System.out.println("    Escriba 5 para consultar las condiciones legales");
            System.out.println("Para salir escriba cualquier otro numero");

            opcionSeleccionada = sc.nextInt();

            switch (opcionSeleccionada){
                case 1:
                    cajero.mostraSaldo();;
                    break;
                case 2:
                    cajero.ingresarDinero();
                    break;
                case 3:
                    cajero.sacarDinero();
                    break;
                case 4:
                    cajero.consultarUltimosMovimientos();
                    break;
                case 5:
                    cajero.mostrarCondicionesLegales();
                    break;
                default:
                    cajero.salir();
            }

        }while(opcionSeleccionada == 1 || opcionSeleccionada == 2 || opcionSeleccionada == 3 || opcionSeleccionada == 4 || opcionSeleccionada == 5);
    }
}
