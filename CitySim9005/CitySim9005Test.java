import java.util.Random;
import static org.junit.Assert.*;


// For some reason, I wasn't able to get any of the testing working for this deliverable.
// Though my project code works, I was unable to get this test file through the compilier.
// Because I've run out of time to find a solution, I'm turning in the progress I've made
// as it looks now.

public class CitySim9005Test
{
	 // Reuseable
	 CitySim9005 city;
	
	 @Before
	 public void setup()
	 {
		 city = new CitySim9005();
	 }
	
	// Makes sure that a seed will produce the same starting location
	@Test
	public void testReproduceableSeeds()
	{		
		int rand = 12345;
		int seed_start;
		
		Driver driver_1 = new Driver(1);
		Driver driver_2 = new Driver(2);
		
		Random seed = new Random(rand);
		city.Setup(driver_1, seed);
		
		seed = new Random(rand);
		city.Setup(driver_2, seed);
		
		assertEquals(driver_1.present.name, driver_2.present.name);
	}

	// Makes sure that a Driver ID can be set up properly
	@Test
	public void testMakeDriverID()
	{
		Driver driver = new Driver(1);
		
		assertEquals(2, driver.id);
	}
	
	// Makes sure that the present location can be set up properly 
	@Test
	public void testDriverPresentLoc()
	{
		Driver driver = new Driver(1);
		
		Loc test = new Loc();
		test.name = "test";
		driver.present = test;
		
		
		assertEquals(driver.present.name, "test");
	}
	
	// Makes sure that a Location name can be set up properly
	@Test
	public void testCreateLocationName()
	{
		Loc test = new Loc();
		test.name = "test";
		
		assertEquals(test.name, "test");
	}
	
	// Makes sure that a Location street can be set up properly
	@Test
	public void testCreateLocationStreet()
	{
		Loc test = new Loc();
		test.street = "test";
		
		assertEquals(test.street, "test");
	}
	
	// Makes sure that a Location's first choice of destination
	// can be set up properly
	@Test
	public void testCreateLocationDest_1()
	{
		Loc test = new Loc();
		test.dest1.name = "test";
		
		assertEquals(test.dest1, "test");
	}
	
	// Makes sure that a Location's second choice of destination
	// can be set up properly
	@Test
	public void testCreateLocationDest_2()
	{
		Loc test = new Loc();
		test.dest2.name = "test";
		
		assertEquals(test.dest2, "test");
	}
	
	// I was very confused by the double and stubbing requirements,
	// mainly because I didn't have any methods that was needed to
	// return values. Almost all of my methods are "public void". So,
	// to demonstrate I understood the concept, I made a few extra methods.
	// I don't actually use in the main file because I don't need
	// to use them.
	
	// STUBBING TESTS
	
	@Test
	public void testUseMockDriverID()
	{
		Driver mockDriver = mock(Driver.class);
		when(mockDriver.getID()).thenReturn(new Integer(1));
		assertEquals(mockDriver.id, 1);
	}
	
	@Test
	public void testUseMockLocationName()
	{
		Loc mockLoc = mock(Loc.class);
		when(mockLoc.getName()).thenReturn("test");
		assertEquals(mockLoc.name, "test");
	}
	
	@Test
	public void testUseMockLocationStreet()
	{
		Loc mockLoc = mock(Loc.class);
		when(mockLoc.getStreet()).thenReturn("test");
		assertEquals(mockLoc.street, "test");
	}
}
