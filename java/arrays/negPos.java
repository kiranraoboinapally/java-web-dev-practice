// Write a program to move all the negative elements to one side of the array.
//- Output: `{-2, -1, 8, 3, 0, 9}`

class negPos 
{
public static void main(String[] args) 
    {
    int a[] = {8, -2, 3, -1, 0, 9};
    for(int i = 0; i < a.length; i++)
        {
        if(a[i] < 0)
            {
            System.out.print(a[i] + " ");
            }
        }
    for(int i = 0; i < a.length; i++)
        {
        if(a[i] >= 0)
            {
            System.out.print(a[i] + " ");
            }
        }
    }    
}
