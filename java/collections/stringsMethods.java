import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class collec {

	public static void main(String[] args) {
	ArrayList<Integer> a=new ArrayList<Integer>(Arrays.asList(50,40,30,20,10));
	Collections.sort(a);
	System.out.println(a);
	
	
	ArrayList<Character> c=new ArrayList<Character>(Arrays.asList('x','a','z','b'));
	Collections.sort(c);
	System.out.println(c);
	
	
	ArrayList<Character> b=new ArrayList<Character>();
	String s="hello all";
	for(int x=0;x<s.length();x++)
		{
		char d=s.charAt(x);
		b.add(d);
		}
	Collections.sort(b);
	System.out.println(b);
	
	
	//check a string is a palindrome or not?
	ArrayList<Character> e=new ArrayList<Character>();
	String s1="silent";
	for(int x=0;x<s.length();x++)
		{
		char k=s.charAt(x);
		e.add(k);
		}
	Object[] obj1=b.toArray();
	System.out.println(obj1);
	Collections.reverse(e);
	Object[] obj2=b.toArray();
	System.out.println(obj2);
	if(Arrays.equals(obj1, obj2))
		System.out.println("palindrome");
	else
		System.out.println("Not a palindrome");
	}

}

