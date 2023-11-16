package Cajero_Archivos;
import java.util.Scanner;

public class CajeroAutomaticoMain {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
        ATM atm = new ATM();
        int option;
        do {
            System.out.println("\nMenú Principal:");
            System.out.println("1. Iniciar sesion");
            System.out.println("2. Salir");
            System.out.print("Ingrese la opción: ");
            option = src.nextInt();

            switch (option) {
                case 1: atm.logIn(); break;
                case 2: System.out.println("Sesión finalizada. ¡Hasta luego!"); break;
                default:  System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (option != 2);
    }
}