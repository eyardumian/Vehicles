import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**Tests the VehiclesPart3.*/
public class VehiclesPart3Test {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   
   /**Tests for a good file name.**/
   @Test public void vehiclePart3GoodFileTest() {
      VehiclesPart3 part3Obj = new VehiclesPart3();
      Vehicle.resetVehicleCount();
      String[] args = {"vehicles2.txt"}; 
      VehiclesPart3.main(args);
      Assert.assertEquals(9, Vehicle.getVehicleCount());
   }
      
      /**Tests for a bad file name.**/
   @Test public void vehiclePart3BadFileTest() {
      VehiclesPart3 part3Obj = new VehiclesPart3();
      Vehicle.resetVehicleCount();
      String[] args = {"vehicles7.txt"}; 
      VehiclesPart3.main(args);
      Assert.assertEquals(0, Vehicle.getVehicleCount());
   }
      
      /** test good input. **/
   @Test public void vehiclePart3NoFileTest() {
      VehiclesPart3 part3Obj = new VehiclesPart3();
      Vehicle.resetVehicleCount();
      String[] args = {}; 
      VehiclesPart3.main(args);
      Assert.assertEquals(0, Vehicle.getVehicleCount());
   }
}
