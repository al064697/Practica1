package Cajero_Archivos;

import java.io.*;

// Clase que representa la información sobre los billetes
public class Cash implements Serializable {
    //Número de versión único para la serialización.
        // Este identificador se utiliza durante la deserialización para garantizar que el objeto serializado
         // y el objeto deserializado son compatibles en términos de versión.
    private static final long serialVersionUID = 1L;
    // Atributos que representan la denominación y cantidad de billetes
    private int type, amount;
    public Cash(int group, int amount) {
        this.type = group;
        this.amount = amount;
    }
    // Método para obtener la denominación del billete
    public int getType() {
        return type;
    }

    // Método para obtener la cantidad de billetes
    public int getAmount() {
        return amount;
    }

    // Método para establecer la cantidad de billetes
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
