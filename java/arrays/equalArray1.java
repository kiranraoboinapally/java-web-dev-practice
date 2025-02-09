import java.util.Arrays;
class equalArray1 
{
public static void main(String[] args) 
    {
        int[] arrayOne = {2,5,1,7,4};
        int[] arrayTwo = {1,2,4,7,5};
        if(arrayOne.length==arrayTwo.length)
            {
            Arrays.sort(arrayOne);
            Arrays.sort(arrayTwo);
            boolean equalOrNot = Arrays.equals(arrayOne, arrayTwo);
            if (equalOrNot)
                System.out.println("Two arrays are equal.");
            else
                System.out.println("Two arrays are not equal.");
            }
        else
            System.out.println("Arrays are not equal");
    }    
}
