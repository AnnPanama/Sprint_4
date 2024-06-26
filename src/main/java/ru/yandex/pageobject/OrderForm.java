package ru.yandex.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderForm {
    private WebDriver driver;
    // поле ввода Имя
    private By inputName=By.xpath(".//input[@placeholder='* Имя']");
    // поле ввода Фамилия
    private By inputLastName=By.xpath(".//input[@placeholder='* Фамилия']");
    // поле ввода Адрес
    private By inputAddress=By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // поле выбора станции Метро
    private By inputMetro=By.xpath(".//input[@placeholder='* Станция метро']");
    // поле ввода Телефон
    private By inputPhone=By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

//конструктор класса
    public OrderForm(WebDriver driver) {
        this.driver = driver;
    }
}
