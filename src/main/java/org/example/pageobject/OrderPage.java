package org.example.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class OrderPage {
    protected WebDriver driver;

    private By firstNameInput=By.xpath(".//input[contains(@placeholder,'Имя')]");
    private By secondNameInput=By.xpath(".//input[contains(@placeholder,'Фамилия')]");
    private By deliveryAddresInput=By.xpath(".//input[contains(@placeholder,'Адрес')]");
    private By telephonNumberInput= By.xpath(".//input[contains(@placeholder,'Телефон')]");
    private By errorTextFirstNameInput=By.xpath(".//input[contains(@placeholder,'Имя')]/parent::*/div[contains(@class,'Input_ErrorMessage')]");
    private By errorTextSecondNameInput=By.xpath(".//input[contains(@placeholder,'Фамилия')]/parent::*/div[contains(@class,'Input_ErrorMessage')]");
    private By errorTextDeliveryAddresInput=By.xpath(".//input[contains(@placeholder,'Адрес')]/parent::*/div[contains(@class,'Input_ErrorMessage')]");
    private By errorTextTelephonNumberInput= By.xpath(".//input[contains(@placeholder,'Телефон')]/parent::*/div[contains(@class,'Input_ErrorMessage')]");
    private By nextButton =By.xpath(".//button[contains(@class,'Button_Button') and contains(@class,'Button_Middle')]");
    private By orderButton=By.xpath(".//div[contains(@class,'Order_Button')]/button[not(contains(@class,'Button_Inverted'))]");
    private By confirmOrderButton=By.xpath(".//div[contains(@class,'Order_Modal')]/*/button[not (contains(@class,'Button_Inverted'))]");
    private By backButton=By.xpath(".//div[contains(@class,'Order_Button')]/button[contains(@class,'Button_Inverted')]");
    private By headerLogo=By.xpath(".//div[contains(@class,'Order_Header')]");
    private By rentalPeriodInput=By.xpath(".//div[contains(@class,'Dropdown-root')]");
    private By blackColourScooterButton= By.xpath(".//label[contains(@for,'black')]");
    private By greyColourScooterButton= By.xpath(".//label[contains(@for,'grey')]");
    private By commentForDelivaryInput=By.xpath(".//div[contains(@class,'Input_InputContainer')]/input[contains(@class,'Input_Responsible')]");
    private By deliveryDateInput= By.xpath(".//input[contains(@placeholder,'Когда привезти самокат')]");
    private By deliveryDateDataPicker =By.xpath(".//div[@contains(@class,'datepicker__day--selected')]");
    private By metroSelectInput = By.xpath(".//input[contains(@class,'select-search')]");
    private By metroSearchSelect = By.className("select-search__select");
    private By headerOrderText = By.xpath(".//div[contains(@class,'Order_Header')]");
    private By checkOrderStatusButton = By.xpath(".//div[contains(@class,'Order_NextButton')]/button");
    private By orderCreationFinalText = By.xpath(".//div[contains(@class,'Order_Text')]");
    private By scooterLogo = By.xpath(".//img[@alt='Scooter']");
    private static final String RENTAL_PERIOD_PATTERN=".//div[contains(@class,'Dropdown-option') and contains(text(),'%s')]";
    public static final String ORDER_PAGE_URL="https://qa-scooter.praktikum-services.ru/order";



    public void setMetroStationByName(String metroName) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(metroSelectInput));
        driver.findElement(metroSelectInput).sendKeys(metroName);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(metroSearchSelect));
        driver.findElement(metroSearchSelect).click();
    }

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectDeliveryDate (String date){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(deliveryDateInput));
        driver.findElement(deliveryDateInput).sendKeys(date);
        driver.findElement(headerOrderText).click();
    }
    public void selectDeliveryDateJS(String date){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(deliveryDateInput));
        WebElement deliveryDateElement = driver.findElement(deliveryDateInput);
        ((JavascriptExecutor)driver).executeScript("arguments[0].value=arguments[1]",deliveryDateElement,date);
    }
    public void setFirstNameInput(String firstNameValue){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(firstNameInput));
        WebElement orderNumberWebElement=driver.findElement(firstNameInput);
        orderNumberWebElement.clear();
        driver.findElement(firstNameInput).sendKeys(firstNameValue);
    }
    public void setSecondNameInput(String secondNameValue){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(secondNameInput));
        WebElement orderNumberWebElement=driver.findElement(secondNameInput);
        orderNumberWebElement.clear();
        driver.findElement(secondNameInput).sendKeys(secondNameValue);
    }
    public void setAddressInput(String addressValue){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(deliveryAddresInput));
        WebElement orderNumberWebElement=driver.findElement(deliveryAddresInput);
        orderNumberWebElement.clear();
        driver.findElement(deliveryAddresInput).sendKeys(addressValue);
    }
    public void setTelephonNumberInput(String TelephonNumberValue){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(telephonNumberInput));
        WebElement orderNumberWebElement=driver.findElement(telephonNumberInput);
        orderNumberWebElement.clear();
        driver.findElement(telephonNumberInput).sendKeys(TelephonNumberValue);
    }
    public void clickNextButton (){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(nextButton));
        driver.findElement(nextButton).click();
    }

    public void clickRentalPeriodInput (){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(rentalPeriodInput));
        driver.findElement(rentalPeriodInput).click();
    }
    public void setRentalPeriod(String RentalPeriodValue){
        clickRentalPeriodInput();
        String RentalPeriodLocator =String.format(RENTAL_PERIOD_PATTERN,RentalPeriodValue);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(RentalPeriodLocator)));
       driver.findElement(By.xpath(RentalPeriodLocator)).click();
    }
    public void clickBlackColourScooterButton (){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(blackColourScooterButton));
        driver.findElement(blackColourScooterButton).click();
    }
    public void clickGreyColourScooterButton (){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(greyColourScooterButton));
        driver.findElement(greyColourScooterButton).click();
    }
    public void setCommentForDeliveryInput(String commentForDeliveryValue){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(commentForDelivaryInput));
        WebElement orderNumberWebElement=driver.findElement(commentForDelivaryInput);
        orderNumberWebElement.clear();
        driver.findElement(commentForDelivaryInput).sendKeys(commentForDeliveryValue);
    }
    public void clickOrderButton (){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(orderButton));
        driver.findElement(orderButton).click();
    }
    public void clickConfirmOrderButton (){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(confirmOrderButton));
        driver.findElement(confirmOrderButton).click();
    }
    public void clickCheckOrderStatusButton (){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(checkOrderStatusButton));
        driver.findElement(checkOrderStatusButton).click();
    }

    public void clickScooterLogo (){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(scooterLogo));
        driver.findElement(scooterLogo).click();
    }

    public String getOrderCreationFinalText() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(orderCreationFinalText));
        return driver.findElement(orderCreationFinalText).getText();
    }

    public String getOrderIdByText (String textIncludeId){
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(textIncludeId);
        if (matcher.find()) {
            return matcher.group();
        }
        return "Method getOrderId doesn't find order_id";
    }
    public String getErrorInputFirstNameText() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(errorTextFirstNameInput));
        return driver.findElement(errorTextFirstNameInput).getText();
    }
    public String getErrorInputSecondNameText() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(errorTextSecondNameInput));
        return driver.findElement(errorTextSecondNameInput).getText();
    }
    public String getErrorInputAddressText() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(errorTextDeliveryAddresInput));
        return driver.findElement(errorTextDeliveryAddresInput).getText();
    }
    public String getErrorTelephoneNumberText() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(errorTextTelephonNumberInput));
        return driver.findElement(errorTextTelephonNumberInput).getText();
    }
    public void clickHeaderLogo (){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(headerLogo));
        driver.findElement(headerLogo).click();
    }

}
