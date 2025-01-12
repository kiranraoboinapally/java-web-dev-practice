class reverseStoringAB 
{
    public static void main(String[] args) {
        int[] a={10, 20, 30, 40, 50};
        int[] b=new int[a.length];
        for(int x=0;x<a.length;x++)
        {
            b[a.length-1-x]=a[x]; // or by taking two variables x and y into account x from 0 increments and y from a.length decrements
        }
        for(int x=0;x<b.length;x++)
        {
            System.out.println(b[x]);
        }
    }    
}
