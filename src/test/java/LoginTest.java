import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @Test
    public void loginPositiveTest(){
        String email = "qwerty@ytrewq.com";
        String password = "Aa123456$";
        openLoginRegistrationForm();
        fillLoginRegistrationForm(email, password);
        submitLogin();
    }
}
