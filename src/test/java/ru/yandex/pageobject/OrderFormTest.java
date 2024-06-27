package ru.yandex.pageobject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

//@RunWith(Parameterized.class)
public class OrderFormTest extends BaseTest {
    @Test
    public void checkingFillingOutScooterOrderForm() {

        OrderForm orderForm = new OrderForm(driver);
        orderForm.clickOrderButtonTopPage()
                .setName("Вася")
                .setLastName("Пупкин")
                .setAddress("Чкалово 3")
                .setMetroStation()
                .setPhoneNumber("123456789012")
                .clickButtonNext()
                .setCalendarDay()
                .setRentalPeriod()
                .setColorScooter()
                .clickOrderButton();


    }

}