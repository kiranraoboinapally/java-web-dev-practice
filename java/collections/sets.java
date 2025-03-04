import java.util.LinkedHashSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class sets {

	public static void main(String[] args) {
		ArrayList<Object> al1=new ArrayList<Object>(Arrays.asList(10,20,30,40,50,60,"hello"));
		ArrayList<Object> al2=new ArrayList<Object>(Arrays.asList(20,30,50,40,10,70));
		Set s=new LinkedHashSet();
		s.addAll(al1);
		s.addAll(al2);
		
		System.out.println(s);
		s.retainAll(al1);
		s.retainAll(al2);
		
		System.out.println(s);
		
		
		
		//TreeSet<Object> ts=new TreeSet<Object>(Arrays.asList("Hello",10,'a',false,10,null));
		//System.out.println(ts);
		
		//Set s=new TreeSet();
		//10,12,45,23,78
		//3,4,89,21,78
		//3,4,10,12,21,23,45,78,89
		}
}

