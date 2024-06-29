package ru.yandex.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class MainPage extends BasePage {
    //URL открываемой страницы
    public static final String URL = "https://qa-scooter.praktikum-services.ru/";

    // Локатор вопроса
    private By question = By.xpath(".//div[@class='accordion__item']");

    // локатор главной страницы
    private By homePage = By.xpath(".//div[@class='Home_HomePage__ZXKIX']");

    // локатор логотипа Самокат
    private By logoScotter = By.xpath(".//a[@class='Header_LogoScooter__3lsAR']");

    //локатор логотипа Яндекс
    private By logoYandex = By.xpath(".//a[@class='Header_LogoYandex__3TSOI']");

    //URL главной страницы Яндекс
    private String urlMainYandex="https://dzen.ru";

   //главная старница Яндекс
    private By mainPageYandex=By.xpath(".//div[@class='content secondChunkSyncExp']");

   //кноска статус заказа
    private By buttonOrderStatus=By.xpath(".//button[@class='Header_Link__1TAG7']");

   //поле ввода номера заказа
    private By inputNumOrder=By.xpath(".//input[@class='Input_Input__1iN_Z Header_Input__xIoUq']");

   //кнопка GO
    private By buttonGo=By.xpath(".//button[@class='Button_Button__ra12g Header_Button__28dPO']");

   //картинка с информацией  Такого заказа нет
    private By imgNotFound=By.xpath(".//img[@alt='Not found']");


    //Конструктор для класса
    public MainPage(WebDriver driver) {
        super(driver);
    }

    //метод скролла до раздела Вопросы о важном
    public MainPage scrollToImportantQuestions() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(question));
        return this;
    }

    //метод клика на вопрос, по порядковому номеру, - 1 сделан для верного обращения к индексу листа,т.к. в тестовых данных нумерация с 1 начинатеся для читаемости теста
    public MainPage clickOnQuestion(int questionNum) {
        List<WebElement> webElements = driver.findElements(question);
        webElements.get(questionNum - 1).click();
        return this;
    }

    //метод получения текста ответа на вопрос для последующего сравнения, получаем ответ по порядковому номеру,
    // - 1 сделан для верного обращения к индексу листа,т.к. в тестовых данных нумерация с 1 начинатеся для читаемости теста
    public String getResponseText(int num) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='accordion__panel-" + (num - 1) + "']"))).getText();
    }


    //Дополнительные тестовые сценарии

    //метод клика по логотипу самокат
    public MainPage clickLogoScooter() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoScotter)).click();
        return this;
    }

    // метод проверки отображения главной страницы
    public boolean isVisibilityMainPage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(homePage)).isDisplayed();
    }

    //метод клика по логотипу Яндекс
    public MainPage clickLogoYandex() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoYandex)).click();
        return this;
    }

    //метод проверяет открытие нововй страницы яндекс
    public boolean isOpeningNewPage(){
        driver.navigate().to(urlMainYandex);
        return driver.findElement(mainPageYandex).isDisplayed();
    }

    // кликнуть на кнопку Статус заказа
    public MainPage clickOnOrderStatusButton(){
        driver.findElement(buttonOrderStatus).isEnabled();
        driver.findElement(buttonOrderStatus).click();
        return this;
    }

    // ввести номер заказа
    public MainPage setInputNumOrder(String numOrder){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputNumOrder)).sendKeys(numOrder);
        return this;
    }

    //кликнуть на кнопу Go
    public MainPage clickbuttonGo(){
        driver.findElement(buttonGo).isEnabled();
        driver.findElement(buttonGo).click();
        return this;
    }

    //проверка отображения картинки с надписью Такого заказа нет
    public boolean isPresenceOfInscriptionThereIsNoSuchOrder(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(imgNotFound)).isDisplayed();
    }
}
