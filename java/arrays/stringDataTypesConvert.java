class stringDataTypesConvert
{
public static void main(String xy[])
	{
	System.out.println("Converting String dataType into numeric:");
	String s="123";//true//false//123.45//
	int x=Integer.parseInt(s);
	double d=Double.parseDouble(s);
	byte b=Byte.parseByte(s);
	boolean bool=Boolean.parseBoolean(s);
	System.out.println(x);
	System.out.println(d);
	System.out.println(b);
	System.out.println(bool);
	System.out.println("\nAnother dataType converting into string:");
	String s2=Integer.toString(123);
	System.out.println(s2+30+" hello");
	//String s3=Byte.toString(3);
	//System.out.println(s3);
	}
}