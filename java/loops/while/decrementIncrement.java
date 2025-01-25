class decrementIncrement {
    public static void main(String[] args) {
        int num=30,start=1,decrement=num/2;

        while (start<=num) 
        { 
            if (num>decrement) 
            {
                System.out.print(num + " ");
                num--;
            } 
            else
            {
                System.out.print(start + " ");
                start++;
            }
        }
    }
}
