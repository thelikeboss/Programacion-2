package Polimorfismo;

public class FiguraGeometrica {
    private String nombreFigura;
    private double area;
    private double perimetro;

    public FiguraGeometrica(String nombreFigura) {
        this.nombreFigura = nombreFigura;
    }

    public String getNombreFigura() {
        return nombreFigura;
    }

    public void setNombreFigura(String nombreFigura) {
        this.nombreFigura = nombreFigura;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(double perimetro) {
        this.perimetro = perimetro;
    }

    @Override
    public String toString() {
        return "FiguraGeometrica{" +
                "nombreFigura='" + nombreFigura + '\'' +
                ", area=" + area +
                ", perimetro=" + perimetro +
                '}';
    }

}