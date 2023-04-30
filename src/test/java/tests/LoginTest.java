package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void loginPositiveTest(){

        // new User().
        User user = User.builder()
                .email("qwerty@ytrewq.com")
                .password("Aa123456$")
                .build();

//        String email = "qwerty@ytrewq.com";
//        String password = "Aa123456$";
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isLogged());
    }

    @Test
    public void loginNegativeTestWrongEmail(){
        User user = User.builder()
                .email("qwertyytrewq.com")
                .password("Aa123456$")
                .build();
//        String email = "qwertyytrewq.com";
//        String password = "Aa123456$";
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitLogin();
    }

}
