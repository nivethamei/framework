package practise.testng;

import static org.junit.Assert.fail;

import org.testng.annotations.Test;

public class AttributeOfDependsOnMethods {
	@Test
	public void CreateOrder()
	{
		System.out.println("order is created ====>executed");
	}
	
	
	@Test(dependsOnMethods = "BillOrder")
	public void PaymentOrder()
	{
		System.out.println("Payment process is done ====>executed");
	}
	
	@Test(dependsOnMethods = "CreateOrder")
	public void BillOrder()
	{
		System.out.println("billing process is done ====>executed");
	}
	

}
