package Objetos;

public class Fecha {

    private int dia;
    private int mes;
    private int anio;

    // Constructor
    public Fecha(int pDia, int pMes, int pAnio) {
        setDia(pDia);
        setMes(pMes);
        setAnio(pAnio);
    }

    public void setDia(int pDia) {
        dia = pDia;
    }

    public int getDia() {
        return dia;
    }

    public void setMes(int pMes) {
        mes = pMes;
    }

    public int getMes() {
        return mes;
    }

    public void setAnio(int pAnio) {
        anio = pAnio;
    }

    public int getAnio() {
        return anio;
    }

    public String toString() {
        return dia + "/" + mes + "/" + anio;
    }
}