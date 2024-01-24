import javax.swing.*;
/* Name: Ayesha Afia
Course: IT206-002
Date: 4/19/2023
Assignment: Final Project


*/

public class GardenBedExample {

public static void main(String[] args){
  GardenBed[] gardenBeds = new GardenBed[10];//array to hold garden beds
  
  String gardenList = "";
  String optionString = "";
  int option = 0;
  String gardenType = "";
  boolean notExit = true;

  while (notExit) {
    
  //Ask user what they want to do
    optionString = JOptionPane.showInputDialog("**Garden Planner** "
    +"\n1. Add Garden Bed"
    +"\n2. Remove Garden Bed"
    +"\n3. Print Garden Bed List"
    +"\n4. Print Cost Report"
    +"\n5. Quit"
    +"\nEnter your choice: ");

    if (isInteger(optionString)) {
      option = Integer.parseInt(optionString);
    } else {
      option = 0; //Makes the program return invalid option
    }

    if (option == 1){
    //Find empty space to add garden bed
      int place = -1;
      for(int i = 0; i < gardenBeds.length; i ++){
        if(gardenBeds[i]== null){
          place = i;
          break;
        }
      }
      if(place < 0 || place > 9){
        JOptionPane.showMessageDialog(null, "Your garden beds are all full."); //error message if there are no empty spaces
      } else {
      //Ask user for seed information
        gardenType = JOptionPane.showInputDialog("Do you want this garden bed to have flower seeds or normal?"
            +"Type \"y\" for flower seeds and anything else for normal seeds:"); //decide if seeds are flower type or not
        //Get seed information
        String name = JOptionPane.showInputDialog("Please enter seed name:");
        int seedAmount= Integer.parseInt(JOptionPane.showInputDialog("Please enter number of seeds:"));
        int duration = 0;
       //Ask for duration amount if garden bed is flower bed
        if(gardenType.equalsIgnoreCase("y")){
           duration = Integer.parseInt(JOptionPane.showInputDialog("Please enter flower season duration (in weeks):"));
        }
         
        
        //Create new seeds  or flower seeds based on user input
        try {
          if(gardenType.equalsIgnoreCase("y")){
            gardenBeds[place] = new FlowerBed(name, seedAmount, duration);
          } else {
            gardenBeds[place] = new GardenBed(name, seedAmount);
          }
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, e);
        } 
          
          
        }
      }
    
  
    //Option to remove a garden bed
    if (option == 2){
    //Show garden list containing all garden beds
       gardenList = "Garden Planner: choose a bed to remove:" 
      +"\nSeed name | Number | Water(gallons)| Subtotal\n"; //generate garden list
      for(int i = 0; i < gardenBeds.length; i ++){
        if(gardenBeds[i] == null){
         gardenList += (i+1) +". " +"empty"+"\n";
        }else{
          gardenList += (i+1) +". " + gardenBeds[i].toString()+"\n";
        }
      }
      //Ask user which bed they want to delete
      int placeToBeDeleted = Integer.parseInt(JOptionPane.showInputDialog(gardenList));
      placeToBeDeleted--;
      if (placeToBeDeleted >= 0 && placeToBeDeleted <= 9) {
        gardenBeds[placeToBeDeleted] = null;
        JOptionPane.showMessageDialog(null, "Garden Bed " + (placeToBeDeleted+1) + " has been deleted." );
      } else {
        JOptionPane.showMessageDialog(null, "Number not in range 1 to 10, try again.");
      }
      
      
    }
    

    if (option == 3){
      //Show garden list containing all garden beds
         gardenList = "Garden Planner: choose a bed to remove:" 
        +"\nSeed name | Number | Water(gallons)| Subtotal\n"; //generate garden list
        for(int i = 0; i < gardenBeds.length; i++){
          if(gardenBeds[i] == null){
           gardenList += (i+1) +". " +"empty"+"\n";
          }else{
            gardenList += (i+1) +". " + gardenBeds[i].toString()+"\n";
          }
        }
        
        JOptionPane.showMessageDialog(null, gardenList); 
    }

    //Option to print garden bed cost
    if (option == 4){
      int bedCounter = 0;
      double total = 0.0;
      double totalWaterAmount = 0.0;
      gardenList = "**Garden Planner**"
        +"\nSeed name | Number | Water(gallons) | Subtotal\n";
      for(int i = 0; i < gardenBeds.length; i ++){
        if(gardenBeds[i] == null){
          gardenList += (i+1) +". " +"empty"+"\n";
        }else{
          gardenList += (i+1) +". " + gardenBeds[i].toString()+"\n";
          bedCounter++;
          total += gardenBeds[i].getSubtotal();
          totalWaterAmount += gardenBeds[i].getWaterTotal();
        }
      }
      // Display number of garden beds and combined subtotal
      gardenList += "\n Number of garden beds: " + bedCounter
        +"\n Total gallons of water: " + totalWaterAmount
        +"\n Combined Total Cost: $" + total;

      JOptionPane.showMessageDialog(null, gardenList);

    }
    
    //Exit program if user chooses to
    if (option == 5){
      notExit=false;
    }

    if (option < 1 && option > 5){
      JOptionPane.showMessageDialog(null, "Invalid option!");
    }

    }  
   }
  
   public static boolean isInteger(String str) {
    try {  
        Integer.parseInt(str);  
        return true;
    } catch (NumberFormatException e) {  
        return false;  
        }  
      }
  
   }
   




    
     