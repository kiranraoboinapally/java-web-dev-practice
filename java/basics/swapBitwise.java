class swapBitwise 
{
    public static void main(String[] args) 
    {
        int a = 10, b = 20;      // Initialization of two variables
        System.out.println("Before Swapping a and b values are " + a + " and " + b);

        // a = a ^ b
        // XOR each bit of 'a' with 'b' and store the result in 'a'
        // In binary: a = 10 (1010) and b = 20 (10100)
        // a ^ b will give a result where bits that are different in 'a' and 'b' are set to 1.
        // a = 10 (1010) ^ 20 (10100) -> Result is 30 (11110)
        a = a ^ b;//a+b=30

        // b = a ^ b
        // XOR the current value of 'a' (which is now 30) with 'b'
        // In binary: a = 30 (11110) and b = 20 (10100)
        // a ^ b will give the original value of 'a' because XOR'ing with the same number results in zero.
        // b = 30 (11110) ^ 20 (10100) -> Result is 10 (1010)
        b = a ^ b;//a-b=10

        // a = a ^ b
        // XOR the current value of 'a' (which is now 30) with the new value of 'b' (which is 10)
        // In binary: a = 30 (11110) and b = 10 (1010)
        // a ^ b will give the original value of 'b' because XOR'ing with the same number results in zero.
        // a = 30 (11110) ^ 10 (1010) -> Result is 20 (10100)
        a = a ^ b;//a-b=20

        System.out.println("After Swapping a and b values are " + a + " and " + b);
    }    
}
