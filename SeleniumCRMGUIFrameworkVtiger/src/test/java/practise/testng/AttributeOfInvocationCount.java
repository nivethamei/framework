package practise.testng;

import org.testng.annotations.Test;

public class AttributeOfInvocationCount {

	@Test(alwaysRun = false)
	public void CreateOrder()
	{
		System.out.println("order is created ====>executed");
	}
	
	
	@Test(invocationCount = 2)
	public void PaymentOrder()
	{
		System.out.println("Payment process is done ====>executed");
	}
	
	@Test(invocationCount = 1)
	public void BillOrder()
	{
		System.out.println("billing process is done ====>executed");
	}
	

}
