package org.example.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class TrackPage {
    protected WebDriver driver;
    private By notFoundImg = By.xpath(".//div[contains(@class,'Track_NotFound')]/img");
    private By idOfOrderInputText = By.xpath(".//input[contains(@class,'Input_Filled')]");//value надо брать
    private static final String FIRST_NAME_ORDER_ATTR_NAME= "Имя";
    private static final String LAST_NAME_ORDER_ATTR_NAME= "Фамилия";
    private static final String ADDRESS_ORDER_ATTR_NAME= "Адрес";
    private static final String METRO_STATION_ORDER_ATTR_NAME= "Станция метро";
    private static final String TELEPHONE_NUMBER_ORDER_ATTR_NAME= "Телефон";
    private static final String DELIVERY_DATE_ORDER_ATTR_NAME= "Дата доставки";
    private static final String RENTAL_PERIOD_ORDER_ATTR_NAME= "Срок аренды";
    private static final String COLOUR_ORDER_ATTR_NAME= "Цвет";
    private static final String COMMENT_ORDER_ATTR_NAME= "Комментарий";
    private static final String ORDER_ATTRIBUTES_PATTERN=".//div[contains(text(),'%s')]/parent::*/div[contains(@class,'Track_Value')]";

    public String getValueOrderAttrTemplate(String orderAttrName){
        String orderAttrValueLocator =String.format(ORDER_ATTRIBUTES_PATTERN,orderAttrName);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(orderAttrValueLocator)));
        return driver.findElement(By.xpath(orderAttrValueLocator)).getText();
    }


    public  TrackPage (WebDriver driver){
        this.driver=driver;
    }

    public boolean isDisplayedFoundOrderImg(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(notFoundImg));
        return notFoundImg.findElement(driver).isDisplayed();
    }
    public String getValueFirstNameOrderAttr(){
        return getValueOrderAttrTemplate(FIRST_NAME_ORDER_ATTR_NAME);
    }
    public String getValueLastNameOrderAttr(){
        return getValueOrderAttrTemplate(LAST_NAME_ORDER_ATTR_NAME);
    }
    public String getValueAddressOrderAttr(){
        return getValueOrderAttrTemplate(ADDRESS_ORDER_ATTR_NAME);
    }
    public String getValueMetroStationOrderAttr(){
        return getValueOrderAttrTemplate(METRO_STATION_ORDER_ATTR_NAME);
    }
    public String getValueTelephoneNumberOrderAttr(){
        return getValueOrderAttrTemplate(TELEPHONE_NUMBER_ORDER_ATTR_NAME);
    }
    public String getDeliveryDateOrderAttr(){
        return getValueOrderAttrTemplate(DELIVERY_DATE_ORDER_ATTR_NAME);
    }
    public String getRentalPeriodOrderAttr(){
        return getValueOrderAttrTemplate(RENTAL_PERIOD_ORDER_ATTR_NAME);
    }
    public String getColourOrderAttr(){
        return getValueOrderAttrTemplate(COLOUR_ORDER_ATTR_NAME);
    }
    public String getCommentOrderAttr() {
        return getValueOrderAttrTemplate(COMMENT_ORDER_ATTR_NAME);
    }

    }
