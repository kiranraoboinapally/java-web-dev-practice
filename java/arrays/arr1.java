//- Input: `a[] = {10, 20, 30, 40, 50, 60, 70, 80, 90}`
//- Output (Even positions): `{10, 30, 50, 70, 90}`
//- Output (Odd positions): `{20, 40, 60, 80}`


class arr1 
{
public static void main(String[] args) 
    {
    int a[]={10,20,30,40,50,60,70,80,90};
    for(int x=0;x<a.length;x++)
        {
        if(x%2==0)
            {
            System.out.print(a[x]+" ");
            }
        }
    for(int x=0;x<a.length;x++)
        {
        if(x%2!=0)
            {
            System.out.print(a[x]+" ");
            }
        }
    }    
}
