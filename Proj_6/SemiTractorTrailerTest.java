import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**Tests the SemiTractorTrailer.*/
public class SemiTractorTrailerTest {
   private static final double DELTA = 1e-15;

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   /** Tests the toString method.
    *@throws NegativeValueException here
   */
   @Test public void toStringTest() throws NegativeValueException {
      SemiTractorTrailer semi1 = new SemiTractorTrailer("Williams, Pat",
         "2012 International Big Boy", 45000, false, 5.0, 4);
      Assert.assertTrue(semi1.toString().contains("Axle Tax Rate:"));
   }
   /** Tests the getTons method.
   *@throws NegativeValueException here
   */
   @Test public void getTonsTest() throws NegativeValueException {
      SemiTractorTrailer semi1 = new SemiTractorTrailer("Williams, Pat",
         "2012 International Big Boy", 45000, false, 5.0, 4);
      Assert.assertEquals(5.0, semi1.getTons(), DELTA);
   }
   /** Tests the setTons method.
   *@throws NegativeValueException here
   */
   @Test public void setTonsTest() throws NegativeValueException {
      SemiTractorTrailer semi3 = new SemiTractorTrailer("", "",
          0.0, false, 0.0, 0);
      semi3.setTons(3.3);
      Assert.assertEquals(3.3, semi3.getTons(), DELTA);
   }
   /** Tests the useTax method for standard tax.
   *@throws NegativeValueException here
   */
   @Test public void useTaxStandardTruckTest() throws NegativeValueException {
      SemiTractorTrailer semi1 = new SemiTractorTrailer("Williams, Pat",
         "2012 International Big Boy", 45000, false, 5.0, 4);
      Assert.assertEquals(3150.00, semi1.useTax(), DELTA);
   }
   /** Tests the useTax method for alternative tax.
   *@throws NegativeValueException here
   */
   @Test public void useTaxAlternativeTruckTest() 
       throws NegativeValueException {
      SemiTractorTrailer semi2 = new SemiTractorTrailer("Smith, Jack",
         "2000 Honda Giant", 60000, false, 5.0, 4);
      Assert.assertEquals(4200.00, semi2.useTax(), DELTA);
   }
   /** Tests the getAxles method.
   *@throws NegativeValueException here
   */
   @Test public void getAxlesTest() throws NegativeValueException {
      SemiTractorTrailer semi1 = new SemiTractorTrailer("Williams, Pat",
         "2012 International Big Boy", 45000, false, 5.0, 4);
      Assert.assertEquals(4, semi1.getAxles());
   }
   /** Tests the setAxles method.
   *@throws NegativeValueException here
   */
   @Test public void setAxlesTest() throws NegativeValueException {
      SemiTractorTrailer semi3 = new SemiTractorTrailer("", "",
          0.0, false, 0.0, 0);
      semi3.setAxles(5);
      Assert.assertEquals(5, semi3.getAxles());
   }

}
