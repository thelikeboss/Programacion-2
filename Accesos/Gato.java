package Accesos;

public class Gato extends Animal {

    public Gato (int patas , int ojos){
        super(patas,ojos);
    }
    
    public String habla(){
        return "Soy un Gato";
    }

    @Override
    public Gato clone() {
        return (Gato) super.clone();
    }

    public static void main(String args[]){
        Gato miGato= new Gato(4,2);
        Gato clonGato = miGato.clone();
        System.out.println(clonGato.habla());
        System.out.println("Patas: "+clonGato.getPatas());
        System.out.println("Ojos: "+clonGato.getOjos());
    }
}
