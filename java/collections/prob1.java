import java.util.LinkedHashSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class practice {

	public static void main(String[] args) {
		//Set s=new TreeSet();
		//10,12,45,23,78
		//3,4,89,21,78
		//3,4,10,12,21,23,45,78,89
		Set s1=new TreeSet(Arrays.asList(10,12,45,23,78));
		Set s2=new TreeSet(Arrays.asList(3,4,89,21,78));
		System.out.print(s1+" ");
		System.out.println();
		System.out.print(s2+" ");
		System.out.println();
		}
}


