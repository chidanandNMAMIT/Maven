package testngListeners;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

//@Listeners(Test_Listener.class)
public class ListenerDemo {
	
	@Test
	public void add() {
		Assert.assertEquals("ram", "ram");
	}

	@Test
	public void substract() {
		Assert.assertEquals("Rama", "ram");
	}
	
	@Test
	public void skiped() {
		throw new SkipException("forcefully skipped");
	}

}
