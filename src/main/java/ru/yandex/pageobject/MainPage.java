package ru.yandex.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends BasePage {


    //кнопка Заказать вверху страницы
    private By  orderButtonTopPage=By.xpath(".//button[@class='Button_Button__ra12g']");
    // кнопка Заказать внизу страницы
    private By  orderButtonBottomPage=By.xpath(".//button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']");
    //Локатор для центральной страницы
    private By homePage=By.className("Home_HomePage__ZXKIX");
    //Локатор для формы заказа
    private By orderFormContent=By.xpath(".//div[@class='Order_Content__bmtHS']");

    // Локатор вопросы о важном
    private By question=By.xpath(".//div[@class='accordion__item']");

    //Локатор для ответов
    private By responsePriceAndPayment=By.xpath(".//div[@class='accordion__panel']/p");

    //Конструктор для класса
    public MainPage(WebDriver driver) {
        super(driver);
    }

    //метод клика по любой кнопке с проверкой, что кнопка включена
    public void clickButton(By button){

        driver.findElement(button).isEnabled();
        driver.findElement(button).click();
    }

    //метод проверки видимости формы ввода
    public boolean isVisibleInputForm(){
       return wait.until(ExpectedConditions.visibilityOfElementLocated(orderFormContent)).isEnabled();
    }

}
