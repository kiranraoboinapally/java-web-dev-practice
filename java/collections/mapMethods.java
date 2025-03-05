import java.util.*;

public class practice {

	public static void main(String[] args) {
		Map hm=new LinkedHashMap();
		hm.put(10,"hello");
		hm.put(10,"kiran");
		hm.put("kiran","hello");
		hm.put(10, 30);
		hm.put(null,"hai");
		hm.put(60,null);
		hm.put(70, null);
		System.out.println(hm);
		//contains,remove,forEach,values
		System.out.println(hm.containsKey(70));//boolean returns
		System.out.println(hm.containsValue("hai"));//boolean
		hm.forEach((k,v)->System.out.print(k+"="+v+" "));
		System.out.println();
		Set abc=hm.entrySet();
		System.out.println("Entry set is"+abc);
		System.out.println();
		System.out.println("This is get Or default "+hm.getOrDefault(3,"hai"));//value returns if its present
		System.out.println(hm);
		System.out.println(hm.get(null));// get for key it gives value V return type
		System.out.println();
		System.out.println(hm.remove(null));//only key it takes and removes it value it prints
		System.out.println(hm);
		System.out.println(hm.remove("kiran","ki"));
		System.out.println(hm);
		hm.put(1170,101);
		System.out.println(hm);
		hm.putIfAbsent(123,245);
		System.out.println(hm);
	}
}


/*getOrDefault interview Question

check getKey()
getValue

for(Map.Entry<K,V> e:hm.entrySet
*/

