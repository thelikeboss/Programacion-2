package Polimorfismo;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("¿Qué área deseas calcular?");
        System.out.println("1. Cuadrado");
        System.out.println("2. Triángulo");
        System.out.print("Elige una opción (1 o 2): ");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                System.out.print("Ingresa el lado del cuadrado: ");
                double lado = sc.nextDouble();
                Cuadrado cuadrado = new Cuadrado(lado);
                System.out.println("Area del cuadrado: " + cuadrado.getArea());
                System.out.println(cuadrado.toString());
                break;
            case 2:
                System.out.print("Ingresa la base del triángulo: ");
                double base = sc.nextDouble();
                System.out.print("Ingresa la altura del triángulo: ");
                double altura = sc.nextDouble();
                Triangulo triangulo = new Triangulo(base, altura);
                System.out.println("Area del triángulo: " + triangulo.getArea());
                System.out.println(triangulo.toString());
                break;
            default:
                System.out.println("Opción no valida.");
        }
        sc.close();
    }
}
