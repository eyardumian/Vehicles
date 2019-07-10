import java.util.Scanner;
import java.io.FileNotFoundException; 
import java.util.NoSuchElementException;
import java.io.File;
import java.util.Arrays;
import java.text.DecimalFormat; 


/**
 *The driver class and main method.
 *
 *Project 5 (Vehicles-Part 2)
 *@author Erika Yardumian - CPSC - 1213
 *@version 11/14/18
 */
public class UseTaxList {
/**Creates UseTaxList.
  *@param args - Command line arguments - not used.
  */
   //Instance variables
   private String taxDistrict;
   private Vehicle[] vehicleList;
   private String[] excludedRecords;
   
   /**
    *Constructor to initialize variables.
    */
   public UseTaxList() {
      taxDistrict = "not yet assigned";
      vehicleList = new Vehicle[0];
      excludedRecords = new String[0];
   }
   
   /**
    *Method to read the vehicle file.
    *@throws FileNotFoundException yes
    *@param fileNameIn is readVehicleFile
    */
   public void readVehicleFile(String fileNameIn) 
      throws FileNotFoundException {
      Scanner fileScan = new Scanner(new File(fileNameIn));
      taxDistrict = fileScan.nextLine();
         
      while (fileScan.hasNext()) {
         String vScan = fileScan.nextLine().trim();
         try {
            Scanner input = new Scanner(vScan).useDelimiter(";");
            char vehicleType = input.next().toUpperCase().trim().charAt(0);
            String owner = input.next().trim();
            String yearMakeModel = input.next().trim();
            String val = input.next().trim();
            String alternativeFuel = input.next().trim();
            boolean altFuel = false;
            if (alternativeFuel.equals("true")) {
               altFuel = true;
            }
            double value = Double.parseDouble(val);
            
            switch (vehicleType) {
               case 'C':
                  Car c1 = new Car(owner, yearMakeModel, value, altFuel);
                  addVehicle(c1);
                  break;
                  
               case 'T':
                  String tr = input.next().trim();
                  double tons = Double.parseDouble(tr);
                  Truck t1 = new Truck(owner, yearMakeModel, value, 
                     altFuel, tons);
                  addVehicle(t1);
                  
                  break;
                  
               case 'S':
                  String tns = input.next().trim();
                  String t = input.next().trim();
                  double tons2 = Double.parseDouble(tns);
                  int axle = Integer.parseInt(t);
                  SemiTractorTrailer s1 = new SemiTractorTrailer(owner, 
                        yearMakeModel, value, altFuel, tons2, axle);
                  addVehicle(s1);
                  
                  break;
                  
               case 'M':
                  String m = input.next().trim();
                  int size = Integer.parseInt(m);
                  Motorcycle m1 = new Motorcycle(owner, yearMakeModel, 
                     value, altFuel, size);
                  addVehicle(m1);
                  break;
                  
               default:
                  addExcludedRecord("Invalid Vehicle Category in:\n"
                     + fileScan);
                  break;
            }
         }
         catch (NumberFormatException e) {
            addExcludedRecord(e + " in:\n" + fileScan);
         }
         catch (NoSuchElementException e) {
            addExcludedRecord(e + " in:\n" + fileScan);
         } 
         catch (NegativeValueException e) {
            addExcludedRecord(e + " in:\n" + fileScan);
         }        
      }
   }
  /**
   *Method to get the tax district.
   *@return taxDistrict 
   */
   public String getTaxDistrict() {
      return taxDistrict;
   }
         
   /**
    *Method to set the tax district.
    *@param taxDistrictIn is setTaxDistrict
    */
   public void setTaxDistrict(String taxDistrictIn) {
      taxDistrict = taxDistrictIn;
   }
         
   /**
    *Method to get the vehicle list.
    *@return vehicleList 
    */
   public Vehicle[] getVehicleList() {
      return vehicleList;
   }
         
   /**
    *Method to get the excluded records.
    *@return excludedRecords 
    */
   public String[] getExcludedRecords() {
      return excludedRecords;
   }
         
   /**
    *Method to add a vehicle.
    *@param vehicleIn is addVehicle
    */
   public void addVehicle(Vehicle vehicleIn) {
      vehicleList =  Arrays.copyOf(vehicleList, vehicleList.length + 1);
      vehicleList[vehicleList.length - 1] = vehicleIn;
   }
         
   /**
    *Method to add the excluded records.
    *@param recordIn is addExcludedRecord
    */
   public void addExcludedRecord(String recordIn) {
      excludedRecords =  Arrays.copyOf(excludedRecords, 
         excludedRecords.length + 1);
      excludedRecords[excludedRecords.length - 1] = recordIn;
   }
         
   /**
    *Method to return the vehicle list.
    *@return output 
    */
   public String toString() {
      String output = "";
           
      for (Vehicle v1 : vehicleList) {
         output += "\n" + v1 + "\n";
      }
           
      return output;
   }
         
   /**
    *Method to calculate the total use tax.
    *@return total 
    */
   public double calculateTotalUseTax() {
      double total = 0.0;
            
      for (Vehicle v1 : vehicleList) {
         total += v1.useTax();
      }
            
      return total;     
   }
         
   /**
    *Method to calculate the total value.
    *@return total 
    */
   public double calculateTotalValue() {
      double total = 0.0;
            
      for (Vehicle v1 : vehicleList) {
         total += v1.getValue();
      }
            
      return total;    
   }
         
   /**
    *Method to return a vehicle summary.
    *@return output 
    */
   public String summary() {
      DecimalFormat fmtr = new DecimalFormat("###,###.00");
      String output = "------------------------------\n";
      output += "Summary for " + taxDistrict;
      output += "\n------------------------------";
      output += "\nNumber of Vehicles: " + vehicleList.length;
      output += "\nTotal Value: $" + fmtr.format(calculateTotalValue());
      output += "\nTotal Use Tax: $" + fmtr.format(calculateTotalUseTax())
                + "\n";
            
      return output;    
   }
         
   /**
    *Method to sort the lists by owner.
    *@return output 
    */
   public String listByOwner() {
      Arrays.sort(vehicleList);
      String output = "------------------------------\n";
      output += "Vehicles by Owner\n";
      output += "------------------------------\n";
            
      for (Vehicle v1 : vehicleList) {
         output += "\n" + v1 + "\n";
      }
            
      return output;   
   }
         
   /**
    *Method to return vehicles by use tax.
    *@return output 
    */
   public String listByUseTax() {
      Arrays.sort(vehicleList, new UseTaxComparator());
      String output = "------------------------------\n";
      output += "Vehicles by Use Tax\n";
      output += "------------------------------\n";
      for (Vehicle v1 : vehicleList) {
         output += "\n" + v1 + "\n";
      }
         
      return output;
         
   }
         
   /**
    *Method to return excluded records list.
    *@return output 
    */
   public String excludedRecordsList() {
      String output = "------------------------------\n";
      output += "Excluded Records\n";
      output += "------------------------------\n";
      for (String v1 : excludedRecords) {
         output += "\n" + v1 + "\n";
      }
      return output;     
   }     
}
      
         

