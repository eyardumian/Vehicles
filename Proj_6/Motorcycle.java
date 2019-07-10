import java.text.DecimalFormat;

/**
 *Subclass of Vehicle class.
 *
 *Project 4 (Vehicles-Motorcycle.java)
 *@author Erika Yardumian - CPSC - 1213
 *@version 11/08/18
 */
public class Motorcycle extends Vehicle {
/**Creates the Motorcycle class.
  *@param args - Command line arguments - not used.
  */
  /**Instance variables.*/
   protected int engine = 0;
  /**Instance variables.*/
   public static final double TAX_RATE = 0.005;
   /**Instance variables.*/
   public static final double ALTERNATIVE_FUEL_TAX_RATE = 0.0025;
   /**Instance variables.*/
   public static final double LARGE_BIKE_CC_THRESHOLD = 499;
   /**Instance variables.*/
   public static final double LARGE_BIKE_TAX_RATE = .015;
  /**
   *Constructor to initialize variables.
   *@param ownerIn is Motorcylce
   *@param yearMakeModelIn is Motorcycle
   *@param valueIn is Motorcycle
   *@param alternativeFuelIn is Motorcycle
   *@param engineIn is Motorcycle
   *@throws NegativeValueException here
   */
   public Motorcycle(String ownerIn, String yearMakeModelIn,
        double valueIn, boolean alternativeFuelIn, int engineIn)
         throws NegativeValueException {
      super(ownerIn, yearMakeModelIn, valueIn, alternativeFuelIn);
      engine = engineIn;
   }
    /**
     *Method to get the engine size.
     *@return engine size
     */
   public int getEngineSize() {
      return engine;
   }
     /**
     *Method to set the engine size.
     *@param engineIn is setEngineSize
     */
   public void setEngineSize(int engineIn) {
      engine = engineIn;
   }
     /**
     *Method to get the tax.
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
      if (engine > LARGE_BIKE_CC_THRESHOLD) {
         tax += (value * LARGE_BIKE_TAX_RATE);
      }
      return tax;
   }
    /**
     *Method to get vehicle info.
     *@return output
     */
   public String toString() {
      DecimalFormat decFormat = new DecimalFormat("#,##0.00#");
      DecimalFormat decFormat2 = new DecimalFormat("#,##0.00##");
      double rate = 0.0;
      if (alternativeFuel) {
         rate = ALTERNATIVE_FUEL_TAX_RATE;
      }
      else {
         rate = TAX_RATE;
      }
      String output = owner + ": Motorcycle " + yearMakeModel;
      if (alternativeFuel) {
         output += " (Alternative Fuel)";
      }
      output += "\n" + "Value: $" + decFormat.format(value) + " Use Tax: $"
         + decFormat.format(useTax()) + "\nwith Tax Rate: "
         + decFormat2.format(rate);
      if (engine > LARGE_BIKE_CC_THRESHOLD) {
         output += " Large Bike Tax Rate: " + LARGE_BIKE_TAX_RATE; }
      return output;
   }



}