   
/**
 *Subclass of Truck class.
 *
 *Project 4 (Vehicles-SemiTractorTrailer.java)
 *@author Erika Yardumian - CPSC - 1213
 *@version 11/08/18
 */
public class SemiTractorTrailer extends Truck {
/**Creates the SemiTractorTrailer class.
  *@param args - Command line arguments - not used.
  */

   protected int axles = 0;
   /**Instance variables.*/
   public static final double PER_AXLE_TAX_RATE = 0.005;
   
   /**
    *Constructor to initialize variables.
    *@param ownerIn is SemiTractorTrailer
    *@param yearMakeModelIn is SemiTractorTrailer
    *@param valueIn is SemiTractorTrailer
    *@param alternativeFuelIn is SemiTractorTrailer
    *@param tonsIn is SemiTractorTrailer
    *@param axlesIn is SemiTractorTrailer
    *@throws NegativeValueException here
    */
   public SemiTractorTrailer(String ownerIn, String yearMakeModelIn,
         double valueIn, boolean alternativeFuelIn, 
         double tonsIn, int axlesIn) throws NegativeValueException {
      super(ownerIn, yearMakeModelIn, valueIn, alternativeFuelIn, tonsIn);
      axles = axlesIn;
   }
   /**
    *Method to get the axles.
    *@return axles
    */
   public int getAxles() {
      return axles;
   }
   /**
    *Method to set the axles.
    *@param axlesIn is setAxles
    */
   public void setAxles(int axlesIn) {
      axles = axlesIn;
   }
   /**
    *Method to get the tax.
    *@return tax
    */
   public double useTax() {
      double tax = 0.0;
      tax = super.useTax();
      tax += (value * PER_AXLE_TAX_RATE * axles);
      return tax;
   }
   /**
    *Method to get vehicle info.
    *@return output
    */
   public String toString() {
      String output = "";
      output = super.toString();
      output += " Axle Tax Rate: " + (PER_AXLE_TAX_RATE * axles);
      return output;  
   }
}