package test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


import java.security.SecureRandom;
import java.time.Duration;
import java.util.Random;


public class BaseUITest {
    protected WebDriver driver;
    private static final String RUSSIAN_CHARACTERS = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдежзийклмнопрстуфхцчшщъыьэюя";
    private static final int ID_LENGTH = 10; // Длина ID
    private  final SecureRandom random = new SecureRandom();
    private static final String PREFIX = "+79";
    private static final int NUMBER_LENGTH = 9; // Количество цифр после +79
    private final Random randomPhoneNubmer = new Random();

    public  String generateRussianLetterId() {
        StringBuilder idBuilder = new StringBuilder(ID_LENGTH);
        for (int i = 0; i < ID_LENGTH; i++) {
            int index = random.nextInt(RUSSIAN_CHARACTERS.length());
            idBuilder.append(RUSSIAN_CHARACTERS.charAt(index));
        }
        return idBuilder.toString();
    }
    public  String generateRandomRusPhoneNumber() {
        StringBuilder phoneNumberBuilder = new StringBuilder(PREFIX);
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            int digit = randomPhoneNubmer.nextInt(10); // Генерация цифры от 0 до 9
            phoneNumberBuilder.append(digit);
        }
        return phoneNumberBuilder.toString();
    }
    public void initChrome(){
        ChromeOptions options = new ChromeOptions();
        driver= new ChromeDriver(options);
    }
    public void initFirefox(){
        FirefoxOptions options = new FirefoxOptions();
        driver= new FirefoxDriver(options);
    }
    @Before

    public void startUp(){
        initFirefox();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
