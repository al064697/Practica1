

public class Alumno {
    //atributos
    private String nombre, carrera;
    private int matricula, grado;
    private String grupo;
    private Tutor tutor;

    //constructores
    public Alumno() {
    }

    public Alumno(String nombre) {
        this.nombre = nombre;
    }

    //Definiendo constructor de forma completa
    public Alumno(String nombre, String carrera, int matricula, int grado, String grupo, Tutor tutor) {
        this.nombre = nombre;
        setCarrera(carrera);
        this.matricula = matricula;
        this.grado = grado;
        this.grupo = grupo;
        this.tutor = tutor;
    }

    //Definiendo getter()'s
    public String getNombre() {
        return nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public int getMatricula() {
        return matricula;
    }

    public int getGrado() {
        return grado;
    }

    public String getGrupo() {
        return grupo;
    }

    public Tutor getTutor() {
        return tutor;
    }

    //Definiendo setter()'s
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCarrera(String carrera) {
        carrera = carrera.toUpperCase(); // x.toUpperCase -> convierte toda la cadena str en mayusculas

        //Definiendo un switch()/case
        switch(carrera) {

            //Definiendo el nuevo valor de la variable por cases
            case "ISC":
                this.carrera = "Ingeniero en Sistemas Computacionales";
                break;

            case "ICA":
                this.carrera = "Ingeniero Civil y Administracion";
                break;

            case "ITS":
                this.carrera = "Ingeniero en Tecnologia y Software";
                break;

            case "IM":
                this.carrera = "Ingeniero en Mecatronica";
                break;

            default:
                this.carrera = "Ingeniero";
                break;
        }
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", carrera='" + carrera + '\'' +
                ", matricula=" + matricula +
                ", grado=" + grado +
                ", grupo='" + grupo + '\'' +
                '}';
    }

    //metodos

}
