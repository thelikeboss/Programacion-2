package Accesos;

public class Loro extends Animal {

    public Loro(int patas, int ojos){
        super(patas, ojos);

    }
    public String habla(){
        return "Soy un Loro y " + super.habla();
    }
        public static void main(String args[]){
        Loro miLoro= new Loro(2,2);
        System.out.println(miLoro.habla());
        System.out.println("Patas: "+miLoro.getPatas());
        System.out.println("Ojos: "+miLoro.getOjos());
    }
}
