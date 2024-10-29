package test;

import org.example.pageobject.MainPage;
import org.example.pageobject.OrderPage;
import org.openqa.selenium.WebDriver;
import java.time.LocalDate;

public class CreateOrderTestData extends BaseUITest{
    private  String metroStation;
    private int deliveryDate;
    private  String rentalPeriod;
    private  String comment;
    private  boolean isBlackColour;
    private String firstName=generateRussianLetterId();
    private String secondName=generateRussianLetterId();
    private String adress=generateRussianLetterId()+"д.47 кв12";
    private String telephoneNumber=generateRandomRusPhoneNumber();
    public static final String RENTAL_PERIOD_ONE_DAY="сутки";
    public static final String RENTAL_PERIOD_TWO_DAYS="двое суток";
    public static final String RENTAL_PERIOD_THREE_DAYS="трое суток";
    public static final String RENTAL_PERIOD_FOUR_DAYS="четверо суток";
    public static final String RENTAL_PERIOD_FIVE_DAYS="пятеро суток";
    public static final String RENTAL_PERIOD_SIX_DAYS="шестеро суток";
    public static final String RENTAL_PERIOD_SEVEN_DAYS="семеро суток";
    public static final String METRO_STATION_LUBYANKA="Лубянка";
    public static final String METRO_STATION_PAVELECKAYA="Павелецкая";
    public static final int DELIVERY_TOMORROW=1;
    public static final int DELIVERY_AFTER_TWO_DAYS=2;
    public static final int DELIVERY_AFTER_THREE_DAYS=3;
    public static final boolean COLOUR_BLACK_PEARL=true;
    public static final boolean COLOUR_GRAY_HOPELESSNESS=false;
    public CreateOrderTestData() {
        // Конструктор по умолчанию для JUnit
    }


    public CreateOrderTestData(String metroStation, int deliveryDate, String rentalPeriod, String comment,boolean isBlackColour) {
        this.metroStation=metroStation;
        this.deliveryDate = deliveryDate;
        this.rentalPeriod = rentalPeriod;
        this.comment = comment;
        this.isBlackColour=isBlackColour;

    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return secondName;
    }
    public String getAddress(){
        return adress;
    }
    public String getTelephoneNumber(){
        return telephoneNumber;
    }


    public  String createOrderWithAllAttributes(boolean useTopOrderButton, String metroStation, int deliveryDate, String rentalPeriod, String comment, boolean isBlackColour, WebDriver driver){
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        mainPage.openMainPage();
        mainPage.clickCookieButtonMessage();
        if (useTopOrderButton)
        {
            mainPage.clickTopOrderButton();
        }
        else
        {
            mainPage.clickLowOrderButton();
        }
        orderPage.setFirstNameInput(firstName);
        orderPage.setSecondNameInput(secondName);
        orderPage.setAddressInput(adress);
        orderPage.setMetroStationByName(metroStation);
        orderPage.setTelephonNumberInput(telephoneNumber);
        orderPage.clickNextButton();
        String deliveryData = LocalDate.now().plusDays(deliveryDate).toString();
        orderPage.selectDeliveryDate(deliveryData);
        orderPage.setRentalPeriod(rentalPeriod);
        if (isBlackColour)
        {
            orderPage.clickBlackColourScooterButton();
        }
        else
        {
            orderPage.clickGreyColourScooterButton();
        }
        orderPage.setCommentForDeliveryInput(comment);
        orderPage.clickOrderButton();
        orderPage.clickConfirmOrderButton ();
        return orderPage.getOrderIdByText(orderPage.getOrderCreationFinalText());
    }


}
