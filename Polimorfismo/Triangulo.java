package Polimorfismo;

public class Triangulo extends FiguraGeometrica {
    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        super("Triángulo");
        this.base = base;
        this.altura = altura;
        calcularArea();
        calcularPerimetro();
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
        calcularArea();
        calcularPerimetro();
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
        calcularArea();
        calcularPerimetro();
    }

    private void calcularArea() {
        double area = (base * altura) / 2;
        setArea(area);
    }

    private void calcularPerimetro() {
        // Suponiendo triángulo equilátero
        double perimetro = 3 * base;
        setPerimetro(perimetro);
    }

    @Override
    public String toString() {
        return "Triangulo{" +
                "base=" + base +
                ", altura=" + altura +
                ", area=" + getArea() +
                ", perimetro=" + getPerimetro() +
                '}';
    }
}