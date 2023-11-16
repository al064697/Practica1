package Cajero_Archivos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATM {
    private boolean AdminProfileStatus = false;    // Estado del perfil de administrador
    static Scanner src = new Scanner(System.in);
    private User user;
    private static final String FILENAME_BIN = "billetes.dat", FileNAME_TXT = "logs.txt"; //Nombres de los archivos para datos de billete y registro
    List<Cash> cash;     // Lista que contiene información sobre los billetes disponibles

    public ATM() {
        // Cargar datos iniciales y realizar inicio de sesión
        loadInitialCash();
        logIn();
    }
    // Método para cargar datos iniciales de billetes
    public void loadInitialCash() {
        File file = new File(FILENAME_BIN);
        if (file.exists() && !file.isDirectory()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                // Cargar la lista de billetes desde el archivo
                cash = (List<Cash>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                // Manejar posibles errores al cargar el archivo
                e.printStackTrace();
            }
        } else {
            initializeDefaultCash();    // Si el archivo no existe, inicializar billetes predeterminados y guardarlos

        }
    }
    // Método privado para inicializar billetes predeterminados y guardarlos
    private void initializeDefaultCash() {
        cash = new ArrayList<>();
        cash.add(new Cash(100, 100));
        cash.add(new Cash(200, 100));
        cash.add(new Cash(500, 20));
        cash.add(new Cash(1000, 10));
        saveCash();
    }
    // Método para guardar datos de billetes en un archivo
    public void saveCash() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME_BIN))) {
            oos.writeObject(cash);
        } catch (IOException e) {
            //Stacktracem: Permite mostrar el nombre de una excepción junto con el mensaje que devuelve getMessage()
            e.printStackTrace();
        }
    }
    // Método para realizar el inicio de sesión
    public void logIn() {
        System.out.print("Ingrese su nombre de usuario: ");
        String nombre = src.next();
        System.out.print("Ingrese su NIP de 4 digitos: ");
        int nip = src.nextInt();
        // Verificar si es el administrador
        if (nombre.equals("admin") && nip == 3243) {
            AdminProfileStatus = true;
            adminMode();
        } else {
            cashierMode(nombre, nip);
        }
    }
    // Método para mostrar el monto mínimo que se puede retirar
    public void showBillMin() {
        int minAmmount = cash.stream().mapToInt(billete -> billete.getType() * billete.getAmount()).sum();
        System.out.println("Monto mínimo para retirar: $" + minAmmount);
    }
    // Método para entrar al modo cajero y realizar operaciones como usuario
    public void cashierMode(String name, int nip) {
        user = new User(name, nip);
        System.out.println("¡Bienvenido al modo cajero, " + name + "!");
        System.out.println("Saldo actual: $" + user.getBalance());
        cashierMenu();
    }
    // Menú de operaciones disponibles para el modo cajero
    private void cashierMenu() {
        int option;
        do {
            showAvailableBill();
            showBillMin();
            System.out.println("\nMenú Cajero Automático:");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Retirar efectivo");
            System.out.println("3. Salir");
            System.out.print("Ingrese una opcion: ");
            option = src.nextInt();
            switch (option) {
                case 1:
                    System.out.println(getBalance());
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad a retirar: ");
                    int withdrawalAmmount = src.nextInt();
                    withdrawCash(withdrawalAmmount);
                    break;
                case 3:
                    System.out.println("Sesión finalizada.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (option != 3);
    }
    // Método para entrar al modo administrador
    private void adminMode() {
        Admin administrador = new Admin();
        administrador.adminMenu(this);
    }
    // Método para consultar el saldo actual
    public String getBalance() {
        return "Saldo actual: $" + user.getBalance();
    }
    // Método para realizar el retiro de efectivo
    public void withdrawCash(int ammount) {
        if (ammount > 0 && ammount <= user.getBalance()) {
            if (availableBillVerify(ammount)) {
                // Realizar la operación de retiro
                user.withdrawCash(ammount);
                uploadAvailableCash(ammount);

                System.out.println("Retiro exitoso. Nuevo saldo: $" + user.getBalance());
                logRegistry("retirar efectivo", user.getName(), ammount, true);
            } else {
                System.out.println("La cantidad solicitada no puede ser cubierta debido a la " +
                        "insuficiencia de billetes disponibles.");
                logRegistry("retirar efectivo", user.getName(), ammount, false);
            }
        } else {
            System.out.println("No se puede realizar el retiro. Verifique el monto ingresado.");
            logRegistry("retirar efectivo", user.getName(), ammount, false);
        }
    }
    // Método para verificar si hay suficientes billetes disponibles para un retiro específico
    public boolean availableBillVerify(int amount) {
        for (Cash cash : cash) {
            int type = cash.getType();
            int amountCash = cash.getAmount();
            int necesaryCash = amount / type;
            int billetesAUsar = Math.min(necesaryCash, amountCash);
            if (billetesAUsar > 0) {
                amount -= billetesAUsar * type;
            }
            if (amount == 0) {
                // Combinación de billetes
                cash.setAmount(amountCash - billetesAUsar);
                return true;
            }
        }
        return false;
    }
    // Método para actualizar la cantidad de billetes disponibles después de un retiro
    public void uploadAvailableCash(int amountWithoutCash) {
        for (Cash cash : cash) {
            int type = cash.getType();
            int amountCash = cash.getAmount();
            int billetesUtilizados = (amountWithoutCash / type);
            amountWithoutCash -= billetesUtilizados * type;
            cash.setAmount(amountCash - billetesUtilizados); // Actualizar la cantidad de billetes disponibles

        }
        saveCash();//Guardar los nevos billetes disponibles
    }
    // Método para registrar operaciones en un archivo de registro
    public void logRegistry(String action, String user, double balance, boolean done) {
        //BufferedWriter: Permite escribir en un archivo de texto
        //Se puede utilizar igual PrintWriter
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileNAME_TXT, true))) {
            String logEntry = action + "," + user + "," + balance + "," + (done? "SI" : "NO");
            writer.write(logEntry);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Método para mostrar la cantidad de billetes disponibles
    public void showAvailableBill() {
        System.out.println("Billetes disponibles:");

        for (Cash cash : this.cash) {
            int denominacion = cash.getType();
            int cantidadBilletes = cash.getAmount();

            System.out.println("$" + denominacion + ": " + cantidadBilletes + " billetes");
        }
    }
    // Método para verificar si el usuario actual tiene privilegios de administrador
    public boolean isAdmin() {
        return AdminProfileStatus;
    }
    // Método para establecer el estado del modo administrador
    public void setAdminMode(boolean isAdminMode) {
        this.AdminProfileStatus = isAdminMode;
    }
}