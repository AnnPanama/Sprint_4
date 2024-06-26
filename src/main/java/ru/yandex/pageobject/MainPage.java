package ru.yandex.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    // драйвер
    private WebDriver driver;

    //кнопка Заказать вверху страницы
    private By  orderButtonTopPage=By.xpath(".//button[@class='Button_Button__ra12g']");
    // кнопка Заказать внизу страницы
    private By  orderButtonBottomPage=By.xpath(".//button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']");
    //Локатор для центральной страницы
    private By homePage=By.className("Home_HomePage__ZXKIX");
    //Локатор для формы заказа
    private By orderFormContent=By.xpath(".//div[@class='Order_Content__bmtHS']");

    //Конструктор для класса
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //метод клика по любой кнопке с проверкой, что кнопка включена
    public void clickButton(By button){

        driver.findElement(button).isEnabled();
        driver.findElement(button).click();
    }

    //метод ожидания загрузки любого переданного элемента
    public void waitForLoadElement (By element){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
