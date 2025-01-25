class Product
{
	public static void main(String args[])
	{
		String name="Pen";
		char code='P';
		int price=40;
		int quantity=4;
		Product product=new Product();
		int beforeDiscountTotal;
		double discount;
		double afterDiscountTotal;
		double sumTotal;
		double res=product.beforeDiscountTotal(price,quantity);
		System.out.println(res);
		double res1=product.discount(res);
		System.out.println(res1);
		double res2=product.afterDiscountTotal(res,res1);
		System.out.println(product.calGST(res1));
		
	}
void Product(String name,char code,int price,int quantity)
	{
		System.out.println("product name is "+name);
		System.out.println("product code is "+code);
		System.out.println("product price is "+price);
		System.out.println("product quantity is "+quantity);
	}
double beforeDiscountTotal(int price,int quantity)
	{
		int beforeDiscountTotal=price*quantity;
		return beforeDiscountTotal;
	}
double discount(double beforeDiscountTotal)
	{
	if(beforeDiscountTotal>=20 && beforeDiscountTotal<=30)
		{
		double discount=15/100*beforeDiscountTotal;
		return discount;
		}
	else if(beforeDiscountTotal>30 && beforeDiscountTotal<=40)
		{
		double discount=20.0/100*beforeDiscountTotal;
		return discount;
		}
	else	
		{
		int discount=0;
		return discount;
		}
	}
double afterDiscountTotal(double beforeDiscountTotal,double discount)
	{
	double total=beforeDiscountTotal-discount;
	return total;
	}
double calGST(double total)
	{
	double calGST=19.0/100*total;
	return calGST;
	}
double sumTotal(double total,double calGST)
	{
	double sumTotal=total+calGST;
	return sumTotal;
	}
}