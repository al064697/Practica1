package Cajero_Archivos;

import java.util.List;

public class InsufficientCashException extends Exception {
    static User user;
    static ATM atm;
    public InsufficientCashException() {
        super("ERROR. Billetes insuficientes en el cajero");
    }

    public static void verificarDisponibleBilletes(List<Cash> cash, int cantidad) throws InsufficientCashException {
        if (!verificarDisponibilidadBilletes(cash, cantidad)) {
            atm.logRegistry("retirar", user.getName(), cantidad, false);
            throw new InsufficientCashException();

        } else {
            System.out.println("Retiro exitoso. Nuevo saldo: $" + user.getBalance());
            atm.logRegistry("retirar", user.getName(), cantidad, true);
        }
    }

    private static boolean verificarDisponibilidadBilletes(List<Cash> cashList, int montoRestante) {

        for (Cash cash : cashList) {
            int denominacion = cash.getType();
            int cantidadBilletes = cash.getAmount();

            int billetesNecesarios = montoRestante / denominacion;

            int billetesAUsar = Math.min(billetesNecesarios, cantidadBilletes);

            if (billetesAUsar > 0) {
                montoRestante -= billetesAUsar * denominacion;
            }

            if (montoRestante == 0) {
                // Combinación de billetes
                cash.setAmount(cantidadBilletes - billetesAUsar);
                return true;
            }
        }
        return false;
    }
}
