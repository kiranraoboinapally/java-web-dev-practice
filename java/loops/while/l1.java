class l1{
    public static void main(String[] args){
        int start=10,end=20,last=0;
        while(start<end){
            last=start%10;
            System.out.println(start+"'s Last digit is "+last);
            start++;
        }
    }
}