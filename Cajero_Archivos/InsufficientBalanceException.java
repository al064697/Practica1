package Cajero_Archivos;

public class InsufficientBalanceException extends Exception{
    public InsufficientBalanceException() {
        super("ERROR. Saldo insuficiente");
    }
    public static void NegativeBalanceMessage(int saldo) throws InsufficientBalanceException{
        if(saldo < 0) throw new InsufficientBalanceException();
    }
}
