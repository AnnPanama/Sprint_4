package ru.yandex.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;

public class OrderForm extends BasePage {

    // поле ввода Имя
    private By inputName=By.xpath(".//input[@placeholder='* Имя']");
    // поле ввода Фамилия
    private By inputLastName=By.xpath(".//input[@placeholder='* Фамилия']");
    // поле ввода Адрес
    private By inputAddress=By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // поле выбора станции Метро
    private By inputMetroStation=By.xpath(".//input[@placeholder='* Станция метро']");
    // поле ввода Телефон
    private By inputPhoneNumber=By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By buttonNext=By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private By whereDate=By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By calendarDay=By.xpath(".//div[@class='react-datepicker__day react-datepicker__day--027 react-datepicker__day--outside-month']");
    private By rentalPeriod=By.xpath(".//div[@class='Dropdown-placeholder']");
    private By DropDownList=By.xpath(".//div[@class='Dropdown-option']");
    private By colorScooter=By.xpath(".//input[@class='Checkbox_Input__14A2w']");
    private By CommentForCourier=By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private By OrderButton=By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private By BackButton=By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i']");
    private By  windowWantOrder=By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");
    private By ButtonYes=By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    private By ButtonNo=By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i' and text()='Нет']");

    // всплывающее окно с сообщением об успешном создании заказа
    private By popUpWindow=By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");


    //конструктор класса
    public OrderForm(WebDriver driver) {
        super(driver);
    }

    public void setName(String username){
        driver.findElement(inputName).sendKeys(username);
    }

    public void setLastName(String lastName){
        driver.findElement(inputLastName).sendKeys(lastName);
    }

    public void setAddress(String address){
        driver.findElement(inputAddress).sendKeys(address);
    }

    public void setMetroStation(String station){
        //доделать
    }
    public void setPhoneNumber(String phoneNumber){
        driver.findElement(inputPhoneNumber).sendKeys(phoneNumber);
    }
    public void clickButton(){
        driver.findElement(buttonNext).click();
    }
    // всплывающее окно с сообщением об успешном создании заказа
    public boolean isVisiblePopUpWindow(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(popUpWindow)).isEnabled();
    }

}
