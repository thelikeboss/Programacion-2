package Accesos;

public  class Perro extends Animal{
    private boolean pulgas;
    public Perro(int patas, int ojos , boolean pulgas) {
        super(patas, ojos);
        this.pulgas=pulgas;
    }
    public void setPulgas(boolean pulgas){
        this.pulgas = pulgas;

    }
    
    public boolean getPulgas(){
        return pulgas;
    }
    public void cambiaPadre(){
        this.patas=3;
        setOjos(2);
        setPatas(3);
        
    }
     public static void main(String args[]){
        Perro miPerro= new Perro(4,2,true);
        System.out.println(miPerro.habla());
        System.out.println("Patas: "+miPerro.getPatas());
        System.out.println("Ojos: "+miPerro.getOjos());
        System.out.println("Pulgas: "+miPerro.getPulgas());
    }


}
