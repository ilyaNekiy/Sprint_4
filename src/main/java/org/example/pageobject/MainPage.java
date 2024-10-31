package org.example.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    protected WebDriver driver;

    private By statusOrderButton = By.xpath(".//button[contains(@class,'Header_Link')]");
    private By orderNumberInput = By.xpath(".//input[@type='text']");
    private By goButton=By.xpath(".//button[contains(@class,'Header_Button') and text()='Go!']");
    private By closeCookieMessageButton=By.xpath(".//button[contains(@class,'App_CookieButton')]");
    private By topOrderButton = By.xpath(".//div[contains(@class,'Header_Nav')]/button[contains(@class,'Button_Button')]");
    private By lowOrderButton = By.xpath(".//div[contains(@class,'Home_FinishButton')]/button[contains(@class,'Button_Button')]");
    private By listOfFAQQuestions = By.xpath(".//div[contains(@id,'accordion__heading')]");
    private By yandexLogo = By.xpath(".//img[@alt='Yandex']");
    private static final String FAQ_QUESTION_PATTERN = ".//div[contains(@id,'accordion__heading') and contains(text(),'%s')]" ;
    public static final String MAIN_PAGE_URL="https://qa-scooter.praktikum-services.ru/";
    public static final String FAQ_ANSWER_PATTERN=".//div[contains(@id,'accordion__heading') and contains(text(),'%s')]/parent::div/parent::div/div/p";
    public  MainPage (WebDriver driver){
        this.driver=driver;
    }

    public  MainPage openMainPage (){
        driver.get(MAIN_PAGE_URL);
        return this;
    }

    public void setStatusOrderButtonClick(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(statusOrderButton));
        driver.findElement(statusOrderButton).click();
    }
    public void goButtonClick(){
        driver.findElement(goButton).click();
    }
    public void clickFAQQuestion(String questionMessage){
        String questionLocator =String.format(FAQ_QUESTION_PATTERN,questionMessage);
        WebElement questionElement= driver.findElement(By.xpath(questionLocator));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",questionElement);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(questionLocator)));
        questionElement.click();
    }
    public void setOrderNumber(String orderNumberValue){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(orderNumberInput));
        WebElement orderNumberWebElement=driver.findElement(orderNumberInput);
        orderNumberWebElement.clear();
        driver.findElement(orderNumberInput).sendKeys(orderNumberValue);
    }

    public String getFAQAnswerText(String questionMessage){
        clickFAQQuestion(questionMessage);
        String AnswerLocator =String.format(FAQ_ANSWER_PATTERN,questionMessage);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(AnswerLocator)));
        WebElement answerElement= driver.findElement(By.xpath(AnswerLocator));
        return answerElement.getText();
    }
    public void clickCookieButtonMessage(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(closeCookieMessageButton));
        driver.findElement(closeCookieMessageButton).click();
    }
    public void clickTopOrderButton(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(topOrderButton));
        driver.findElement(topOrderButton).click();
    }

    public void clickYandexLogo() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(yandexLogo));
        driver.findElement(yandexLogo).click();
    }
    public void clickLowOrderButton(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(lowOrderButton));
        WebElement button = driver.findElement(lowOrderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", button);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(button));// Pass the WebElement here
        button.click();
    }

}
