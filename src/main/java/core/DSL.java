package core;

import static core.DriverFactory.getDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DSL {
	
	/************** Page opening **********************/
	public void opemInitPage() {
		getDriver().get("http://ole-dev-cartao-web.continuousplatform.com/");
	}

	/************** Give title ************************/
	public String title() {
		return getDriver().getTitle();
	}

	/************** interacts with elements ************/
	
	
	/************** obtain texts **********************/
	public String giveTextForXpath(String text) {
		WebElement findElement = giveElementXpath(text, "Visible");
		String text2 = findElement.getText();
		return text2;
	}
	
	public String giveTextForAtributeInXpath(String xpath,String atribute) {
		WebElement findElement = giveElementXpath(xpath, "Visible");
		String text2 = findElement.getAttribute(atribute);
		return text2;
	}
	
	
	/************** find elements ********************/
	public WebElement giveElementXpath(String xpath, String waitType) {
		WebDriverWait wait1 = new WebDriverWait(getDriver(), 30);
		WebElement element1 ;
		
		
		if (waitType.equals("Clickable")) {
			element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		} else if(waitType.equals("Visible")){
			element1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		}  else {
			// else if(waitType.equals("Located"))
			element1 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		}
		return element1;
	}
	
	/************* waits ********************************/
	public void expectDisappear(String xpath) {
		WebDriverWait wait1 = new WebDriverWait(getDriver(), 30);
		wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
	}
}