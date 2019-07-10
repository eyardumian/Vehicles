import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**Tests the Truck class.*/
public class TruckTest {
            
   private static final double DELTA = 1e-15;
   
   /** Fixture initialization (common initialization
 *  for all tests). **/
   @Before public void setUp() {
   }
   /**Tests the getTons method.
   *@throws NegativeValueException here
   */
   @Test public void getTonsTest() throws NegativeValueException {
      Truck truck1 = new Truck("Williams, Jo", "2012 Chevy Silverado",
         30000, false, 1.5);
      Assert.assertEquals(1.5, truck1.getTons(), DELTA);
   }
   /**Tests the getTons method.
   *@throws NegativeValueException here
   */
   @Test public void setTonsTest() throws NegativeValueException {
      Truck truck3 = new Truck("", "", 0.0, false, 0.0);
      truck3.setTons(1.2);
      Assert.assertEquals(1.2, truck3.getTons(), DELTA);
   }
      /**Tests the toString method.
      *@throws NegativeValueException here
      */
   @Test public void toStringTest() throws NegativeValueException {
      Truck truck1 = new Truck("Williams, Jo", "2012 Chevy Silverado",
         30000, false, 1.5);
      Assert.assertTrue(truck1.toString().contains("Chevy Silverado"));
   }
   /**Tests the toString method.
   *@throws NegativeValueException here
   */
   @Test public void toStringTest2() throws NegativeValueException {
      Truck truck2 = new Truck("Williams, Sam", "2010 Chevy Mack",
         40000, true, 2.5);
      Assert.assertTrue(truck2.toString().contains("(Alternative Fuel)"));
   }
   /**Tests the standard useTax method.
   *@throws NegativeValueException here
   */
   @Test public void useTaxTruckTest1() throws NegativeValueException {
      Truck truck1 = new Truck("Williams, Jo", "2012 Chevy Silverado",
         30000, false, 1.5);
      Assert.assertEquals(600.00, truck1.useTax(), DELTA);
   }
   /**Tests the alternative useTax method.
   *@throws NegativeValueException here
   */
   @Test public void useTaxTruckTest2() throws NegativeValueException {
      Truck truck2 = new Truck("Williams, Sam", "2010 Chevy Mack",
         40000, true, 2.5);
      Assert.assertEquals(1600.00, truck2.useTax(), DELTA);
   }

}




 
