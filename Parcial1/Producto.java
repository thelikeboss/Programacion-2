package Parcial1;

public class Producto {

    private String codigo;
    private String descripcion;
    private double precioUnitario;

    public Producto(String codigo, String descripcion, double precioUnitario) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void mostrarInfo() {
        System.out.println("Producto: " + codigo + ", Descripción: " + descripcion + ", Precio Unitario: " + precioUnitario);
    }

    public static void main(String[] args) {
        Producto producto1 = new Producto("L001", "Laptop", 1500.00);
        Producto producto2 = new Producto("S002", "Smartphone", 800.00);
        Producto producto3 = new Producto("P003","Ps5",5000.89);
        Producto producto4 = new Producto("T004","Tableta",1000.68);
        Producto producto5 = new Producto("R005","Reloj Digital",2500.99);

        producto1.mostrarInfo();
        producto2.mostrarInfo();
        producto3.mostrarInfo();
        producto4.mostrarInfo();
        producto5.mostrarInfo();
    }
}