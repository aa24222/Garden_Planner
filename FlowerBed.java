public class FlowerBed extends GardenBed {

   //Instance variables
    private int duration;
    //Constant
    static final double WEEKS_COST = 30.0; 
  
    //Constructors
    public FlowerBed(String name, int seedAmount, int duration) {
      super(name, seedAmount);
  
      if (duration > 0) {
        this.duration = duration;
      }
      else {
        throw new IllegalArgumentException("Invalid season duration.");
      }
    }
    
    

  //Accessors-----------------------------------------------------------------------------------
  
    public double getDuration() {
      return this.duration;
    }
    
    //Mutators ----------------------------------------------------------------
    
    public void setDuration(int duration) {
      if (duration > 0) {
        this.duration = duration;
      }
      else {
        throw new IllegalArgumentException("Invalid warranty duration");
      }
    }
   
    //special purpose methods -------------------------------------------

    public double getSubtotal() //calculate cost of seeds
   {
     return (duration* WEEKS_COST) / this.getseedAmount(); //flower season affects cost
   } 
   //create string used for report 
   public String toString() {
    return this.getname() + " | "+ this.getseedAmount() +  " | " + duration + " | " + this.getWaterTotal()  + " | $" + this.getSubtotal();
  }

    //Override
    public double getWaterTotal() {    //this will return the water total
        return super.getWaterTotal();
      }
  }