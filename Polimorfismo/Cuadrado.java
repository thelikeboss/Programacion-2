package Polimorfismo;

public class Cuadrado  extends FiguraGeometrica {
    private double lado;

    public Cuadrado(double lado) {
        super("Cuadrado");
        this.lado = lado;
        calcularArea();
        calcularPerimetro();
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
        calcularArea();
        calcularPerimetro();
    }

    private void calcularArea() {
        double area = lado * lado;
        setArea(area);
    }

    private void calcularPerimetro() {
        double perimetro = 4 * lado;
        setPerimetro(perimetro);
    }

    @Override
    public String toString() {
        return "Cuadrado{" +
                "lado=" + lado +
                ", area=" + getArea() +
                ", perimetro=" + getPerimetro() +
                '}';
    }

    
}
