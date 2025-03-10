class Main
{
	public static void main(String[] args)
	{
		int age = 18;
		if(age >= 18)
			System.out.println("Eligible");
		else
			try
			{
				throw new VoteNotEligibleException("Not eligible");
			}
			catch(VoteNotEligibleException e)
			{


				System.out.println("catched");
			}
	}


}
class VoteNotEligibleException extends Exception
{

	VoteNotEligibleException(String msg)
	{
		super(msg);

	}


}