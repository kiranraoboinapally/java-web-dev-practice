import java.util.ArrayList;

public class arraysList {

	public static void main(String[] args) {
		ArrayList al=new ArrayList();
		ArrayList al2=new ArrayList();
		al.add(10);
		al.add(20);
		al.add(30);
		al.add("kiran");
		al.add(false);
		System.out.println(al);
		al.get(0);
		System.out.println(al);
		int res=al.indexOf(10);
		System.out.println(res);
		al.remove(2);
		System.out.println(al);
		System.out.println(al.size());
		System.out.println(al.isEmpty());
		System.out.println(al.isEmpty());
		al.clear();
		System.out.println(al);
		System.out.println(al.isEmpty());
		al2.addAll(al);
	}

}
