class leapYear 
{
    public static void main(String[] args)
    {
        int startYear=1900,endYear=2025;
        while(startYear<=endYear)
        {
            if((startYear%4==0&&startYear%100!=0)||startYear%400==0)
            {
            System.out.println(startYear+" is a Leap Year");
            }
            startYear++;
        }
    }
}
