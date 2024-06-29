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
    private By question =By.xpath(".//div[@class='accordion__item']");

    //Конструктор для класса
    public MainPage(WebDriver driver) {
        super(driver);
    }

    //метод скролла до раздела Вопросы о важном
    public MainPage scrollToImportantQuestions(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",driver.findElement(question));
        return this;
    }

    //метод клика на вопрос, по порядковому номеру, - 1 сделан для верного обращения к индексу листа,т.к. в тестовых данных нумерация с 1 начинатеся для читаемости теста
    public MainPage clickOnQuestion(int questionNum){
        List<WebElement> webElements=driver.findElements(question);
        webElements.get(questionNum-1).click();
        return this;
    }

    //метод получения текста ответа на вопрос для последующего сравнения, получаем ответ по порядковому номеру,
    // - 1 сделан для верного обращения к индексу листа,т.к. в тестовых данных нумерация с 1 начинатеся для читаемости теста
    public String getResponseText(int num){
     return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='accordion__panel-"+ (num-1) + "']"))).getText();
    }
}
