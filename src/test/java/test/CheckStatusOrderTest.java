package test;

import org.example.pageobject.MainPage;

import org.example.pageobject.TrackPage;

import org.junit.Assert;

import org.junit.Test;




public class CheckStatusOrderTest extends BaseUITest {


    @Test
    public void checkOrderStatusNotExistTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickCookieButtonMessage();
        mainPage.setStatusOrderButtonClick();
        mainPage.setOrderNumber("442423");
        mainPage.goButtonClick();
        TrackPage trackPage=new TrackPage(driver);
        boolean isDisplayedNotFoundOrderImg=trackPage.isDisplayedFoundOrderImg();
        Assert.assertTrue(isDisplayedNotFoundOrderImg);
    }
}
