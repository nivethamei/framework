package annotationspractise;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	
	@BeforeSuite
	public void createBSmethod() {
		System.out.println("connect to database");
	}
	
	
	@org.testng.annotations.BeforeClass
	public void createBCmethod() {
		System.out.println("launching the browser");
	}
	@BeforeMethod
	public void createBMmethod() {
		System.out.println("login the application");
	}

	

	@AfterMethod
	public void createAMmethod() {
		System.out.println("logout the application");
	}
	
	@org.testng.annotations.AfterClass
	public void createACmethod() {
		System.out.println("closing the browser");
	}
	@AfterSuite
	public void createAsmethod() {
		System.out.println("disconnect to database");
	}

}
