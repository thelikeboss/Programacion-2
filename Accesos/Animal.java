package Accesos;

public class Animal implements Cloneable {
   protected int patas;
   private int ojos;
   
   public Animal(int patas , int ojos ){
    this.patas= patas;
    this.ojos= ojos;
   }

   public void setPatas(int patas){
        this.patas= patas;
   }    

   public int getPatas(){
    return patas;
   }

   public void setOjos(int ojos){
    this.ojos= ojos;
   }

   public int getOjos(){
    return ojos;
   }

   public String habla(){
    return "soy un animal";
   }

   @Override
   public Animal clone() {
       try {
           return (Animal) super.clone();
       } catch (CloneNotSupportedException e) {
           throw new AssertionError();
       }
   }
}
