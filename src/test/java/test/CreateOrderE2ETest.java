package test;


import org.example.pageobject.OrderPage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


    @RunWith(Parameterized.class)
    public class CreateOrderE2ETest extends CreateOrderTestData{
        private final String metroStation;
        private final int deliveryDate;
        private final String rentalPeriod;
        private final String comment;
        private final boolean isBlackColour;


        public CreateOrderE2ETest(String metroStation, int deliveryDate, String rentalPeriod, String comment, boolean isBlackColour) {
            super(metroStation, deliveryDate, rentalPeriod, comment, isBlackColour);
                this.metroStation = metroStation;
                this.deliveryDate = deliveryDate;
                this.rentalPeriod = rentalPeriod;
                this.comment = comment;
                this.isBlackColour = isBlackColour;
        }

        @Parameterized.Parameters
        public static Object[][] ListOfInputOrderAttr() {
            return new Object[][]{
                    {METRO_STATION_PAVELECKAYA,DELIVERY_TOMORROW ,RENTAL_PERIOD_ONE_DAY,"Домофон не работает",COLOUR_BLACK_PEARL},
                    {METRO_STATION_LUBYANKA,DELIVERY_AFTER_TWO_DAYS ,RENTAL_PERIOD_TWO_DAYS,"Просьба курьеру позвонить заранее",COLOUR_GRAY_HOPELESSNESS},
                    {METRO_STATION_PAVELECKAYA,DELIVERY_AFTER_THREE_DAYS ,RENTAL_PERIOD_THREE_DAYS,"Дополнительный номер для связи +79200332454",COLOUR_BLACK_PEARL},
            };
        }


        @Test
        public void createOrderTopOrderButtonWithAllAttrTest() {
            OrderPage orderPage = new OrderPage(driver);
            String orderId=createOrderWithAllAttributes (true,metroStation,deliveryDate,rentalPeriod,comment,isBlackColour,driver);
            orderPage.clickCheckOrderStatusButton();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Ожидание до 5 секунд
            wait.until(ExpectedConditions.urlContains("https://qa-scooter.praktikum-services.ru/track?t="));
            Assert.assertEquals("Order status page is not open after order creation",driver.getCurrentUrl(),String.format("https://qa-scooter.praktikum-services.ru/track?t=%s",orderId));
        }
        @Test
        public void createOrderLowOrderButtonWithAllAttrTest()  {
            OrderPage orderPage = new OrderPage(driver);
            String orderId=createOrderWithAllAttributes (false,metroStation,deliveryDate,rentalPeriod,comment,isBlackColour,driver);
            orderPage.clickCheckOrderStatusButton();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Ожидание до 5 секунд
            wait.until(ExpectedConditions.urlContains("https://qa-scooter.praktikum-services.ru/track?t="));
            Assert.assertEquals("Order status page is not open after order creation",driver.getCurrentUrl(),String.format("https://qa-scooter.praktikum-services.ru/track?t=%s",orderId));

        }




    }

