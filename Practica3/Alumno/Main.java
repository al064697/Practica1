public class Main {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final char newLine = '\n';



    public static void main(String[] args) {

        Telefono phone = new Telefono("+52-", "55-", "1234-5678");

        Tutor tutor = new Tutor();
        tutor.setNombre("Santiago de la Vega");
        tutor.setEdad(46);
        tutor.setTelefono(phone);

        Alumno alumno = new Alumno();
        alumno.setNombre("Alejandro Mendoza");
        alumno.setCarrera("ISC");
        alumno.setMatricula(64697);
        alumno.setGrado(3);
        alumno.setGrupo("B");
        alumno.setTutor(tutor);

        String telefono = alumno.getTutor().getTelefono().toString();

        String mensaje = newLine + "El numero de telefono del tutor de " + ANSI_RED + alumno.getNombre() +
                ANSI_WHITE + ", llamado " + ANSI_RED + alumno.getTutor().getNombre() + ANSI_WHITE + " es: " +
                ANSI_RED + telefono + ANSI_WHITE;

        System.out.println(mensaje);
    }
}
