package ru.yandex.pageobject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static org.junit.Assert.assertTrue;

//@RunWith(Parameterized.class)
public class OrderFormTest extends BaseTest {
    @Test
    public void checkingFillingOutScooterOrderFormButtonTop() {

        boolean isVisiblePopUpWindowOrder = new OrderForm(driver)
                .clickOrderButtonTopPage()
                .setName("Вася")
                .setLastName("Пупкин")
                .setAddress("Чкалово 3")
                .setMetroStation()
                .setPhoneNumber("123456789012")
                .clickButtonNext()
                .setCalendarDay()
                .setRentalPeriod()
                .setColorScooter()
                .setComment("Ляляляляля")
                .clickOrderButton()
                .clickButtonYes()
                .isVisiblePopUpWindow();

        assertTrue(isVisiblePopUpWindowOrder);
    }

    @Test
    public void checkingFillingOutScooterOrderFormButtonBottom() {

        boolean isVisiblePopUpWindowOrder = new OrderForm(driver)
                .clickOrderButtonBottomPage()
                .setName("Вася")
                .setLastName("Пупкин")
                .setAddress("Чкалово 3")
                .setMetroStation()
                .setPhoneNumber("123456789012")
                .clickButtonNext()
                .setCalendarDay()
                .setRentalPeriod()
                .setColorScooter()
                .setComment("Ляляляляля")
                .clickOrderButton()
                .clickButtonYes()
                .isVisiblePopUpWindow();

        assertTrue(isVisiblePopUpWindowOrder);
    }

    @Test
    public void scroll(){
//        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",
//                driver.findElement(By.xpath(".//div[@class='Home_FourPart__1uthg']")));

  //     driver.findElement(By.xpath(".//div[@class='Home_FourPart__1uthg']")).click();

((JavascriptExecutor)driver).executeScript("scroll(0, 1260px);");
        System.out.println("kfkfkfkf");

    }
}