/**
 *Class that creates a user defined exception.
 *
 *Project 6 (Vehicles-Part 3)
 *@author Erika Yardumian - CPSC - 1213
 *@version 11/21/18
 */
public class NegativeValueException extends Exception {
/**Creates NegativeValueException class.
  */
   public NegativeValueException() {
      super("Numeric values must be nonnegative.");
   }
   
  
}
