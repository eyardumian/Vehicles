import java.util.Comparator;

/**
 *Implements the Comparator interface for Vehicle objects.
 *
 *Project 5 (Vehicles-Part 2)
 *@author Erika Yardumian - CPSC - 1213
 *@version 11/14/18
 */
public class UseTaxComparator implements Comparator<Vehicle> {
/**Creates the UseTaxComparator class.
  *@param args - Command line arguments - not used.
  */
  
   /**
    *Method to compare vehicles.
    *@param v1 is compare
    *@param v2 is compare
    *@return 0
    */
   public int compare(Vehicle v1, Vehicle v2) {
      if (v1.useTax() > v2.useTax()) {
         return 1;
      }
      else if (v1.useTax() < v2.useTax()) {
         return -1;
      }
      return 0;
   }
    
}  
