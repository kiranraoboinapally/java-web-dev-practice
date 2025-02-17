class equalArray2 
{
    public static void main(String args[])
	{
		int[] arrayOne={1,3,2,4,5};
		int[] arrayTwo={3,1,2,5,4};
		boolean equalOrNot = true;
		int temp=0;
		if(arrayOne.length == arrayTwo.length)
		{
			for(int i=0;i<arrayOne.length; i++)
			{
				for(int j=i+1;j<arrayOne.length;j++)
				{
					if(arrayOne[i]>arrayOne[j])
					{
						temp=arrayOne[i];
						arrayOne[i]=arrayOne[j];
						arrayOne[j]=temp;
					}
				}
			}
			for(int i=0;i<arrayTwo.length; i++)
			{
				for(int j=i+1;j<arrayTwo.length;j++)
				{
					if(arrayTwo[i]>arrayTwo[j])
					{
						temp=arrayTwo[i];
						arrayTwo[i]=arrayTwo[j];
						arrayTwo[j]=temp;
					}
				}
			}
			for(int i=0;i<arrayOne.length; i++)
			{
				if(arrayOne[i]!=arrayTwo[i])
				{
					equalOrNot=false;
					break;
				}
			}
		}
		else
		{
			equalOrNot=false;
		}
		if(equalOrNot)
		{
			System.out.println("Two Arrays Are Equal");
		}
		else
		{
			System.out.println("Two Arrays Are Not equal");
		}
	}
}
