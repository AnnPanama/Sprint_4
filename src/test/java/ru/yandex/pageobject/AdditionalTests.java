package ru.yandex.pageobject;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AdditionalTests extends BaseTest {

    //Проверить: если нажать на логотип «Самоката», попадёшь на главную страницу «Самоката».
    @Test
    public void getMainPageIfClickOnScooterLogo() {
        boolean isVisibilityMainPage = new OrderForm(driver)
                .clickOrderButtonTopPage()
                .clickLogoScooter()
                .isVisibilityMainPage();

        assertTrue(isVisibilityMainPage);
    }

    //Проверить: если нажать на логотип Яндекса, в новом окне откроется главная страница Яндекса.
    @Test
    public void yandexHomePageOpensInNewWindow() {
        boolean isOpeningNewPage = new MainPage(driver)
                .clickLogoYandex()
                .isOpeningNewPage();
        assertTrue(isOpeningNewPage);
    }

    // Проверить ошибки для всех полей формы заказа.
    @Test
    public void errorMessage() {
        boolean isAllErrorMessage = new OrderForm(driver)
                .clickOrderButtonTopPage()
                .clickButtonNext()
                .isAllErrorMessageFormForWhomIsScooter();

        assertTrue(isAllErrorMessage);
    }


    //Проверить: если ввести неправильный номер заказа, попадёшь на страницу статуса заказа. На ней должно быть написано, что такого заказа нет.
    @Test
    public void enterWrongOrderNumberOnPageWritingIsNoSuchOrder() {
        boolean isInscriptionPresent = new MainPage(driver)
                .clickOnOrderStatusButton()
                .setInputNumOrder("0")
                .clickbuttonGo()
                .isPresenceOfInscriptionThereIsNoSuchOrder();

        assertTrue(isInscriptionPresent);
    }
}
