package Arreglos;

public class Empleado {
    String nombre;
    int edad;
    double salario;

public String getNombre(){
    return nombre;
}

public void setNombre(String nombre){
    this.nombre = nombre;
}

public int getEdad(){
    return edad;
}

public void setEdad(int edad){
    this.edad = edad;
}

public double getSalario(){
    return salario;
}

public void setSalario(Double salario){
    this.salario = salario;
}

public Empleado(String pnombre, int pedad, double psalario){
    this.nombre=pnombre;
    this.edad=pedad;
    this.salario=psalario;

}

public String datos(){
    return "el empleado " + nombre + " tiene " + edad + " de edad Y un salario de " + salario ;
}



}
