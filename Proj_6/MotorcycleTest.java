import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**Tests the motocycle class.*/
public class MotorcycleTest {
   private static final double DELTA = 1e-15;
   
   /** Fixture initialization (common initialization
    *for all tests). **/
   @Before public void setUp() {
   }
   /**Tests the getEngineSize method.
   *@throws NegativeValueException here
   */
   @Test public void getEngineSizeTest() throws NegativeValueException {
      Motorcycle bike1 = new Motorcycle("Brando, Marlon",
         "1964 Harley-Davidson Sportster", 14000, false, 750);
      Assert.assertEquals(750, bike1.getEngineSize());
   }
   /**Tests the setEngineSize method.
   *@throws NegativeValueException here
   */
   @Test public void setEngineSizeTest() throws NegativeValueException {
      Motorcycle bike3 = new Motorcycle("", "", 0.0, false, 0);
      bike3.setEngineSize(950);
      Assert.assertEquals(950, bike3.getEngineSize());
   }

   /**Tests the standard tax rate method.
   *@throws NegativeValueException here
   */
   @Test public void useTaxStandardTest() throws NegativeValueException {
      Motorcycle bike1 = new Motorcycle("Brando, Marlon",
         "1964 Harley-Davidson Sportster", 14000, false, 750);
      Assert.assertEquals(280.00, bike1.useTax(), DELTA);
   }
   /**Tests the alternative tax rate method.
   *@throws NegativeValueException here
   */
   @Test public void useTaxAlternativeFuelTest() throws NegativeValueException {
      Motorcycle bike5 = new Motorcycle("Reed, Chad",
         "1980 Ford Bike", 6000, true, 960);
      Assert.assertTrue(bike5.toString().contains("(Alternative Fuel)"));
      
   }
   /**Tests the tax rate method.
   *@throws NegativeValueException here
   */
   @Test public void useTaxBikeTest() throws NegativeValueException {
      Motorcycle bike2 = new Motorcycle("Sean, Ryan",
         "1960 Harley Charley", 33000, false, 550);
      Assert.assertTrue(bike2.toString().contains("Bike Tax Rate"));
   }
   /**Tests the toString method.
   *@throws NegativeValueException here
   */
   @Test public void toStringTest() throws NegativeValueException {
      Motorcycle bike1 = new Motorcycle("Brando, Marlon",
         "1964 Harley-Davidson Sportster", 14000, false, 750);
      Assert.assertTrue(bike1.toString().contains("Motorcycle"));
   }
  /**Tests the getOwner method.
  *@throws NegativeValueException here
  */
   @Test public void getOwnerTest() throws NegativeValueException {
      Motorcycle bike1 = new Motorcycle("Brando, Marlon",
         "1964 Harley-Davidson Sportster", 14000, false, 750);
      Assert.assertTrue(bike1.getOwner().contains("Brando, Marlon"));
   }
   /**Tests the setOwner.
   *@throws NegativeValueException here
   */
   @Test public void setOwnerTest() throws NegativeValueException {
      Motorcycle bike3 = new Motorcycle("", "", 0.0, false, 0);
      bike3.setOwner("User, Test");
      Assert.assertTrue(bike3.getOwner().contains("User, Test"));
   }
   /**Tests the getYearMakeModel method.
   *@throws NegativeValueException here
   */
   @Test public void getYearMakeModelTest() throws NegativeValueException {
      Motorcycle bike2 = new Motorcycle("Sean, Ryan",
         "1960 Harley Charley", 33000, false, 550);
      Assert.assertTrue(bike2.getYearMakeModel()
         .contains("1960 Harley Charley"));
   }
   /**Tests the setYearMakeModel method.
   *@throws NegativeValueException here
   */
   @Test public void setYearMakeModelTest() throws NegativeValueException {
      Motorcycle bike3 = new Motorcycle("", "", 0.0, false, 0);
      bike3.setYearMakeModel("1990 Harley-Davidson");
      Assert.assertTrue(bike3.getYearMakeModel()
         .contains("1990 Harley-Davidson"));
   }
  /**Tests the getValue method.
  *@throws NegativeValueException here
  */
   @Test public void getValueTest() throws NegativeValueException {
      Motorcycle bike2 = new Motorcycle("Sean, Ryan",
         "1960 Harley Charley", 33000, false, 550);
      Assert.assertEquals(33000.00, bike2.getValue(), DELTA);
   }
  /**Tests the setValue method.
  *@throws NegativeValueException here
  */
   @Test public void setValueTest() throws NegativeValueException {
      Motorcycle bike3 = new Motorcycle("", "", 0.0, false, 0); 
      bike3.setValue(49000.00);
      Assert.assertEquals(49000.00, bike3.getValue(), DELTA);
   }
  /**Tests the getAlternativeFuel method.
  *@throws NegativeValueException here
  */
   @Test public void getAlternativeFuelTest() throws NegativeValueException {
      Motorcycle bike1 = new Motorcycle("Brando, Marlon",
         "1964 Harley-Davidson Sportster", 14000, false, 750);
      Assert.assertFalse(bike1.getAlternativeFuel());
   }
  /**Tests the setAlternativeFuel Method.
  *@throws NegativeValueException here
  */
   @Test public void setAlternativeFuelTest() throws NegativeValueException {
      Motorcycle bike3 = new Motorcycle("", "", 0.0, false, 0);
      bike3.setAlternativeFuel(true);
      Assert.assertTrue(bike3.getAlternativeFuel());
   }
   /**Tests the equals method.
   *@throws NegativeValueException here
   */
   @Test public void equalsTest() throws NegativeValueException {
      Motorcycle bike1 = new Motorcycle("Brando, Marlon",
         "1964 Harley-Davidson Sportster", 14000, false, 750);
      Motorcycle bike4 = new Motorcycle("Brando, Marlon",
         "1964 Harley-Davidson Sportster", 14000, false, 750);
      Assert.assertTrue(bike1.equals(bike4));
   }
   /**Tests the equals method for false.
   *@throws NegativeValueException here
   */
   @Test public void notEqualsTest() throws NegativeValueException {
      Motorcycle bike1 = new Motorcycle("Brando, Marlon",
         "1964 Harley-Davidson Sportster", 14000, false, 750);
      Motorcycle bike2 = new Motorcycle("Sean, Ryan",
         "1960 Harley Charley", 33000, false, 550);
      Assert.assertFalse(bike1.equals(bike2));
   }
      
      


}
