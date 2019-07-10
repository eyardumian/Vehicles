import java.text.DecimalFormat;

/**
 *Subclass of Vehicle class.
 *
 *Project 4 (Vehicles-Truck.java)
 *@author Erika Yardumian - CPSC - 1213
 *@version 11/08/18
 */
public class Truck extends Vehicle {
/**Creates the Truck class.
  *@param args - Command line arguments - not used.
  */
  /**Instance Variable.*/
   protected double tons = 0.0;
   /**Instance Variable.*/
   public static final double TAX_RATE = 0.02;
   /**Instance Variable.*/
   public static final double ALTERNATIVE_FUEL_TAX_RATE = 0.01;
   /**Instance Variable.*/
   public static final double LARGE_TRUCK_TONS_THRESHOLD = 2.0;
   /**Instance Variable.*/
   public static final double LARGE_TRUCK_TAX_RATE = 0.03;
   
   /**
    *Constructor to initialize variables.
    *@param ownerIn is Truck
    *@param yearMakeModelIn is Truck
    *@param valueIn is Truck
    *@param alternativeFuelIn is Truck
    *@param tonsIn is Truck
    *@throws NegativeValueException here
    */
   public Truck(String ownerIn, String yearMakeModelIn, double valueIn,
      boolean alternativeFuelIn, double tonsIn) throws NegativeValueException {
      super(ownerIn, yearMakeModelIn, valueIn, alternativeFuelIn);
      tons = tonsIn;
   }
   
   /**
    *Method to get weight.
    *@return tons
    */
   public double getTons() {
      return tons;
   }
   /**
    *Method to set weight.
    *@param tonsIn is setTons
    */
   public void setTons(double tonsIn) {
      tons = tonsIn;
   }
   
   /**
    *Method to get tax.
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
      if (tons > LARGE_TRUCK_TONS_THRESHOLD) {
         tax += (value * LARGE_TRUCK_TAX_RATE);
      }
      return tax;
   }
   
   /**
    *Method to get vehicle info.
    *@return output
    */
   public String toString() {
      DecimalFormat decFormat = new DecimalFormat("#,##0.00#");
      DecimalFormat decFormat2 = new DecimalFormat("#,##0.0##");
      double rate = 0.0;
      boolean lux = false;
      if (alternativeFuel) {
         rate = ALTERNATIVE_FUEL_TAX_RATE;
      }
      else {
         rate = TAX_RATE;
      }
      String output = owner + ": Truck " + yearMakeModel;
      if (alternativeFuel) { output += " (Alternative Fuel)"; }
      output += "\n" + "Value: $" + decFormat.format(value) + " Use Tax: $"
         + decFormat.format(useTax()) + "\nwith Tax Rate: "
         + decFormat2.format(rate);
      if (tons > LARGE_TRUCK_TONS_THRESHOLD) {
         output += " Large Truck Tax Rate: " + LARGE_TRUCK_TAX_RATE; }
      return output;
   }
}
