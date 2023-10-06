package Pokemon_Herencia;

public class PokemonElectrico extends Pokemon {
    int HP, nivel;
    String nombre, tipo;
    
    public PokemonElectrico(String nombre, int nivel) {
        super(nombre, "Pokemon electrico", nivel);
    }

}