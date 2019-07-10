import java.text.DecimalFormat;

/**
 *Subclass of Vehicle class.
 *
 *Project 4 (Vehicles-Car.java)
 *@author Erika Yardumian - CPSC - 1213
 *@version 11/08/18
 */
public class Car extends Vehicle {
/**Creates Car class.
  *@param args - Command line arguments - not used.
  */
  /**Instance variables.*/
   public static final double TAX_RATE = 0.01;
  /**Instance variables.*/
   public static final double ALTERNATIVE_FUEL_TAX_RATE
      = 0.005;
  /**Instance variables.*/
   public static final double LUXURY_THRESHOLD = 50000;
  /**Instance variables.*/
   public static final double LUXURY_TAX_RATE = 0.02;
  
   /**
    *Constructor to initialize variables.
    *@param ownerIn is Car
    *@param yearMakeModelIn is Car
    *@param valueIn is Car
    *@param alternativeFuelIn is Car
    *@throws NegativeValueException here
    */
   public Car(String ownerIn, String yearMakeModelIn, double valueIn,
      boolean alternativeFuelIn) throws NegativeValueException {
      super(ownerIn, yearMakeModelIn, valueIn, alternativeFuelIn);
      
      if (value < 0) {
         vehicleCount--;
         throw new NegativeValueException();
      }
   }
 /**
  *Method to calculate the tax.
  *@return tax
  */ 
   public double useTax() {
      double tax = 0.0;
      if (alternativeFuel) {
         tax = (value * ALTERNATIVE_FUEL_TAX_RATE);
      }
      else {
         tax = (value * TAX_RATE);      
      }
      if (value >= LUXURY_THRESHOLD) {
         tax += (value * LUXURY_TAX_RATE);
      }
      return tax;
   }
     /**
      *Method to determine the tax.
      *@return output
      */
   public String toString() {
      DecimalFormat decFormat = new DecimalFormat("#,##0.00#");
      DecimalFormat decFormat2 = new DecimalFormat("#,##0.0##");
      double rate = 0.0;
      if (alternativeFuel) {
         rate = ALTERNATIVE_FUEL_TAX_RATE;
      }
      else {
         rate = TAX_RATE;
      }
      String output = owner + ": Car " + yearMakeModel;
      if (alternativeFuel) { output += " (Alternative Fuel)"; }
      output += "\n" + "Value: $" + decFormat.format(value) + " Use Tax: $"
         + decFormat.format(useTax()) + "\nwith Tax Rate: "
         + decFormat2.format(rate);
      if (value >= 50000) { output += " Luxury Tax Rate: 0.02"; }
      return output;
   }
}