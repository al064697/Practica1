package pokemon;

public class PokemonAgua extends Pokemon {
    int HP, nivel;
    String nombre, tipo;
    
    public PokemonAgua(String nombre, int nivel) {
        super(nombre, Tipo.AGUA, nivel);
        ListaMovimientos listaMovimientos = new ListaMovimientos();
        setMovimiento(0, listaMovimientos.buscarMovimientoPorNombre("Placaje"));
        setMovimiento(1, listaMovimientos.buscarMovimientoPorNombre("Foco resplandor"));
        setMovimiento(2, listaMovimientos.buscarMovimientoPorNombre("Pistola de agua"));
        setMovimiento(3, listaMovimientos.buscarMovimientoPorNombre("Mordisco"));
    }

    @Override public double obtenerEfectividad(Pokemon pokemon) {
        return 1.0;
    }

}