import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{
//    WebDriver wd;

    @BeforeMethod
    public void perCondition(){
        if(isLogged()){
            logout();
        }
    }
//    public void init(){
//        wd = new ChromeDriver();
//        wd.navigate().to("https://telranedu.web.app/home");
//        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//    }

    @Test
    public void regPositiveTest(){

//        1. open login/registration form
        openLoginRegistrationForm();
//        WebElement loginBtn = wd.findElement(By.xpath("//a[@href='/login']"));
//        loginBtn.click();
//        2. fill login/registration form
        int i = (int)(System.currentTimeMillis() / 1000) % 3600;
        String email = "qwerty" + i + "@ytrewq.com";
        String password = "Aa123456$";
        fillLoginRegistrationForm(email, password);

//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("qwerty" + i + "@ytrewq.com");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("Aa123456$");
//
//        3. submit by click registration button
        submitRegistration();
//        wd.findElement(By.xpath("//button[2]")).click();

//        pause(10000);

//        4. assert
        Assert.assertTrue(wd.findElement(By.xpath("//a[text()='ADD']")).getText().equals("ADD"));
    }

//    public void pause(int time){
////        try {
////            Thread.sleep(time);
////        } catch (InterruptedException e) {
////            throw new RuntimeException(e);
////        }
//
////        FluentWait<WebDriver> wait = new FluentWait<>(wd);
////        wait.withTimeout(Duration.ofMillis(time));
//    }
    @Test
    public void registrationWrongEmail(){

//        1. open login/registration form
//        openLoginRegistrationForm();
        WebElement loginBtn = wd.findElement(By.xpath("//a[@href='/login']"));
        loginBtn.click();
//        2. fill login/registration form
        int i = (int)(System.currentTimeMillis() / 1000) % 3600;
        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("qwerty" + i + "ytrewq.com");

        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
        passInput.click();
        passInput.clear();
        passInput.sendKeys("Aa123456$");
//        3. submit by click registration button
        wd.findElement(By.xpath("//button[2]")).click();
//        4. assert
//        Assert.assertTrue(wd.findElement(By.xpath("//a[text()='ADD']")).getText().equals("ADD"));
    }

    @AfterMethod
    public void tearDown(){
        wd.quit();
    }

}
