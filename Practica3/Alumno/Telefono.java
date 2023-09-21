public class Telefono {
    private String pais;
    private String lada;
    private String numero;

    public Telefono() {

    }

    public Telefono(String pais, String lada, String numero) {
        this.pais = pais;
        this.lada = lada;
        this.numero = numero;

    }

    public String getPais() {
        return pais;
    }

    public String getLada() {
        return lada;
    }

    public String getnumero(){
        return numero;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setLada() {
        this.lada = lada;
    }

    public void setNumero() {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return pais + lada + numero;
    }


}
