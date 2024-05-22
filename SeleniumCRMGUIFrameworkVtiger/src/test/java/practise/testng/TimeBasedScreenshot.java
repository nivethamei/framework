package practise.testng;



import java.util.Date;

public class TimeBasedScreenshot {
	
	public static void main(String[] args) {
	String datetime = new Date().toString().replace(":", "_").replace(" ","_");
	System.out.println(datetime);
	
	}

}
