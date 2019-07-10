import java.text.DecimalFormat;

/**
 *Class that stores vehicle data and provides
 *methods to access the data.
 *
 *Project 4 (Vehicles)
 *@author Erika Yardumian - CPSC - 1213
 *@version 11/08/18
 */
public abstract class Vehicle implements Comparable<Vehicle> {
/**Creates Vehicle class.
  *@param args - Command line arguments - not used.
  */
  
  //Instance Variables
   protected String owner = "";
   protected String yearMakeModel = "";
   protected double value = 0.0;
   protected boolean alternativeFuel = false;
   protected static int vehicleCount;
  
  /**
   *Contructor to initiate variables.
   *@param ownerIn is InventoryItem
   *@param yearMakeModelIn is InventoryItem
   *@param valueIn is InventoryItem
   *@param alternativeFuelIn is InventoryItem
   */
   public Vehicle(String ownerIn, String yearMakeModelIn,
      double valueIn, boolean alternativeFuelIn) {
      setOwner(ownerIn);
      setYearMakeModel(yearMakeModelIn);
      setValue(valueIn);
      setAlternativeFuel(alternativeFuelIn);
      vehicleCount++;
   }
   /**
    *Method to get the owner.
    *@return owner
    */ 
   public String getOwner() {
      return owner;
   }
   /** 
    *Method to set the owner.
    *@param ownerIn is setOwner
    */
   public void setOwner(String ownerIn) {
      owner = ownerIn;
   }
   /**
    *Method to get the year, make, and model.
    *@return yearMakeModel
    */
   public String getYearMakeModel() {
      return yearMakeModel;
   }
  /**
   *Method to set the YearMakeModel.
   *@param yearMakeModelIn is setYearMakeModel
   */
   public void setYearMakeModel(String yearMakeModelIn) {
      yearMakeModel = yearMakeModelIn;
   }
  /**
   *Method to get the vehicle's value.
   *@return the value
   */
   public double getValue() {
      return value;
   }
  /**
   *Method to set the vehicle's value.
   *@param valueIn is setValue
   */
   public void setValue(double valueIn) {
      value = valueIn;
   }
   /**
   *Method to set the alternative fuel.
   *@param alternativeFuelIn is setAlternativeFuel
   */
   public void setAlternativeFuel(boolean alternativeFuelIn) {
      alternativeFuel = alternativeFuelIn;
   }
  /**
   *Method to determine if the car uses alternative fuel.
   *@return true or false
   */
   public boolean getAlternativeFuel() {
      return alternativeFuel;
   }
     /**
      *Method to get the vehicle count.
      *@return the vehicle count
      */
   public static int getVehicleCount() {
      return vehicleCount;
   }
     /**
      *Method to reset the vehicle count.
      */
   public static void resetVehicleCount() {
      vehicleCount = 0;
   }
     /**
      *Method to represent the total amount for the
      *vehicle's use tax.
      *@return null
      */
   public abstract double useTax();
    
   /**
    *Method to describe the vehicle.
    *@return null
    */
   public String toString() {
      DecimalFormat fmtr = new DecimalFormat("##,###.00");
      String output = "";
      if (this.getAlternativeFuel()) {
         output += this.getOwner() + ": " + this.getClass().getName()
              + " " + this.getYearMakeModel() + " (Alternative Fuel)\nValue: $" 
              + fmtr.format(this.getValue())
              + " Use Tax: $" + fmtr.format(this.useTax());
      }
      else {
         output += this.getOwner() + ": " + this.getClass().getName()
            + " " + this.getYearMakeModel() + "\nValue: $" 
            + fmtr.format(this.getValue())
            + " Use Tax: $" + fmtr.format(this.useTax());
      }
      return output;
   
   }
   /**
    *Method to compare vehicles.
    *@param obj the other object
    *@return boolean
    */
   public boolean equals(Object obj) {
      if (!(obj instanceof Vehicle)) {
         return false;
      }
      else {
         Vehicle other = (Vehicle) obj;
         return (owner + yearMakeModel + value).
               equalsIgnoreCase(other.owner + other.yearMakeModel
                  + other.value);  
      }
   }
   /** @return 0 */
   public int hashCode() {
      return 0;
   }
   
   /**
    *Method to compare vehicles.
    *@param objIn is compareTo
    *@return result
    */
   public int compareTo(Vehicle objIn) {
      int result;
      result = this.getOwner().compareTo(objIn.getOwner());
      return result;
   }
}