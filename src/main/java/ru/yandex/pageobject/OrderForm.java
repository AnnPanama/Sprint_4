package ru.yandex.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;

public class OrderForm extends MainPage {

    //кнопка Заказать вверху страницы
    private By orderButtonTopPage = By.xpath(".//button[@class='Button_Button__ra12g']");

    // кнопка Заказать внизу страницы
    private By orderButtonBottomPage = By.xpath(".//button[text()='Заказать']");


    // поле ввода Имя
    private By inputName = By.xpath(".//input[@placeholder='* Имя']");

    // поле ввода Фамилия
    private By inputLastName = By.xpath(".//input[@placeholder='* Фамилия']");

    // поле ввода Адрес
    private By inputAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    // поле выбора станции Метро
    private By inputMetroStation = By.xpath(".//input[@placeholder='* Станция метро']");

    //Выпадающий список станций метро
    private By dropDownListMetroStation = By.xpath(".//div[text()='Черкизовская']");

    // поле ввода Телефон
    private By inputPhoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    //Кнопка Далее
    private By buttonNext = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //поле Когда привести самокат
    private By whereDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    //Выпадающий календарь
    private By calendarDay = By.xpath(".//div[@class='react-datepicker__day react-datepicker__day--027 react-datepicker__day--outside-month']");

    // поле Срок аренды
    private By rentalPeriod = By.xpath(".//div[@class='Dropdown-placeholder']");

    // Выпадающий список срока аренды
    private By dropDownListPeriod = By.xpath(".//div[@class='Dropdown-option' and text()='двое суток']");

    // Чек-боксы Цвет самоката
    private By colorScooter = By.xpath(".//input[@class='Checkbox_Input__14A2w']");

    // поле Комментарий для курьера
    private By commentForCourier = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    //кнопка заказать после заполнения формы
    private By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //кнопка Назад (для будущих тестов)
    private By backButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i']");


    //Кнопка Да всплывающего окна "Хотите оформить заказ?"
    private By buttonYes = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");

    //Кнопка НЕТ всплывающего окна "Хотите оформить заказ?"
    private By buttonNo = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i' and text()='Нет']");

    // всплывающее окно с сообщением об успешном создании заказа "Заказ оформлен"
    private By popUpWindow = By.xpath(".//div[text()='Заказ оформлен']");

    // Локаторы для Дополнительные тестовые сценарии

    // локатор текста ошибки при неверно заполненном поле Имя
    private By errorMessageForName=By.xpath(".//div[text()='Введите корректное имя']");
    private By errorMessageForLastName=By.xpath(".//div[text()='Введите корректную фамилию']");
    private By errorMessageForAdress=By.xpath(".//div[text()='Введите корректный адрес']");
    private By errorMessageForMetro=By.xpath(".//div[@class='Order_MetroError__1BtZb']");
    private By errorMessageForPhone=By.xpath(".//div[text()='Введите корректный номер']");


    //конструктор класса
    public OrderForm(WebDriver driver) {
        super(driver);
    }

    //метод клика по кнопке Заказать вверху страницы
    public OrderForm clickOrderButtonTopPage() {

        driver.findElement(orderButtonTopPage).isEnabled();
        driver.findElement(orderButtonTopPage).click();
        return this;
    }

    //скролл для Кнопки внизу
    public OrderForm scrollBottom(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
                driver.findElement(By.xpath(".//div[@class='Home_FinishButton__1_cWm']")));
        return this;
    }

    //метод клика по кнопке Заказать внизу страницы
    public OrderForm clickOrderButtonBottomPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderButtonBottomPage)).click();
        return this;
    }

    //метод заполнения поля Имя
    public OrderForm setName(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputName)).sendKeys(username);
        return this;
    }

    //метод заполнения поля Фамилия
    public OrderForm setLastName(String lastName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputLastName)).sendKeys(lastName);
        return this;
    }

    //метод заполнения поля Адрес
    public OrderForm setAddress(String address) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputAddress)).sendKeys(address);
        return this;
    }

    //метод выбора станции метро
    public OrderForm setMetroStation() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputMetroStation)).click();
        driver.findElement(dropDownListMetroStation).click();
        return this;
    }

    //метод заполнения поля Телефон
    public OrderForm setPhoneNumber(String phoneNumber) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputPhoneNumber)).sendKeys(phoneNumber);
        return this;
    }

    //метод клика по кнопке Далее
    public OrderForm clickButtonNext() {
        driver.findElement(buttonNext).click();
        return this;
    }

    //метод заполнения поля Когда привезти самокат
    public OrderForm setCalendarDay() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(whereDate)).click();
        driver.findElement(calendarDay).click();
        return this;
    }

    //метод заполнения поля Срок аренды
    public OrderForm setRentalPeriod() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(rentalPeriod)).click();
        driver.findElement(dropDownListPeriod).click();
        return this;
    }

    //метод заполнения поля Цвет самоката
    public OrderForm setColorScooter() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(colorScooter)).click();
        return this;
    }

    //метод заполнения поля Комментарии для курьера
    public OrderForm setComment(String comment) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(commentForCourier)).sendKeys(comment);
        return this;
    }

    //метод клика кнопки Заказать после заполнения формы
    public OrderForm clickOrderButton() {
        driver.findElement(orderButton).click();
        return this;
    }

    //метод клика кнопки Да в окне Хотите оформить заказ?
    public OrderForm clickButtonYes() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonYes)).click();
        return this;
    }

    //метод клика кнопки Нет в окне Хотите оформить заказ? (для будущих тестов)
    public OrderForm clickButtonNo() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonNo)).click();
        return this;
    }

    // метод проверки всплывающего окно с сообщением об успешном создании заказа
    public boolean isVisiblePopUpWindow() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(popUpWindow)).isDisplayed();
    }


    // ====== Для Дополнительные тестовые сценарии ===========
    //проверки наличия сообщения об ошибке
    public boolean isErrorMessageNamePresent(){
        return driver.findElement(errorMessageForName).isDisplayed();
    }
    public boolean isErrorMessageLastNamePresent(){
        return driver.findElement(errorMessageForLastName).isDisplayed();
    }
    public boolean isErrorMessageAdressPresent(){
        return driver.findElement(errorMessageForAdress).isDisplayed();
    }
    public boolean isErrorMessageMetroPresent(){
        return driver.findElement(errorMessageForMetro).isDisplayed();
    }

    public boolean isErrorMessagePhonePresent(){
        return driver.findElement(errorMessageForPhone).isDisplayed();
    }

    public boolean isAllErrorMessageFormForWhomIsScooter(){
        return isErrorMessageNamePresent() && isErrorMessageLastNamePresent()&& isErrorMessageAdressPresent()&& isErrorMessageMetroPresent()&&isErrorMessagePhonePresent();
    }


}
