import java.io.FileNotFoundException;

/**
 *Class that read a file and prints a summary.
 *
 *Project 6 (Vehicles-Part 3)
 *@author Erika Yardumian - CPSC - 1213
 *@version 11/21/18
 */
public class VehiclesPart3 {
/**Creates VehiclePart3 class.
  *@param args - Command line arguments - not used.
  */
   public static void main(String[] args) {
   
      if (args.length == 0) {
         System.out.println("*** File name not provided"
            + " by command line argument.");
         System.out.print("Program ending.");
         return;
      }
   
      try {
         UseTaxList list = new UseTaxList();
         list.readVehicleFile(args[0]);
         
         System.out.println(list.summary() + "\n");
         System.out.println(list.listByOwner() + "\n");
         System.out.println(list.listByUseTax() + "\n");
         System.out.println(list.excludedRecordsList() + "\n");
      }
      catch (FileNotFoundException e) {
         System.out.println("*** File not found.");
         System.out.print("Program ending.");
         return;
      }
   }
  
  
}
