import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;


/**Tests the useTaxList class.*/
public class UseTaxListTest {

/** Fixture initialization (common initialization
 *  for all tests). **/
   @Before public void setUp() {
   }

  /**
*Tests readVehicleFile. 
   *@throws FileNotFoundException here
   **/
   @Test public void readVehicleFileTest() 
      throws FileNotFoundException {
      UseTaxList tl = new UseTaxList();
      tl.readVehicleFile("vehicles2.txt");
      String r = tl.listByOwner();
      boolean found = false;
      if (r.contains("Smith")) {
         found = true;
      }
      Assert.assertTrue(found);
   }
   
   /**Tests setTaxDistrict method.**/
   @Test public void setTaxDistrictTest() {
      UseTaxList p = new UseTaxList();
      p.setTaxDistrict("District 73");
      Assert.assertEquals("District 73", p.getTaxDistrict());
   }
     
   /**
    *Tests toString method. 
    *@throws FileNotFoundException 
    **/
   @Test public void toStringTest() 
      throws FileNotFoundException {
      UseTaxList tl = new UseTaxList();
      tl.readVehicleFile("vehicles2.txt");
      String l = tl.toString();
      boolean found = false;
      if (l.contains("Smith")) {
         found = true;
      }
      Assert.assertTrue(found);
   }
         
   /**Tests getExcludedRecords method.**/
   @Test public void getExcludedRecordsTest() {
      UseTaxList p = new UseTaxList();
      String[] r = new String[2];
      String b = "Car; Jones, Sam; 2017 Honda Accord; 22000; false";
      String a = "car; Jones, Jo; 2017 Honda Accord; 22000; true";
      r[0] = a;
      r[1] = b;
      p.addExcludedRecord(a);
      p.addExcludedRecord(b);
      Assert.assertArrayEquals(r, p.getExcludedRecords());
   }
   
   /** 
    *Tests summary method. 
    *@throws FileNotFoundException here
    **/
   @Test public void summaryTest() 
      throws FileNotFoundException {
      UseTaxList tl = new UseTaxList();
      tl.readVehicleFile("vehicles2.txt");
      String sum = "------------------------------\n" 
         + "Summary for Tax District 52\n"    
         + "------------------------------\n"
         + "Number of Vehicles: 9\n"    
         + "Total Value: $503,000.00\n"
         + "Total Use Tax: $15,310.00\n";
         
      Assert.assertEquals(sum, tl.summary());
   }
       
   /** 
    *Tests listByUseTax method. 
    *@throws FileNotFoundException here
    **/
   @Test public void listByUseTaxTest() 
      throws FileNotFoundException {
      UseTaxList tl = new UseTaxList();
      tl.readVehicleFile("vehicles2.txt");
      String list = tl.listByUseTax();
      boolean found = false;
      if (list.contains("Smith")) {
         found = true;
      }
      Assert.assertTrue(found);
   }
   
   /**
    *Tests excludedRecordsList method. 
    *@throws FileNotFoundException here
    **/
   @Test public void excludedRecordsListTest()
      throws FileNotFoundException {
      UseTaxList p = new UseTaxList();
      p.readVehicleFile("vehicles2.txt");
      String r = p.excludedRecordsList();
      boolean found = false;
      if (r.contains("Invalid")) {
         found = true;
      }
      Assert.assertTrue(found);
   }
   
}
