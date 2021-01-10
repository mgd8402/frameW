
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.lang.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class HelloWebDriver {
    @Test
    public void test()throws Exception {
        WebDriver driver = new OperaDriver();
        driver.get("https://triumph.granmoto.ru");
        WebElement Ekipirovka = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//header[@class='headroom-disabled']//child::a[text()='Экипировка и тюнинг']")));
        Ekipirovka.click();
        WebElement e1 = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='ПОСМОТРЕТЬ ЭКИПИРОВКУ']")));
        e1.click();
        WebElement e2 = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Ботинки мужские']")));
        e2.click();
        WebElement e3 = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Ботинки RSD Fresno gum']")));
        e3.click();
        WebElement e4 = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='quantity']")));
        e4.sendKeys(Keys.BACK_SPACE);
        e4.sendKeys("3");

        WebElement e5 = new WebDriverWait(driver,10)

                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type='submit'and text()='В корзину']")));

        e5.click();
        new WebDriverWait(driver,10).until(CustomConditions.jQueryAJAXsCompleted());
        WebElement e6 = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span [@class='title']")));

        e6.click();

        WebElement e7= new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a [@class='name']")));
       String itog = e7.getText();
       String itogg = "Ботинки RSD Fresno gum - 43/10 (0810-0300-3968)";
       Assert.assertTrue("mgd",itogg.equals(itog));


        driver.quit();

    }
}
