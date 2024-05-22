package annotationspractise;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Configurationannotation extends BaseClass{
	
	
	
	@Test
	public void toCreateContact() {
		System.out.println("contact is created");
	}
	
	@Test
	public void toDeleteContact() {
		System.out.println("contact is deleted");
	}
	


}
