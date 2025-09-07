package Objetos;

public class Producto {
    private String codigo;
    private String descripcion;
    private int cantidad;
    private double precio;

    public Producto(String codigo, String descripcion, int cantidad, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getCodigo() { return codigo; }
    public String getDescripcion() { return descripcion; }
    public int getCantidad() { return cantidad; }
    public double getPrecio() { return precio; }

    public double getTotal() {
        return cantidad * precio;
    }

    public String toString() {
        return codigo + "\t" + descripcion + "\t" + cantidad + "\t" + precio + "\t" + getTotal();
    }
}