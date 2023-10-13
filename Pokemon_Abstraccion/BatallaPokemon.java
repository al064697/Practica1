import pokemon.PokemonAgua;
import pokemon.PokemonElectrico;

public class BatallaPokemon {
    public static void main(String[] args) {
        PokemonAgua pokemonAgua = new PokemonAgua("Blastoise", 10);
        PokemonElectrico pokemonElectrico = new PokemonElectrico("Pikachu", 10);
        //Pikachu ataca
        pokemonElectrico.atacar(1, pokemonAgua);
        System.out.println("HP = " + pokemonAgua.getHP());
        //Blastoise ataca
        pokemonAgua.atacar(2, pokemonElectrico);
        System.out.println("HP = " + pokemonElectrico.getHP());
    }    
}
