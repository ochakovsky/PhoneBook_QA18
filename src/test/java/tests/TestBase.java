package tests;

import manager.ApplicationManager;
import manager.NGListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.lang.reflect.Method;

@Listeners(NGListener.class)
public class TestBase {
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    //    WebDriver wd;
    public static ApplicationManager app = new ApplicationManager();

    @BeforeSuite
    public void setup() {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
//        wd.quit();
     //   app.stop();
    }

    @BeforeMethod
    public void started(Method method) {
        logger.info("          ##### Start test " + method.getName());
    }

    @AfterMethod
    public void finished() {
        logger.info("          ########## Finished ########## ");
    }
}
