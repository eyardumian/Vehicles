import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
   

/**Tests the useTaxComparator class.*/
public class UseTaxComparatorTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

   /**
    *Tests the compare equal.
    *@throws NegativeValueException here 
    **/
   @Test public void compareEqualTest() throws NegativeValueException {
      Car c1 = new Car("Jones, Sam", "2017 Honda Accord", 22000, false);
      Car c2 = new Car("Jones, Sam", "2017 Honda Accord", 22000, false);
      UseTaxComparator com = new UseTaxComparator();
      Assert.assertEquals(0, com.compare(c1, c2));
   }
               
   /**
    *Tests the compare greater.
    *@throws NegativeValueException here
    **/
   @Test public void compareGreaterTest() throws NegativeValueException {
      Car c1 = new Car("Jones, Sam", "2017 Honda Accord", 22000, false);
      Car c2 = new Car("Jones, Sam", "2017 Honda Accord", 5000, false);
      UseTaxComparator com = new UseTaxComparator();
      Assert.assertEquals(1, com.compare(c1, c2));
   }
   
   /**
    *Tests the compare less. 
    *@throws NegativeValueException here
    **/
   @Test public void compareLessTest() throws NegativeValueException {
      Car c1 = new Car("Jones, Jo", "2017 Honda Accord", 5000, true);
      Car c2 = new Car("Jones, Jo", "2017 Honda Accord", 22000, true);
      UseTaxComparator com = new UseTaxComparator();
      Assert.assertEquals(-1, com.compare(c1, c2));
   }

      
}
