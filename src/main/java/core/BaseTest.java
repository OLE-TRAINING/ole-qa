package core;
import static core.DriverFactory.killDriver;
import org.junit.After;

public class BaseTest {
	
	@After
	public void ends() {
		if(Properties.FECHAR_BROWSER) {
			killDriver();
		}
	}
	
	
	
	
}
