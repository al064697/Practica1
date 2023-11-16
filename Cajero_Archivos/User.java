package Cajero_Archivos;

import java.io.Serializable;
import java.util.Random;

// Clase que representa a un usuario del cajero automático
public class User implements Serializable {
    // Número de versión único para la serialización.
    // Se utiliza durante la deserialización para garantizar la compatibilidad de versiones.
    private static final long serialVersionUID = 1L;

    // Atributos que representan la información del usuario
    private String name;       // Nombre del usuario
    private int nip, balance;  // Número de identificación personal, y Saldo del usuario

    // Instancia de Random para generar saldos iniciales aleatorios
    private Random random = new Random();

    public User(String name, int nip) {
        this.name = name;
        this.nip = nip;
        // Genera un saldo inicial aleatorio entre 50000 y 1000
        this.balance = random.nextInt((50000 - 1000) + 1) + 1000;
    }

    // Método para obtener el nombre del usuario
    public String getName() {
        return name;
    }

    // Método para obtener el saldo actual del usuario
    public int getBalance() {
        return balance;
    }

    // Método para retirar efectivo del saldo del usuario
    public void withdrawCash(double amount) {
        balance -= amount;
    }
}
