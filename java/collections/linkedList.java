import java.util.LinkedList;
import java.util.Arrays;
import java.util.Iterator;

public class linkedList 
{
    public static void main(String args[])
    {
        LinkedList<Object> ll=new LinkedList<Object>(Arrays.asList(10,"hello",null,1,"hello all",'x',10," hello"));
        ll.add(20);
        System.out.println("length of the linked list \n"+ll.size());
        ll.addFirst(12);
        ll.addFirst(null);
        System.out.println("after adding first \n"+ll);
        Iterator<Object> iterator=ll.descendingIterator();
        System.out.println("Eleemnts in reverse order");
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        System.out.println();
        System.out.println(ll.getClass().getName());
        System.out.println(ll.indexOf(10));
        System.out.println(ll);

    }
}
