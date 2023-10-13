package pokemon;

import java.util.ArrayList;

public class ListaMovimientos {
    private ArrayList<Movimiento> movimientos = new ArrayList<>();

    public ListaMovimientos() {
        //Pikachu
        //Movimiento de tipo ELECTRICO
        movimientos.add(new Movimiento("Moflete estatico", 20, 20, Tipo.ELECTRICO));
        movimientos.add(new Movimiento("Impactrueno", 40, 30, Tipo.ELECTRICO));
        movimientos.add(new Movimiento("Chispa", 65, 20, Tipo.ELECTRICO));
        //Movimiento de tipo ACERO
        movimientos.add(new Movimiento("Cola ferrea", 100, 15, Tipo.ACERO));
        //Blastoise
        //Movimientos de tipo NORMAL
        movimientos.add(new Movimiento("Placaje", 40, 35,Tipo.NORMAL));
        //Movimientos de tipo ACERO
        movimientos.add(new Movimiento("Foco resplandor", 80, 10, Tipo.ACERO));
        //Movimientos de tipo AGUA
        movimientos.add(new Movimiento("Pistola de agua", 40, 25, Tipo.AGUA));
        //Movimiento de tipo SINIESTRO
        movimientos.add(new Movimiento("Mordisco", 60, 25, Tipo.SINIESTRO));
    }

        public Movimiento buscarMovimientoPorNombre (String nombre) {
            for(Movimiento movimiento : movimientos) {
                if(movimiento.getNombre().equals(nombre)) {
                    return movimiento;
                }
            }
            return null;
        }
}
