/*
David Alfaro
IT-206
Final Project
*/

public class GardenBed
{
   //Instance Variables
   private String name;
   private int seedAmount;
   //Constants
   static final double SEED_COST = 0.02;
   static final double WATER_CONSTANT = 0.623;
   
   //Default Constructor
   public GardenBed()
   {
   
   }
   
   //Garden Bed Constructor
   public GardenBed(String name, int seedAmount)
   {
      if (name == null || name.equals(""))
      {
         throw new IllegalArgumentException("Seed name must be provided");      //make sure name is not empty
      }
      
      this.name = name;
      this.seedAmount = seedAmount;
   }
   
   
   //Accessors
   public String getname()
   {
      return this.name;
   }
   
   public int getseedAmount()
   {
      return this.seedAmount;
   }
   
   
   //Setters
   public boolean setName(String name)
   {
      if(!name.equals(""))
      {
         this.name = name;
         return true;
      }
      else
      {
         return false;
      }
   }
   
   public boolean setseedAmount(int seedAmount)
   {
      if(!(seedAmount == 0) && !(seedAmount < 0))
      {
         this.seedAmount = seedAmount;
         return true;
      }
      else
      {  
         return false;
      }
   }
   
  //Create string used for report
      public String toString() {
         return this.getname() + " | "+ this.getseedAmount() +  " | " + this.getWaterTotal() + " | $" + this.getSubtotal();
       }
   
   //Calculate cost of seeds
   public double getSubtotal() 
   {
     return seedAmount * SEED_COST;
   }
   //Calculate amount of water required
   public double getWaterTotal() 
   {
     return seedAmount *  WATER_CONSTANT;
   }
}