int a[]={1,2,3,4,5,6,7,8,9};
int x,temp=a[a.length-1],r=1,k=5;
for(x=a.length-1;r<=k;)
{
if(x>0)
{
a[x]=a[x-1];
x--;
}
else if(x==0)
{
a[x]=temp;
r++;
temp=a[a.length-1];
x=a.lenggh-1;
}
}
for(int t:a)
System.out.println(t+" ");
System out.println();