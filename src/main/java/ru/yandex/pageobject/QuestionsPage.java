package ru.yandex.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QuestionsPage {
    //Класс раздела "Вопросы о важном"

    // драйвер
    private WebDriver driver;
    //Локатор для Вопросов:
    private By question=By.xpath(".//div[@class='accordion__item']");

    //Локатор для ответов
    private By responsePriceAndPayment=By.xpath(".//div[@class='accordion__panel']/p");

}
