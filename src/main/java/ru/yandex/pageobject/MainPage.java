package ru.yandex.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MainPage extends BasePage {
    public static final String URL = "https://qa-scooter.praktikum-services.ru/";

    //Локатор для центральной страницы
    private By homePage = By.className("Home_HomePage__ZXKIX");

    // Локатор вопросы о важном
    private By question = By.xpath(".//div[@class='accordion__item']");

    //Локатор для ответов
    private By responsePriceAndPayment = By.xpath(".//div[@class='accordion__panel']/p");

    //Конструктор для класса
    public MainPage(WebDriver driver) {
        super(driver);
    }
}
