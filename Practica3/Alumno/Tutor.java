public class Tutor {
    private String nombre;
    private int edad;
    Telefono telefono;

    public Tutor() {

    }

    public Tutor(String nombre, int edad, Telefono telefono) {
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }



    public Telefono getTelefono() {
        return telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }

     @Override
    public String toString() {
        return nombre + edad + telefono;
     }
}
