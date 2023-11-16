package Cajero_Archivos;

import java.io.Serializable;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// La clase Admin implementa la interfaz Serializable
public class Admin implements Serializable {
    // Nombre del archivo de registro de acciones
    private static final String FileNAME_TXT = "logs.txt";

    // Método que representa el menú de administrador
    public void adminMenu(ATM atm) {
        Scanner src = new Scanner(System.in);
        Admin admin = new Admin();

        // Mientras el modo administrador esté activo
        while (atm.isAdmin()) {
            System.out.println("\nModo Administrador:");
            System.out.println("1. Mostrar listado de acciones");
            System.out.println("2. Mostrar cantidad de billetes disponibles");
            System.out.println("3. Salir del modo administrador");
            System.out.print("Seleccione una opción: ");
            int option = src.nextInt();

            // Evaluar la opción seleccionada por el administrador
            switch (option) {
                case 1:
                    admin.showActions();
                    break;
                case 2:
                    admin.showAvailableBills(atm);
                    break;
                case 3:
                    atm.setAdminMode(false);
                    System.out.println("Saliendo del modo administrador.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }
    }

    // Método que muestra el listado de acciones (registros)
    public void showActions() {
        System.out.println("Listado de acciones:");
        showLogs();
    }

    // Método que muestra la cantidad de billetes disponibles utilizando el método de ATM
    public void showAvailableBills(ATM atm) {
        System.out.println("Cantidad de billetes disponibles:");
        atm.showAvailableBill();
    }

    // Método privado que muestra los registros almacenados en el archivo de logs
    private void showLogs() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FileNAME_TXT))) {
            String line;

            // Leer y mostrar cada línea del archivo de logs
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
