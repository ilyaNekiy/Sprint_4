package test;

import org.example.pageobject.MainPage;
import org.example.pageobject.OrderPage;
import org.junit.Assert;
import org.junit.Test;


public class ErrorHandlingInputAttributesTest extends BaseUITest {
    private static final String ERROR_MESSAGE_TEXT_FIRST_NAME_INPUT="Введите корректное имя";
    private static final String ERROR_MESSAGE_TEXT_SECOND_NAME_INPUT="Введите корректную фамилию";
    private static final String ERROR_MESSAGE_TEXT_ADDRESS_INPUT="Введите корректный адрес";
    private static final String ERROR_MESSAGE_TEXT_TELEPHONE_NUMBER_INPUT="Введите корректный номер";

    @Test
    public void errorHandlingInputFirstNameTest() {
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        mainPage.openMainPage();
        mainPage.clickCookieButtonMessage();
        mainPage.clickTopOrderButton();
        orderPage.setFirstNameInput("21321");
        orderPage.clickHeaderLogo ();
        Assert.assertEquals("Error message text is wrong",orderPage.getErrorInputFirstNameText(),ERROR_MESSAGE_TEXT_FIRST_NAME_INPUT);
    }
    @Test
    public void errorHandlingInputSecondNameTest() {
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        mainPage.openMainPage();
        mainPage.clickCookieButtonMessage();
        mainPage.clickTopOrderButton();
        orderPage.setSecondNameInput("432423");
        orderPage.clickHeaderLogo ();
        Assert.assertEquals("Error message text is wrong",orderPage.getErrorInputSecondNameText(),ERROR_MESSAGE_TEXT_SECOND_NAME_INPUT);

    }
    @Test
    public void errorHandlingInputAddressTest() {
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        mainPage.openMainPage();
        mainPage.clickCookieButtonMessage();
        mainPage.clickTopOrderButton();
        orderPage.setAddressInput("-");
        orderPage.clickHeaderLogo ();
        Assert.assertEquals("Error message text is wrong",orderPage.getErrorInputAddressText(),ERROR_MESSAGE_TEXT_ADDRESS_INPUT);

    }
    @Test
    public void errorHandlingInputTelephoneTest() {
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        mainPage.openMainPage();
        mainPage.clickCookieButtonMessage();
        mainPage.clickTopOrderButton();
        orderPage.setTelephonNumberInput("1234567890");
        orderPage.clickHeaderLogo ();
        Assert.assertEquals("Error message text is wrong",orderPage.getErrorTelephoneNumberText(),ERROR_MESSAGE_TEXT_TELEPHONE_NUMBER_INPUT);
    }

}
