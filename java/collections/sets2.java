import java.util.LinkedHashSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class sets2 {

	public static void main(String[] args) {
		ArrayList<Object> al1=new ArrayList<Object>(Arrays.asList(10,20,30,40,50,60,"hello",'e','a','b'));
		ArrayList<Object> al2=new ArrayList<Object>(Arrays.asList(20,30,50,40,10,70,'e','a'));
		Set s=new LinkedHashSet();
		s.addAll(al1);
		s.addAll(al2);
		System.out.println(s);
		s.retainAll(al1);
		s.retainAll(al2);
		System.out.println(s);
		for(Object t:al1)
			{
			System.out.print(t+" ");
			}
		System.out.println();
		al2.forEach(x->System.out.print(x+" "));
		
		
		System.out.println();
		HashSet hs=new HashSet(Arrays.asList(100,300,20,40,50));
		
		for(int x=0;x<hs.size();x++)
		{
			System.out.println(hs);
		}
		
		for(Object ths:hs)
			{
			System.out.println(hs+" ");
			}
		hs.forEach(y->System.out.print(y+" "));
		System.out.println();
		
		LinkedHashSet lhs=new LinkedHashSet(Arrays.asList(10,30,40,50,20));
		lhs.forEach(l->System.out.print(l+" "));
		System.out.println();
		
		TreeSet tsh=new TreeSet(Arrays.asList(10,30,40,50,20));
		tsh.forEach(th->System.out.print(th+" "));
		
		}
}


