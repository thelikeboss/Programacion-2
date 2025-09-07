package arreglos;

public class listaEmpleado {
    public static void main(String[] args) {
        Empleado lisEmpleado[]= new Empleado[3];
        lisEmpleado[0] = new Empleado("juan", 50, 5000);
        lisEmpleado[1] = new Empleado("juan", 150, 15000);
        lisEmpleado[2] = new Empleado("juan", 250, 25000);
    
        for (Empleado e: lisEmpleado){
            System.out.println(e.datos());
        }
    }
    
}
