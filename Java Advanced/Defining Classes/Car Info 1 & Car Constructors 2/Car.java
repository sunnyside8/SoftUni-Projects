import java.util.Objects;

public class Car {
   private String brand;
   private String model;
   private int horsePower;

   public Car(String brand,String model,int horsePower){
      this.brand = brand;
      this.model = model;
      this.horsePower = horsePower;
   }
   public Car(String brand,String model){
      this(brand,model,-1);
   }

   public Car(String brand,int horsePower){
      this(brand,"unknown",horsePower);
   }
   public Car(String brand){
      this(brand,"unknown",-1);
   }

   public String getBrand(){
      return brand;
   }

   public String getModel(){
      return model;
   }
   public int getHorsePower(){
      return horsePower;
   }

   public void setHorsePower(int hp){
      this.horsePower = horsePower;
   }

   @Override
   public String toString(){
      return  String.format("The car is: %s %s - %d HP." ,this.getBrand(),this.getModel(),this.getHorsePower());
   }

}
