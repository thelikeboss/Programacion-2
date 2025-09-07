package arreglos;
import java.util.ArrayList;
public class arregloEmpleado {
 public static void main(String []args){
    ArrayList <Empleado> listaEmpleados = new ArrayList<Empleado>();
    
    listaEmpleados.ensureCapacity(11);
    listaEmpleados.add(new Empleado("juan", 50, 7000));
    listaEmpleados.add(new Empleado("juan", 150, 17000));
    listaEmpleados.add(new Empleado("juan", 250, 27000));

    listaEmpleados.trimToSize();
    System.out.println(listaEmpleados.size());

    for (Empleado e: listaEmpleados){
        System.out.println(e.datos());
    }


}   
}
