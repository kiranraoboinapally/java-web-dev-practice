//divide array into two equal halves 
//sort odd indexed arrays in ascending order and even indexed arrays in descedning order
//7 5 2 9 10 ascend it 2 5 7 9 10 and 8 1 6 3 4 descend it 8 6 4 3 1
//ouput as 2 5 7 9 10 8 6 4 3 1

class p9
{
public static void main(String args[])
	{
	int a[]=new int[]{8,7,1,5,6,2,3,9,4,10};//5 7 2 9 10
	int size=a.length;
	int a_size=0;
	if(size%2!=0)
	a_size=(size/2)+1;
	else
	a_size=size/2;//5
	for(int x=0;x<=a_size;x++)
		{//0<=5
		if(x%2!=0)
			{
			if(a[x]>a[x+2])
				{
				
				}
			}
		}
	}
}