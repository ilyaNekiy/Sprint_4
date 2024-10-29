package test;

import org.example.pageobject.OrderPage;
import org.example.pageobject.TrackPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class OrderAttributeValidationTest extends CreateOrderTestData {
    public static final String NAME_COLOR_BLACK_PEARL="чёрный жемчуг";
    public static final String RENTAL_PERIOD_TWO_DAYS="серая безысходность";

    public OrderAttributeValidationTest() {
        // Конструктор по умолчанию для JUnit
    }



    @Test
    public void validateFirstNameOrderAttrTest() {
        OrderPage orderPage = new OrderPage(driver);
        TrackPage trackPage= new TrackPage(driver);
        CreateOrderTestData Order= new CreateOrderTestData();
        Order.createOrderWithAllAttributes(true,METRO_STATION_PAVELECKAYA,DELIVERY_TOMORROW,RENTAL_PERIOD_ONE_DAY,"Домофон не работает",COLOUR_BLACK_PEARL,driver);
        orderPage.clickCheckOrderStatusButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Ожидание до 5 секунд
        wait.until(ExpectedConditions.urlContains("https://qa-scooter.praktikum-services.ru/track?t="));
        Assert.assertEquals("The \"First Name\" attribute on the order tracking page differs from the one specified when creating the order.",getFirstName(),trackPage.getValueFirstNameOrderAttr());
    }
    @Test
    public void validateLastNameOrderAttrTest() {
        OrderPage orderPage = new OrderPage(driver);
        TrackPage trackPage= new TrackPage(driver);
        CreateOrderTestData Order= new CreateOrderTestData();
        Order.createOrderWithAllAttributes(true,METRO_STATION_PAVELECKAYA,DELIVERY_TOMORROW,RENTAL_PERIOD_ONE_DAY,"Домофон не работает",COLOUR_BLACK_PEARL,driver);
        orderPage.clickCheckOrderStatusButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Ожидание до 5 секунд
        wait.until(ExpectedConditions.urlContains("https://qa-scooter.praktikum-services.ru/track?t="));
        Assert.assertEquals("The \"Last Name\" attribute on the order tracking page differs from the one specified when creating the order.",getLastName(),trackPage.getValueLastNameOrderAttr());
    }
    @Test
    public void validateAddressOrderAttrTest() {
        OrderPage orderPage = new OrderPage(driver);
        TrackPage trackPage= new TrackPage(driver);
        CreateOrderTestData Order= new CreateOrderTestData();
        Order.createOrderWithAllAttributes(true,METRO_STATION_PAVELECKAYA,DELIVERY_TOMORROW,RENTAL_PERIOD_ONE_DAY,"Домофон не работает",COLOUR_BLACK_PEARL,driver);
        orderPage.clickCheckOrderStatusButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Ожидание до 5 секунд
        wait.until(ExpectedConditions.urlContains("https://qa-scooter.praktikum-services.ru/track?t="));
        Assert.assertEquals("The \"Address\" attribute on the order tracking page differs from the one specified when creating the order.",getAddress(),trackPage.getValueAddressOrderAttr());
    }
    @Test
    public void validateMetroStationOrderAttrTest() {
        OrderPage orderPage = new OrderPage(driver);
        TrackPage trackPage= new TrackPage(driver);
        CreateOrderTestData Order= new CreateOrderTestData();
        Order.createOrderWithAllAttributes(true,METRO_STATION_PAVELECKAYA,DELIVERY_TOMORROW,RENTAL_PERIOD_ONE_DAY,"Домофон не работает",COLOUR_BLACK_PEARL,driver);
        orderPage.clickCheckOrderStatusButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Ожидание до 5 секунд
        wait.until(ExpectedConditions.urlContains("https://qa-scooter.praktikum-services.ru/track?t="));
        Assert.assertEquals("The \"Metro Station\" attribute on the order tracking page differs from the one specified when creating the order.",METRO_STATION_PAVELECKAYA,trackPage.getValueMetroStationOrderAttr());
    }
    @Test
    public void validateRentalPeriodOrderAttrTest() {
        OrderPage orderPage = new OrderPage(driver);
        TrackPage trackPage= new TrackPage(driver);
        CreateOrderTestData Order= new CreateOrderTestData();
        Order.createOrderWithAllAttributes(true,METRO_STATION_PAVELECKAYA,DELIVERY_TOMORROW,RENTAL_PERIOD_ONE_DAY,"Домофон не работает",COLOUR_BLACK_PEARL,driver);
        orderPage.clickCheckOrderStatusButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Ожидание до 5 секунд
        wait.until(ExpectedConditions.urlContains("https://qa-scooter.praktikum-services.ru/track?t="));
        Assert.assertEquals("The \"Rental Period\" attribute on the order tracking page differs from the one specified when creating the order.",RENTAL_PERIOD_ONE_DAY,trackPage.getRentalPeriodOrderAttr());
    }
    @Test
    public void validateTelephoneNumberOrderAttrTest() {
        OrderPage orderPage = new OrderPage(driver);
        TrackPage trackPage= new TrackPage(driver);
        CreateOrderTestData Order= new CreateOrderTestData();
        Order.createOrderWithAllAttributes(true,METRO_STATION_PAVELECKAYA,DELIVERY_TOMORROW,RENTAL_PERIOD_ONE_DAY,"Домофон не работает",COLOUR_BLACK_PEARL,driver);
        orderPage.clickCheckOrderStatusButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Ожидание до 5 секунд
        wait.until(ExpectedConditions.urlContains("https://qa-scooter.praktikum-services.ru/track?t="));
        Assert.assertEquals("The \"Rental Period\" attribute on the order tracking page differs from the one specified when creating the order.",getTelephoneNumber(),trackPage.getValueTelephoneNumberOrderAttr());
    }
    @Test
    public void validateCommentOrderAttrTest() {
        OrderPage orderPage = new OrderPage(driver);
        TrackPage trackPage= new TrackPage(driver);
        CreateOrderTestData Order= new CreateOrderTestData();
        Order.createOrderWithAllAttributes(true,METRO_STATION_PAVELECKAYA,DELIVERY_TOMORROW,RENTAL_PERIOD_ONE_DAY,"Домофон не работает",COLOUR_BLACK_PEARL,driver);
        orderPage.clickCheckOrderStatusButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Ожидание до 5 секунд
        wait.until(ExpectedConditions.urlContains("https://qa-scooter.praktikum-services.ru/track?t="));
        Assert.assertEquals("The \"Comment\" attribute on the order tracking page differs from the one specified when creating the order.","Домофон не работает",trackPage.getCommentOrderAttr());
    }
    @Test
    public void validateColorOrderAttrTest() {
        OrderPage orderPage = new OrderPage(driver);
        TrackPage trackPage= new TrackPage(driver);
        CreateOrderTestData Order= new CreateOrderTestData();
        Order.createOrderWithAllAttributes(true,METRO_STATION_PAVELECKAYA,DELIVERY_TOMORROW,RENTAL_PERIOD_ONE_DAY,"Домофон не работает",COLOUR_BLACK_PEARL,driver);
        orderPage.clickCheckOrderStatusButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Ожидание до 5 секунд
        wait.until(ExpectedConditions.urlContains("https://qa-scooter.praktikum-services.ru/track?t="));
        Assert.assertEquals("The \"Color\" attribute on the order tracking page differs from the one specified when creating the order.",NAME_COLOR_BLACK_PEARL,trackPage.getColourOrderAttr());
    }



}

