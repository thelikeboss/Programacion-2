package Objetos;

import java.util.Scanner;

public class Vehiculo

{

  private String marca;

  private String modelo;

  private Motor motor;

  public Vehiculo(String pMarca, String pModelo)

  {

    setMarca(pMarca);
    setModelo(pModelo);
  }

  public void setMarca(String pMarca)

  {
    marca = pMarca;
  }

  public String getMarca()

  {
    return marca;
  }

  public void setModelo(String pModelo)

  {
    modelo = pModelo;
  }

  public String getModelo()

  {
    return modelo;
  }

  public void setMotor(Motor pMotor)

  {
    motor = pMotor;
  }

  public String getMotor()

  {
    return motor.toString();
  }

  public String toString()

  {

    return "Vehiculo : " + marca + ", Modelo :" + modelo + "\n";

  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Ingrese la marca del vehículo: ");
    String marca = scanner.nextLine();

    System.out.print("Ingrese el modelo del vehículo: ");
    String modelo = scanner.nextLine();

    Vehiculo vehiculo = new Vehiculo(marca, modelo);

    Motor motor = new Motor();
    System.out.print("Ingrese el VIN del motor: ");
    motor.setVin(scanner.nextLine());

    System.out.print("Ingrese la cantidad de cilindros del motor: ");
    motor.setCilindros(scanner.nextLine());

    vehiculo.setMotor(motor);

    System.out.println(vehiculo.toString());
    System.out.println(vehiculo.getMotor());

    scanner.close();
  }
}