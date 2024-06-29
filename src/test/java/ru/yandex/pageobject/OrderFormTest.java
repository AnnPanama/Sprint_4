package ru.yandex.pageobject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderFormTest extends BaseTest {
    private String nameUser;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String comment;
    private boolean expectedResult;

    public OrderFormTest(String nameUser, String lastName, String address, String phoneNumber, String comment, boolean expectedResult) {
        this.nameUser = nameUser;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.comment = comment;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] getData(){
        return new Object[][]{
                {"Вася","Пупкин","Чкалово 3","123456789012","Жду сильно",true},
                {"Люся","Чеботина","Защитников5","883456789012","Жду еще сильее",true}
        };
    }

    @Test
    public void checkingFillingOutScooterOrderFormButtonTop() {
        boolean isVisiblePopUpWindowOrder = new OrderForm(driver)
                .clickOrderButtonTopPage()
                .setName(nameUser)
                .setLastName(lastName)
                .setAddress(address)
                .setMetroStation()
                .setPhoneNumber(phoneNumber)
                .clickButtonNext()
                .setCalendarDay()
                .setRentalPeriod()
                .setColorScooter()
                .setComment(comment)
                .clickOrderButton()
                .clickButtonYes()
                .isVisiblePopUpWindow();

        assertEquals(expectedResult,isVisiblePopUpWindowOrder);
    }

    @Test
    public void checkingFillingOutScooterOrderFormButtonBottom() {

        boolean isVisiblePopUpWindowOrder = new OrderForm(driver)
                .clickOrderButtonBottomPage()
                .setName(nameUser)
                .setLastName(lastName)
                .setAddress(address)
                .setMetroStation()
                .setPhoneNumber(phoneNumber)
                .clickButtonNext()
                .setCalendarDay()
                .setRentalPeriod()
                .setColorScooter()
                .setComment(comment)
                .clickOrderButton()
                .clickButtonYes()
                .isVisiblePopUpWindow();

        assertEquals(expectedResult,isVisiblePopUpWindowOrder);
    }
}