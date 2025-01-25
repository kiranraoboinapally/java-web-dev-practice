class splitSum 
{
    public static void main(String[] args)
    {
        int num=456787,count=0,powe=0,first=0,last=0,temp=num,sum=0;
        for(;num!=0;num/=10)
        {
            int rem=num%10;
            count++;
        }
        powe=(int)Math.pow(10,count/2);
        first=temp/powe;
        last=temp%powe;
        sum=first+last;
        System.out.println(sum);
    }    
}
