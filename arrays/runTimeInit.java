class runTimeInit
{
    public static void main(String[] args) {
        int[] arr = new int[1000000];
        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        long end = System.currentTimeMillis();
        System.out.println("Time taken to run the loop: " + (end - start) + "ms");
    }
}
