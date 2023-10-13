package pokemon;

public class PokemonElectrico extends Pokemon{
    int HP, nivel;
    String nombre, tipo;


    public PokemonElectrico(String nombre, int nivel) {
        super(nombre, Tipo.ELECTRICO, nivel);
        ListaMovimientos listaMovimientos = new ListaMovimientos();
        setMovimiento(0, listaMovimientos.buscarMovimientoPorNombre("Moflete estatico"));
        setMovimiento(1, listaMovimientos.buscarMovimientoPorNombre("Impactrueno"));
        setMovimiento(2, listaMovimientos.buscarMovimientoPorNombre("Chispa"));
        setMovimiento(3, listaMovimientos.buscarMovimientoPorNombre("Cola ferrea"));
    }

    @Override public double obtenerEfectividad(Pokemon pokemon) {
        double efectividad = 1.0;
        if (pokemon.getTipo() == Tipo.TIERRA)efectividad = 0.0;
        if(pokemon.getTipo() == Tipo.AGUA) efectividad = 2;
        return efectividad;
    }
}
