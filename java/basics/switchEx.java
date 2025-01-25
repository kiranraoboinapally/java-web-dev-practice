class switchEx {

public static void main(String args[]){



int month=2,year=2024;
switch(month) {

case 1:
case 3:
case 5:
case 7:
case 8:
case 10:
case 12:
System.out.println("31 Days");
break;

case 4:
case 6:
case 9:
case 11:
System.out.println("30 days");
break;

case 2:

System.out.println(((year%4==0 && year%100!=0)|| year%400==0)?("28 Days"):("29 Days"));

}






}
}
