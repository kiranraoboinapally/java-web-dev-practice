class constructorMethodProblem
{
public static void main(String args[])
	{
	Book book1=new Book("Java Programming","by Henry");
	System.out.println(book1.title+" "+book1.author);
	Book book2=new Book("C++","Cavendish",100);
	System.out.println(book2.title+" "+book2.author+" "+book2.price);
	Book book3=new Book();
	System.out.println(book3.title+" "+book3.author+" "+book3.price);
	book2.display();
	book2.display(book2.title,book1.author);
	}
}
class Book
{
String title,author;
double price;
Book(String title,String author)
	{
	this.title=title;
	this.author=author;
	}
Book(String title,String author,double price)
	{
	this.title=title;
	this.author=author;
	this.price=price;
	}
Book()
	{
	this.title="Unknown";
	this.author="Unknown";
	this.price=0.0;
	}
void display(String title,String author)
	{
	System.out.println(title+" "+author);//don't use this keyword over here for calling different object names.book2.title and book1.author
	}
void display()
	{
	System.out.println("Title: "+this.title+", Author: "+this.author+", Price: "+this.price);
	}

}


/*
Problem:

Part 1: Constructor Overloading

Create a class called Book with the following overloaded constructors:

    A constructor that takes the title and author as parameters.
    A constructor that takes the title, author, and price as parameters.
    A default constructor that initializes title and author to "Unknown" and price to 0.0.

Part 2: Method Overloading

Inside the Book class, create an overloaded method called display():

    A method that displays the title and author of the book.
    A method that displays the title, author, and price of the book.
    A method that displays all the details of the book in the format Title: <title>, Author: <author>, Price: <price> (if the price is 0.0, display "Price not available").
*/