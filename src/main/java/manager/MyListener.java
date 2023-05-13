package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyListener extends AbstractWebDriverEventListener {

    Logger logger = LoggerFactory.getLogger(MyListener.class);

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        super.beforeFindBy(by, element, driver);
        logger.info("Start searching element by locator " + by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        super.afterFindBy(by, element, driver);
        logger.info("Finish searching element by locator " + by);

    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        super.onException(throwable, driver);
        logger.info("Something went wrong! ");
        logger.info(throwable.getMessage());
        logger.info(throwable.fillInStackTrace().getMessage());
        int i = (int)((System.currentTimeMillis() / 1000) % 3600);
        String link = "src/test/screenshots/screenshot-" + i + ".png";
        new HelperBase(driver).takeScreenShot(link);
        logger.info("Here is the link to screenshot with error " + link);
    }

}
