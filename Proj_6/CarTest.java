import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**Tests the Car class.*/
public class CarTest {

   private static final double DELTA = 1e-15;
   
/** Fixture initialization (common initialization
 *  for all tests). **/
   @Before public void setUp() {
   }
   /**Tests the useTax method.
   *@throws NegativeValueException here
   */
   @Test public void useTaxStandardTest() throws NegativeValueException {
      Car car1 = new Car("Jones, Sam", "2017 Honda Accord",
         22000, false);
      Assert.assertEquals(220.00, car1.useTax(), DELTA);
   }
   /**Tests the useTax method.
   *@throws NegativeValueException here
   */
   @Test public void notAlternativeFuelTest() throws NegativeValueException {
      Car car1 = new Car("Jones, Sam", "2017 Honda Accord",
          22000, false);
      Assert.assertEquals(220.00, car1.useTax(), DELTA);
   }
   /**Tests the useTax method.
   *@throws NegativeValueException here
   */
   @Test public void useTaxStandardAlternativeTest()
      throws NegativeValueException {
      Car car2 = new Car("Jones, Jo", "2017 Honda Accord",
          22000, true);
      Assert.assertEquals(110.00, car2.useTax(), DELTA);
   }
   /**Tests the useTax method.
   *@throws NegativeValueException here
   */
   @Test public void useTaxLuxTest() throws NegativeValueException {
      Car car3 = new Car("Smith, Pat", "2015 Mercedes-Benz Coupe",
         110000, false);
      Assert.assertEquals(3300.00, car3.useTax(), DELTA);
   }
   /**Tests the useTax method.
   *@throws NegativeValueException here
   */
   @Test public void useTaxLuxAlternativeTest() throws NegativeValueException {
      Car car4 = new Car("Smith, Jack", "2015 Mercedes-Benz Coupe",
         110000, true);
      Assert.assertEquals(2750.00, car4.useTax(), DELTA);
   }
   /**Tests the toString method.
   *@throws NegativeValueException here
   */
   @Test public void toStringTest() throws NegativeValueException {
      Car car1 = new Car("Jones, Sam", "2017 Honda Accord",
         22000, false);
      Assert.assertTrue(car1.toString().contains("with Tax Rate:"));
   }
   /**Tests the toString method.
   *@throws NegativeValueException here
   */
   @Test public void toStringTest2() throws NegativeValueException {
      Car car2 = new Car("Jones, Jo", "2017 Honda Accord",
         22000, true);
      Assert.assertTrue(car2.toString().contains("(Alternative Fuel)"));
   }
   /**Tests the toString method.
   *@throws NegativeValueException here
   */
   @Test public void toStringTest3() throws NegativeValueException {
      Car car3 = new Car("Smith, Pat", "2015 Mercedes-Benz Coupe",
         110000, false);
      Assert.assertTrue(car3.toString().contains("Luxury Tax Rate: 0.02"));
   }
   /**Tests the getOwner method.
   *@throws NegativeValueException here
   */
   @Test public void getOwnerTest() throws NegativeValueException {
      Car car1 = new Car("Jones, Sam", "2017 Honda Accord",
         22000, false);
      Assert.assertTrue(car1.getOwner().contains("Jones, Sam"));
   }
   /**Tests the setOwner method.
   *@throws NegativeValueException here
   */
   @Test public void setOwnerTest() throws NegativeValueException {
      Car car5 = new Car("Manny, Dan", "", 0, false);
      car5.setOwner("User, Test");
      Assert.assertTrue(car5.getOwner().contains("User, Test"));
   }
      /**Tests the getYearMakeModel method.
      *@throws NegativeValueException here
      */
   @Test public void getYearMakeModelTest() throws NegativeValueException {
      Car car2 = new Car("Jones, Jo", "2017 Honda Accord",
         22000, true);
      Assert.assertTrue(car2.getYearMakeModel()
         .contains("2017 Honda Accord"));
   }
   /**Tests the getYearMakeModel method.
   *@throws NegativeValueException here
   */
   @Test public void setYearMakeModelTest() throws NegativeValueException {
      Car car5 = new Car("Manny, Dan", "", 0, false);
      car5.setYearMakeModel("2018 Maserati Gilbi");
      Assert.assertTrue(car5.getYearMakeModel()
         .contains("2018 Maserati Gilbi"));
   }
      /**Tests the getValue method.
      *@throws NegativeValueException here
      */
   @Test public void getValueTest() throws NegativeValueException {
      Car car3 = new Car("Smith, Pat", "2015 Mercedes-Benz Coupe",
         110000, false);
      Assert.assertEquals(110000.00, car3.getValue(), DELTA);
   }
   /**Tests the setValue method.
   *@throws NegativeValueException here
   */
   @Test public void setValueTest() throws NegativeValueException {
      Car car5 = new Car("Manny, Dan", "", 0, false);
      car5.setValue(49000.00);
      Assert.assertEquals(49000.00, car5.getValue(), DELTA);
   }
      /**Tests the getAlternativeFuel method.
      *@throws NegativeValueException here
      */
   @Test public void getAlternativeFuelTest() throws NegativeValueException {
      Car car2 = new Car("Jones, Jo", "2017 Honda Accord",
         22000, true);
      Assert.assertTrue(car2.getAlternativeFuel());
   }
   /**Tests the getAlternativeFuel method.
   *@throws NegativeValueException here
   */
   @Test public void setAlternativeFuelTest() throws NegativeValueException {
      Car car5 = new Car("Manny, Dan", "", 0, false);
      car5.setAlternativeFuel(true);
      Assert.assertTrue(car5.getAlternativeFuel());
   }
   /**Tests the getVehicleCount method.
   *@throws NegativeValueException here
   */
   @Test public void getVehicleCountTest() throws NegativeValueException {
      Car car1 = new Car("Jones, Sam", "2017 Honda Accord",
         22000, false);
      Car car5 = new Car("Manny, Dan", "", 0, false);
      car1.resetVehicleCount();
      Car testCar1 = new Car("", "", 0, false);
      Car testCar2 = new Car("", "", 0, false);
      Assert.assertEquals(2, car5.getVehicleCount());
   }
   /**Tests the resetVehicleCount method.
   *@throws NegativeValueException here
   */
   @Test public void resetVehicleCountTest() throws NegativeValueException {
      Car car5 = new Car("Manny, Dan", "", 0, false);
      car5.resetVehicleCount();
      Assert.assertEquals(0, car5.getVehicleCount());
   }
   /**Tests the equals method.
   *@throws NegativeValueException here
   */
   @Test public void equalsTest() throws NegativeValueException {
      Car car1 = new Car("Jones, Sam", "2017 Honda Accord",
         22000, false);
      Car car6 = new Car("Jones, Sam", "2017 Honda Accord",
         22000, false);
      Assert.assertTrue(car1.equals(car6));
   }
   /**Tests the equals method.
   *@throws NegativeValueException here
   */
   @Test public void notEqualsTest() throws NegativeValueException {
      Car car1 = new Car("Jones, Sam", "2017 Honda Accord",
         22000, false);
      Car car2 = new Car("Jones, Jo", "2017 Honda Accord",
         22000, true);
      Assert.assertFalse(car1.equals(car2));
   }
   /**Tests the equals method.
   *@throws NegativeValueException here
   */
   @Test public void notEqualsObjectTest() throws NegativeValueException {
      Car car1 = new Car("Jones, Sam", "2017 Honda Accord",
         22000, false);
      Assert.assertFalse(car1.equals(null));
   }
   /**Tests the hashCode method.
   *@throws NegativeValueException here
   */
   @Test public void haseCodeTest() throws NegativeValueException {
      Car car1 = new Car("Jones, Sam", "2017 Honda Accord",
         22000, false);
      Assert.assertEquals(0, car1.hashCode());
   }   
}
