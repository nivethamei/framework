package practise.testng;

import org.testng.annotations.Test;

public class AttributesOfPriority {
	
	@Test(priority = 1)
	public void CreateOrder()
	{
		System.out.println("order is created ====>executed");
	}
	
	 final int a=5;
	@Test(priority = a)
	public void PaymentOrder()
	{
		System.out.println("Payment process is done ====>executed");
	}
	
	@Test(priority = 2)
	public void BillOrder()
	{
		System.out.println("billing process is done ====>executed");
	}
	public static void main(String[] args)
	{
		System.out.println("main method is done");
	}
	
	
	
	

}
