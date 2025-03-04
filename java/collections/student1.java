import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;

public class student1 {

	public static void main(String[] args) {
		Student student1=new Student(107,"Kiran",9898,"kiran@gmail.com","Loyola","MCA",'a');
		Student student2=new Student(102,"Arun",2228,"arun@gmail.com","TKR","Btech",'z');
		Student student3=new Student(105,"Vinay",9383,"vinay@gmail.com","Badruka","MBA",'q');
		Student student4=new Student(101,"Vijay",1234,"vijay@gmail.com","Vishwasanthi","Btech",'y');
		ArrayList<Student> al1=new ArrayList<Student>(Arrays.asList(student1,student2,student3,student4));
		Iterator i=al1.iterator();
		while(i.hasNext())
			{
			System.out.println(i.next());
			}
		System.out.println();
		Collections.sort(al1);
		al1.forEach(x->System.out.println(x));
		System.out.println();
		NameSort ns=new NameSort();
		Collections.sort(al1,ns);
		al1.forEach(x->System.out.println(x));
	}
}
	class Student implements Comparable<Student>
	{
		int roll,mobile;
		String name,emailId,college,branch;
		char section;
		Student(int roll,String name,int mobile,String emailId,String college,String branch,char section)
		{
			this.roll=roll;
			this.name=name;
			this.mobile=mobile;
			this.emailId=emailId;
			this.college=college;
			this.branch=branch;
			this.section=section;
		}
		@Override
		public String toString()
		{
		return this.roll+" "+this.name+" "+this.mobile+" "+this.emailId+" "+this.college+" "+this.branch+" "+this.section;
		}
		@Override
		public int compareTo(Student o)
		{
		//return Integer.compare(this.roll,o.roll);
		//return o.name.compareTo(this.name); for string
		return Character.compare(this.section,o.section);
		}
		
	}
class NameSort implements Comparator<Student>
	{
	@Override
	public int compare(Student o1,Student o2)
		{
		return o1.name.compareTo(o2.name);
		}
	}
class SectionSort implements Comparator<Student>
	{
	@Override
	public int compare(Student o1,Student o2)
		
		{
		return Character.compare(o1.section,o2.section);
		}
	}

/*
stack is last in first out
pop() is used to delete
push() is used to insert
peek() is used to check
*/
