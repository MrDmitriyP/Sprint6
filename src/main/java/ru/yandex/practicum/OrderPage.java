package ru.yandex.practicum;


import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;




public class OrderPage extends PageBase {
    private WebDriverWait wait;


    @FindBy(xpath = "//button[@class='Button_Button__ra12g' and text()='Заказать']")
    private WebElement buttonOrderInHeader;


    @FindBy(xpath = "//button[contains(@class, 'Button_Button__ra12g Button_Middle__1CSJM') and text()='Заказать']")
    private WebElement buttonOrderOnPage;


    @FindBy(xpath = "//div[text()='Для кого самокат']")
    private WebElement titleOrderPage;


    @FindBy(xpath = "//input[@placeholder='* Имя']")
    private WebElement inputFirstName;


    @FindBy(xpath = "//input[@placeholder='* Фамилия']")
    private WebElement inputLastName;


    @FindBy(xpath = "//input[@placeholder='* Станция метро']")
    private WebElement inputMetroStation;


    @FindBy(xpath = "//input[@placeholder='* Адрес: куда привезти заказ']")
    private WebElement inputAddress;


    @FindBy(xpath = "//input[@placeholder='* Телефон: на него позвонит курьер']")
    private WebElement inputPhone;


    @FindBy(xpath = "//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее']")
    private WebElement buttonNext;


    @FindBy(xpath = "//div[text()='Про аренду']")
    private WebElement titleAboutRent;


    @FindBy(xpath = "//input[@placeholder='* Когда привезти самокат']")
    private WebElement inputDatePicker;


    @FindBy(xpath = "//div[contains(@class, 'Dropdown-placeholder') and text()='* Срок аренды']")
    private WebElement inputRentalPeriod;


    @FindBy(xpath = "//input[@id='black']")
    private WebElement inputBlack;


    @FindBy(xpath = "//input[@id='grey']")
    private WebElement inputGrey;


    @FindBy(xpath = "//input[@placeholder='Комментарий для курьера']")
    private WebElement inputCommentForCourier;


    @FindBy(xpath = "//button[text()='Назад']")
    private WebElement buttonBack;


    @FindBy(xpath = "//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']")
    private WebElement buttonOrder;


    @FindBy(xpath = "//div[text()='Хотите оформить заказ?']")
    private WebElement titleOrderModal;


    @FindBy(xpath = "//button[text()='Нет']")
    private WebElement buttonNo;


    @FindBy(xpath = "//button[text()='Да']")
    private WebElement buttonYes;


    @FindBy(xpath = "//div[text()='Заказ оформлен']")
    private WebElement titleOrderCompleted;


    @FindBy(xpath = "//button[text()='Посмотреть статус']")
    private WebElement buttonViewStatus;


    @FindBy(xpath = "//div[contains(@class, 'Order_Text__2broi')]")
    private WebElement messageAboutSuccessfulOrder;


    public OrderPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }


    public void clickButtonOrderInHeader() {
        buttonOrderInHeader.click();
    }


    public void clickButtonOrderOnPage() {
        // Скроллим к кнопке "Заказать" на странице
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();", buttonOrderOnPage);
        buttonOrderOnPage.click();
    }


    public void userData(String firstName, String lastName, String address, String metroStation, String phone) {
        inputFirstName.sendKeys(firstName);
        inputLastName.sendKeys(lastName);
        inputAddress.sendKeys(address);
        inputMetroStation.sendKeys(metroStation);
        inputMetroStation.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        inputPhone.sendKeys(phone);
        buttonNext.click();
    }


    public void forRent(String datePicker, String rentalPeriod, String colour, String commentForCourier) {
        inputDatePicker.sendKeys(datePicker);
        inputDatePicker.sendKeys(Keys.ENTER);
        inputRentalPeriod.click();


        By optionsLocator = By.xpath("//div[@class='Dropdown-option']");
        List<WebElement> options = wait.until(driver -> {
            List<WebElement> elements = driver.findElements(optionsLocator);
            return elements.isEmpty() ? null : elements;
        });


        boolean rental = false;
        for (WebElement option: options) {
            if (option.getText().equals(rentalPeriod)) {
                option.click();
                rental = true;
                break;
            }
        }


        if (!rental) {
            throw new NoSuchElementException(
                    "Срок аренды: '" + rentalPeriod + "' не найден"
            );
        }


        if (colour != null) {
            String normalized = colour.toLowerCase().replace('ё', 'е');
            if (normalized.equals("черный")) {
                inputBlack.click();
            } else if (normalized.equals("серый")) {
                inputGrey.click();
            }
        }


        inputCommentForCourier.sendKeys(commentForCourier);
        buttonOrder.click();
    }


    public void confirmationOrder() {
        wait.until(ExpectedConditions.visibilityOf(titleOrderModal));
        buttonYes.click();
    }


    public String getTitleOrderCompleted() {
        return wait.until(ExpectedConditions.visibilityOf(titleOrderCompleted)).getText();
    }


    public String getMessageAboutSuccessfulOrder() {
        return wait.until(ExpectedConditions.visibilityOf(messageAboutSuccessfulOrder)).getText().replace("\u00A0", " ").replace("\n", " ");
    }
}