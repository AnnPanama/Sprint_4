package ru.yandex.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;

public class OrderForm extends BasePage {

    //кнопка Заказать вверху страницы
    private By orderButtonTopPage = By.xpath(".//button[@class='Button_Button__ra12g']");
    // кнопка Заказать внизу страницы
    private By orderButtonBottomPage = By.xpath(".//button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']");
    //Локатор для формы заказа
    private By orderFormContent = By.xpath(".//div[@class='Order_Content__bmtHS']");

    // поле ввода Имя
    private By inputName = By.xpath(".//input[@placeholder='* Имя']");
    // поле ввода Фамилия
    private By inputLastName = By.xpath(".//input[@placeholder='* Фамилия']");
    // поле ввода Адрес
    private By inputAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // поле выбора станции Метро
    private By inputMetroStation = By.xpath(".//input[@placeholder='* Станция метро']");
    private By dropDownListMetroStation = By.xpath(".//div[text()='Черкизовская']");
    // поле ввода Телефон
    private By inputPhoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By buttonNext = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private By whereDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By calendarDay = By.xpath(".//div[@class='react-datepicker__day react-datepicker__day--027 react-datepicker__day--outside-month']");
    private By rentalPeriod = By.xpath(".//div[@class='Dropdown-placeholder']");
    private By dropDownListPeriod  = By.xpath(".//div[@class='Dropdown-option' and text()='двое суток']");
    private By colorScooter = By.xpath(".//input[@class='Checkbox_Input__14A2w']");
    private By commentForCourier = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private By backButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i']");
    private By windowWantOrder = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");
    private By buttonYes = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    private By buttonNo = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i' and text()='Нет']");

    // всплывающее окно с сообщением об успешном создании заказа
    private By popUpWindow = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");


    //конструктор класса
    public OrderForm(WebDriver driver) {
        super(driver);
    }

    //метод клика по любой кнопке с проверкой, что кнопка включена
    public OrderForm clickOrderButtonTopPage() {

        driver.findElement(orderButtonTopPage).isEnabled();
        driver.findElement(orderButtonTopPage).click();
        return this;
    }
    public OrderForm clickOrderButtonBottomPage() {

      //  driver.manage().window().maximize();
 wait.until(ExpectedConditions.visibilityOfElementLocated(orderFormContent));
//   ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(".//div[@class='Home_RoadMap__2tal_']")));//orderButtonBottomPage);
((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(".//button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']")));//orderButtonBottomPage);
        //((JavascriptExecutor)driver).executeScript("scroll(0,-1260);");

    //  driver.findElement(orderButtonBottomPage).isEnabled();
  driver.findElement(orderButtonBottomPage).click();
        return this;
    }


    public OrderForm setName(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputName)).sendKeys(username);
        return this;
    }

    public OrderForm setLastName(String lastName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputLastName)).sendKeys(lastName);
        return this;
    }

    public OrderForm setAddress(String address) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputAddress)).sendKeys(address);
        return this;
    }

    public OrderForm setMetroStation() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputMetroStation)).click();
        driver.findElement(dropDownListMetroStation).click();
        return this;
    }

    public OrderForm setPhoneNumber(String phoneNumber) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputPhoneNumber)).sendKeys(phoneNumber);
        return this;
    }

    public OrderForm clickButtonNext() {
        driver.findElement(buttonNext).click();
        return this;
    }
    public OrderForm setCalendarDay(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(whereDate)).click();
        driver.findElement(calendarDay).click();
        return this;
    }
    public OrderForm setRentalPeriod(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(rentalPeriod)).click();
        driver.findElement(dropDownListPeriod).click();
        return this;
    }
    public OrderForm setColorScooter(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(colorScooter)).click();
        return this;
    }
    public OrderForm setComment(String comment){
        wait.until(ExpectedConditions.visibilityOfElementLocated(commentForCourier)).sendKeys(comment);
        return this;
    }
    public OrderForm clickOrderButton(){
        driver.findElement(orderButton).click();
        return this;
    }
    public OrderForm clickButtonYes(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonYes)).click();
        return this;
    }

    // всплывающее окно с сообщением об успешном создании заказа
    public boolean isVisiblePopUpWindow() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(popUpWindow)).isEnabled();
    }

}
