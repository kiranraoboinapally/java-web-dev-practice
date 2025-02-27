
class customChecked
{
	
public static void main(String args[]) throws GenderNotFoundException
	{
		Char gender='m';
		if(gender.equals('m'))
			System.out.println("Male");
		else 
			throw new GenderNotFoundException("mmale");
	}
}

class GenderNotFoundException extends Exception 
{

   GenderNotFoundException(String message) {
        super(message);
    }
}
