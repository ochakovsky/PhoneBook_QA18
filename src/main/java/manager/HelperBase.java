package manager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {

    WebDriver wd;

    public HelperBase(WebDriver wb) {
        this.wd = wb;
    }

    public void type(By locator, String text){
        if(text != null){
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }

    public void click(By locator){
        wd.findElement(locator).click();
    }

    public boolean isElementPresent(By locator){
        return (wd.findElements(locator).size() > 0);
    }

    public void pause(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        FluentWait<WebDriver> wait = new FluentWait<>(wd);
//        wait.withTimeout(Duration.ofMillis(time));
    }

    public void openLoginRegistrationForm(){
//        wd.findElement(By.xpath("//a[@href='/login']")).click();
        click(By.xpath("//a[@href='/login']"));
    }

    public boolean isAlertTextCorrect(String text) {
        Alert alert = new WebDriverWait(wd, 15).until(ExpectedConditions.alertIsPresent());
        if (alert == null)
            return false;
        else {
            wd.switchTo().alert();
        }
        return alert.getText().contains(text);
    }
}
