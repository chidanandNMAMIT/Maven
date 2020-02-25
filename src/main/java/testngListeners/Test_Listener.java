package testngListeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Test_Listener implements ITestListener{

	public void onFinish(ITestContext result) {
		System.out.println(" Test  finished "+ result.getName());
		
	}

	public void onStart(ITestContext result) {
		System.out.println(" Test  started " +result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(" Test  failed "+ result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println(" Test  failure "+result.getName());	
		
	}

	public void onTestSkipped(ITestResult result)  {
		System.out.println(" Test  skipped "+result.getName());
		
	}

	
	public void onTestStart(ITestResult result) {
		System.out.println(" Test is onStart "+result.getName());
		
	}

	
	public void onTestSuccess(ITestResult result) {
		System.out.println(" Test  success "+result.getName());
		
	}
	
	

}
