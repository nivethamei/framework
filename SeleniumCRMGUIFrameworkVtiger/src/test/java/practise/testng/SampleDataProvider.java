package practise.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleDataProvider {
	
	
	@Test(dataProvider="getContactData")
	public void createContactData(String firstname,String lastname) {
		
		System.out.println("firstname :"+firstname +" lastname:"+lastname);
	}
	
	@DataProvider
	public Object [][] getContactData(){
		
		Object[][]objarr=new Object[2][2];
		objarr[0][0]="nivetha";
		objarr[0][1]="shanmugham";
		
		objarr[1][0]="aadhira";
		objarr[1][1]="mei";
		
		return objarr;
	}
	
	
	

}
