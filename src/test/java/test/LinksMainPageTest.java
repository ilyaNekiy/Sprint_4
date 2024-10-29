package test;

import org.example.pageobject.MainPage;
import org.example.pageobject.OrderPage;
import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

import static org.example.pageobject.MainPage.MAIN_PAGE_URL;
import static org.example.pageobject.OrderPage.ORDER_PAGE_URL;

public class LinksMainPageTest extends BaseUITest{

    @Test
    public void checkLinkAfterClickSсooterLogoTest (){
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        mainPage.openMainPage();
        mainPage.clickCookieButtonMessage();
        mainPage.clickTopOrderButton();
        if(driver.getCurrentUrl()==ORDER_PAGE_URL) {
            orderPage.clickScooterLogo();
            Assert.assertEquals("Is not default page", driver.getCurrentUrl(), MAIN_PAGE_URL);
        }
        else
        {
            System.out.println("Couldn't open order page");
        }
    }
    @Test
    public void checkLinkAfterClickYandexLogoTest () throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickCookieButtonMessage();
        // Сохранение идентификатора текущего окна
        String originalWindow = driver.getWindowHandle();
        String oldUrl = driver.getCurrentUrl();
        mainPage.clickYandexLogo();
        Thread.sleep(5000);

        // Ожидание открытия нового окна
        Set<String> windows = driver.getWindowHandles();
        String newWindowHandle = null;
        for (String window : windows) {
            if (!window.equals(originalWindow)) {
                newWindowHandle = window;
                break;
            }
        }

            // Переключение на новое окно
            driver.switchTo().window(newWindowHandle);

            // Проверка URL нового окна
            String currentUrl = driver.getCurrentUrl();



            Assert.assertEquals("Is not expected page", "https://yandex.ru", currentUrl);



    }
}
