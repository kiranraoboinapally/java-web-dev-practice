import java.util.LinkedHashSet;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class itrator {

	public static void main(String[] args) {
		ArrayList<Object> al1=new ArrayList<Object>(Arrays.asList(10,20,50,30,40));
		Iterator i=al1.iterator();
		while(i.hasNext())
			{
			System.out.print(i.next()+" ");
			}
		System.out.println();

		ListIterator li=al1.listIterator();
		while(li.hasNext())
		{
			System.out.print(li.next()+" ");
		}
		System.out.println();
		while(li.hasPrevious()) //no ouput will return because there is no previous for first element
		{
			System.out.print(li.previous()+" ");
		}
	}
}

/*Listiterator has previous and next the pointer will be started from first so we cant get directly first previous so first we use hasNext to move pointer towards the base value then we get it to last at 40th elemnt index +1 it will be next if we use hasPrevious we will get output in reverse order

if we write ListIterator li2=al1.ListIterator();
while(li2.hasPrevious())
{
syso(li2.prev()+" ");}
//it will not give any output becuase the pointer is at first eelement there is no previous element so nothing.


//Iterator is a interface has only hasNext and next() method it should be stored in interface type
//iterator also known as cursor it has uni-directional and bi-directional
*/

