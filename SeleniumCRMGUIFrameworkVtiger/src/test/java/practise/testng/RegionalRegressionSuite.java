package practise.testng;

import org.testng.annotations.Test;

public class RegionalRegressionSuite {
	
	@Test
	public void CreateOrder()
	{
		System.out.println("order is created ====>executed");
	}
	
	
	@Test
	public void PaymentOrder()
	{
		System.out.println("Payment process is done ====>executed");
	}
	
	@Test
	public void BillOrder()
	{
		System.out.println("billing process is done ====>executed");
	}
	

}
