
public class Loc
{
	public String name;
	public String street;
	public Loc dest1;	//first choice of possible next destination	(can't be null)
	public Loc dest2;	//second choice of possible next destination (can be null)
	
	public Loc()
	{}
	
	public String getName()
	{
		return name;
	}
	
	public String getStreet()
	{
		return street;
	}
}
