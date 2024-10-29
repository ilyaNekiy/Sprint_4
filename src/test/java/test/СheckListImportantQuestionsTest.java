package test;

import org.example.pageobject.MainPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class СheckListImportantQuestionsTest extends BaseUITest {
    private final String importantQuestionText;
    private final String importantAnswerText;
    public static final String HOW_MUCH_COSTS_QUESTION="Сколько это стоит? И как оплатить?";
    public static final String HOW_MUCH_COSTS_ANSWER="Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static final String MORE_THAN_ONE_SCOOTER_QUESTION="Хочу сразу несколько самокатов! Так можно?";
    public static final String MORE_THAN_ONE_SCOOTER_ANSWER="Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String RENTAL_TIME_QUESTION="Как рассчитывается время аренды?";
    public static final String RENTAL_TIME_ANSWER="Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String RENT_TODAY_QUESTION="Можно ли продлить заказ или вернуть самокат раньше?";
    public static final String RENT_TODAY_ANSWER="Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static final String CHANGE_PERIOD_OF_RENT_QUESTION="Можно ли продлить заказ или вернуть самокат раньше?";
    public static final String CHANGE_PERIOD_OF_RENT_ANSWER="Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static final String CHARGE_OF_SCOOTER_QUESTION="Вы привозите зарядку вместе с самокатом?";
    public static final String CHARGE_OF_SCOOTER_ANSWER="Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String CANCEL_ORDER_QUESTION="Можно ли отменить заказ?";
    public static final String CANCEL_ORDER_ANSWER="Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static final String OUT_OF_MOSCOW_QUESTION="Я живу за МКАДом, привезёте?";
    public static final String OUT_OF_MOSCOW_ANSWER="Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    public СheckListImportantQuestionsTest(String importantQuestionText, String importantAnswerText) {
        this.importantQuestionText = importantQuestionText;
        this.importantAnswerText = importantAnswerText;
    }

    @Parameterized.Parameters
    public static Object[][] ListImportantQuestionsExpectedResults() {
        return new Object[][]{
                {HOW_MUCH_COSTS_QUESTION, HOW_MUCH_COSTS_ANSWER},
                {MORE_THAN_ONE_SCOOTER_QUESTION, MORE_THAN_ONE_SCOOTER_ANSWER},
                {RENTAL_TIME_QUESTION, RENTAL_TIME_ANSWER},
                {RENT_TODAY_QUESTION, RENT_TODAY_ANSWER},
                {CHANGE_PERIOD_OF_RENT_QUESTION, CHANGE_PERIOD_OF_RENT_ANSWER},
                {CHARGE_OF_SCOOTER_QUESTION, CHARGE_OF_SCOOTER_ANSWER},
                {CANCEL_ORDER_QUESTION, CANCEL_ORDER_ANSWER},
                {OUT_OF_MOSCOW_QUESTION, OUT_OF_MOSCOW_ANSWER},
        };
    }


    @Test
    public void СheckListImportantQuestionsTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickCookieButtonMessage();
        mainPage.getFAQAnswerText(importantQuestionText);
        assertEquals(String.format("Question: %s\n Expected answer: %s\n Actual answer: %s\n", importantQuestionText, importantAnswerText, mainPage.getFAQAnswerText(importantQuestionText)), importantAnswerText, mainPage.getFAQAnswerText(importantQuestionText));

    }
}