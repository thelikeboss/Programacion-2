package Objetos;


public class Motor { 


private String vin; 

private String cilindros; 


public void setVin (String pVin) 

{ vin = pVin; }

 

public String getVin () 

{ return vin; }

 

public void setCilindros (String pCilindros) 

{ cilindros = pCilindros; }

 

public String getCilindros () 

{ return cilindros; }

 

public String toString () 

{ return "Motor : " + vin + ", Cilindros :" + cilindros + "\n"; }

public static void main(String[] args) {
        Motor motor = new Motor();
        motor.setVin("1HGCM82633A123456");
        motor.setCilindros("4");
        System.out.println(motor.toString());
}
}