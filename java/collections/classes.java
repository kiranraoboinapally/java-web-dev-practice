import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Vector;
import java.util.Stack;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.PriorityQueue;
import java.util.ArrayDeque;

public class practice {

	public static void main(String[] args) {
		ArrayList<Object> al=new ArrayList<Object>(Arrays.asList(10,"hello",1,null,null,'p','a',false,true,10));
		System.out.println(al);
		System.out.println();
		LinkedList<Object> ll=new LinkedList<Object>(Arrays.asList(10,"hello",1,null,null,'p','a',false,true,10));
		System.out.println(ll);
		System.out.println();
		Vector<Object> v=new Vector<Object>(Arrays.asList(10,"hello",1,null,null,'p','a',false,true,10));
		System.out.println(v);
		System.out.println();
		Stack<Object> s=new Stack<Object>();
		s.add(10);
		s.add("hello");
		s.add(null);
		s.add(null);
		s.add("hello");
		System.out.println(s);
		System.out.println();
		HashSet<Object> hs=new HashSet<Object>(Arrays.asList(null,"hello",'a',"hello",20,12,null));
		System.out.println(hs);
		System.out.println();
		LinkedHashSet<Object> lhs=new LinkedHashSet<Object>(Arrays.asList(null,"hello ","hello",10,15,7,'a',"hello",20,12,null));
		System.out.println(lhs);
		System.out.println();
		TreeSet<Object> ts=new TreeSet<Object>(Arrays.asList(70,10,20,30,50,60,60));
		System.out.println(ts);
		System.out.println();
		PriorityQueue<Object> pq=new PriorityQueue<Object>(Arrays.asList("hello","all","bye","hello"));
		System.out.println(pq);
		System.out.println();
		ArrayDeque<Object> ad=new ArrayDeque<Object>(Arrays.asList("hello","all","bye",10,true,10,"hello"));
		System.out.println(ad);
		System.out.println();
		
		
		PriorityQueue<Object> pq1=new PriorityQueue<Object>(Arrays.asList(30,10,90,100,1,8,105,11));
		System.out.println(pq1);
		pq1.remove(1);
		System.out.println(pq1);
		System.out.println();
		
		
		PriorityQueue<Object> pq2=new PriorityQueue<Object>(Arrays.asList("hello","all","bye","hello"));
		System.out.println(pq2);
		System.out.println();
	}
}

