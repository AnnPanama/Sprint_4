package ru.yandex.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QuestionsPage {
    // драйвер
    private WebDriver driver;

    //Вопросом "Сколько это стоит? И как оплатить?"
    private By questionHowMuchAndPay=By.xpath(".//div[@id='accordion__heading-16']");
    //Текст ответа по стоимости и оплате
    private By responsePriceAndPayment=By.xpath(".//div[@id='accordion__panel-16']");

}
