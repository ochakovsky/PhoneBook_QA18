package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void loginPositiveTest(){
        String email = "qwerty@ytrewq.com";
        String password = "Aa123456$";
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(email, password);
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isLogged());
    }

    @Test
    public void loginNegativeTestWrongEmail(){
        String email = "qwertyytrewq.com";
        String password = "Aa123456$";
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(email, password);
        app.getUser().submitLogin();
    }

}
