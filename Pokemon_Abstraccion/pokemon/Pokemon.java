package pokemon;

import java.util.ArrayList;

public abstract class Pokemon {
    private int HP, nivel;
    private String nombre;
    Tipo tipo;
    private Movimiento[] movimientos;
    
    public Pokemon(String nombre, Tipo tipo, int nivel) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
        this.HP = 250;
        this.movimientos = new Movimiento[4];
    }
    
    public int getHP() { 
        return HP; 
    }

    public String getNombre() { 
        return nombre; 
    }
    public Tipo getTipo() { 
        return tipo; 
    }

    public int getNivel() { 
        return nivel; 
    }

    private void calculaDanio(int danio, double efectividad) {
        double puntosRestados = danio * efectividad;
        this.HP -= puntosRestados;
        System.out.printf ("%s recibe %.2f puntos de danio\n", this.getNombre(), puntosRestados);
    }

    public void recibirAtaque(Movimiento movimiento, double efectividad) {
        System.out.printf("%s recibe ATK %s\n", this.getNombre(), movimiento.getNombre());
        calculaDanio(movimiento.getPuntosDeAtaque(), efectividad);
    }

    protected boolean seHaConcretadoAtaque(Movimiento movimiento, Pokemon pokemon) {
        System.out.printf("%s ataca a %s con %s\n", this.getNombre(),pokemon.getNombre(), movimiento.getNombre());
        double efectividad = obtenerEfectividad(pokemon);
        if (movimiento.getPp() > 0) {
            pokemon.recibirAtaque(movimiento, efectividad);
            return true;
        } else {
            System.err.println("El movimiento no tiene puntos de pp");
            return false;
        }
    }

    public void atacar(int m, Pokemon pokemon) {
        Movimiento movimiento = getMovimiento(m);
        boolean seHaConcretadoAtaque = seHaConcretadoAtaque(movimiento, pokemon);
        if(seHaConcretadoAtaque) {
            pokemon.getMovimiento(m).setPp(movimiento.getPp() - 1);
        }
       /* System.out.printf("%s ataca a %s con %s\n",
        this.getNombre(),pokemon.getNombre(), movimiento);
        pokemon.recibirAtaque(movimiento);*/
    }

    public abstract double obtenerEfectividad(Pokemon pokemon);

    //private ArrayList<Movimiento> movimientos = new ArrayList<>(); 

    public void setMovimiento(int indice, Movimiento movimientos) {
        this.movimientos[indice] = movimientos;
    }

    public Movimiento getMovimiento(int indice) {
        return movimientos[indice];
    }

    
}