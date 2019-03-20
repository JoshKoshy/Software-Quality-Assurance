import java.util.Random;

public class CitySim9005 
{
	public void Setup(Driver driver, Random seed)
	{
		int seed_start = seed.nextInt(4) + 1;
		
		Loc hotel = new Loc();
		Loc diner = new Loc();
		Loc coffee = new Loc();
		Loc library = new Loc();
		Loc philly = new Loc();
		Loc cleve = new Loc();
		
		hotel.name = "Hotel";
		diner.name = "Diner";
		coffee.name = "Coffee";
		library.name = "Library";
		philly.name = "Philadelphia";
		cleve.name = "Cleveland";
		
		hotel.street = "Fourth Ave";
		diner.street = "Fourth Ave";
		coffee.street = "Fifth Ave";
		library.street = "Fifth Ave";
		philly.street = "Fourth Ave";
		cleve.street = "Fifth Ave";
		
		hotel.dest1 = diner;
		diner.dest1 = philly;
		coffee.dest1 = library;
		library.dest1 = cleve;
		
		hotel.dest2 = library;
		diner.dest2 = coffee;
		coffee.dest2 = diner;
		library.dest2 = hotel;
		
		switch(seed_start)
		{
			case 1:
				driver.present = hotel;
				break;
			case 2:
				driver.present = diner;
				break;
			case 3:
				driver.present = coffee;
				break;
			case 4:
				driver.present = library;
				break;
		}
	}
	
	public void StartDrive(Driver driver, Random seed)
	{
		Loc present = driver.present;
		Loc future = new Loc();
		String street = null;
		
		while(!present.name.equals("Cleveland") && !present.name.equals("Philadelphia"))
		{
			int seed_next = seed.nextInt(2) + 1;
			if(seed_next == 1)
			{
				driver.present = present.dest1;
				future = driver.present;
				street = present.street;
			}
			else
			{
				driver.present = present.dest2;
				future = driver.present;
				
				if(future.name.equals("Diner") || future.name.equals("Coffee"))
					street = "Phil St.";
				else
					street = "Bill St.";
			}
			if(future.name.equals("Cleveland") || future.name.equals("Philadelphia"))
				System.out.println("Driver " + driver.id + " heading from " + present.name + " to Outside City via " + street);
			else
				System.out.println("Driver " + driver.id + " heading from " + present.name + " to " + future.name + " via " + street);
			present = future;
		}
		System.out.println("Driver " + driver.id + " has gone to " + present.name + "!");
	}
	
	public static void main(String[] args) 
	{
		if(args.length != 0 && args.length < 2)
		{
			try
			{
				int rand;
				Random seed;
				CitySim9005 city = new CitySim9005();
				
				rand = Integer.parseInt(args[0]);
				seed = new Random(rand);
				
				Driver driver_1 = new Driver(1);
				Driver driver_2 = new Driver(2);
				Driver driver_3 = new Driver(3);
				Driver driver_4 = new Driver(4);
				Driver driver_5 = new Driver(5);
				
				city.Setup(driver_1, seed);
				city.Setup(driver_2, seed);
				city.Setup(driver_3, seed);
				city.Setup(driver_4, seed);
				city.Setup(driver_5, seed);
		
				city.StartDrive(driver_1, seed);
				System.out.println("-----");
				city.StartDrive(driver_2, seed);
				System.out.println("-----");
				city.StartDrive(driver_3, seed);
				System.out.println("-----");
				city.StartDrive(driver_4, seed);
				System.out.println("-----");
				city.StartDrive(driver_5, seed);
				System.out.println("-----");
			}
			
			catch(NumberFormatException e)
			{
				System.out.println("Please enter one interger argument");
				System.exit(0);
			}
		}
	}
}
