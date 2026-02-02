package ru.yandex.practicum;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage extends PageBase {
    private WebDriverWait wait;

    @FindBy(id = "accordion__heading-0")
    private WebElement buttonQuestionHowMuch;

    @FindBy(id = "accordion__panel-0")
    private WebElement textAnswerHowMuch;

    @FindBy(id = "accordion__heading-1")
    private WebElement buttonDropdownMultipleScooters;

    @FindBy(id = "accordion__panel-1")
    private WebElement textAnswerMultipleScooters;

    @FindBy(id = "accordion__heading-2")
    private WebElement buttonDropdownRentalTime;

    @FindBy(id = "accordion__panel-2")
    private WebElement textAnswerRentalTime;

    @FindBy(id = "accordion__heading-3")
    private WebElement buttonDropdownOrderToday;

    @FindBy(id = "accordion__panel-3")
    private WebElement textAnswerOrderToday;

    @FindBy(id = "accordion__heading-4")
    private WebElement buttonDropdownReturnScooter;

    @FindBy(id = "accordion__panel-4")
    private WebElement textAnswerReturnScooter;

    @FindBy(id = "accordion__heading-5")
    private WebElement buttonDropdownBatteryScooter;

    @FindBy(id = "accordion__panel-5")
    private WebElement textAnswerBatteryScooter;

    @FindBy(id = "accordion__heading-6")
    private WebElement buttonDropdownOrderCancel;

    @FindBy(id = "accordion__panel-6")
    private WebElement textAnswerOrderCancel;

    @FindBy(id = "accordion__heading-7")
    private WebElement buttonDropdownLifeMkad;

    @FindBy(id = "accordion__panel-7")
    private WebElement textAnswerLifeMkad;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickButtonAccordionHeading0(){
        buttonQuestionHowMuch.click();
    }

    public void clickButtonAccordionHeading1(){
        buttonDropdownMultipleScooters.click();
    }

    public void clickButtonAccordionHeading2(){
        buttonDropdownRentalTime.click();
    }

    public void clickButtonAccordionHeading3(){
        buttonDropdownOrderToday.click();
    }

    public void clickButtonAccordionHeading4(){
        buttonDropdownReturnScooter.click();
    }

    public void clickButtonAccordionHeading5(){
        buttonDropdownBatteryScooter.click();
    }

    public void clickButtonAccordionHeading6(){
        buttonDropdownOrderCancel.click();
    }

    public void clickButtonAccordionHeading7(){
        buttonDropdownLifeMkad.click();
    }

    public String getButtonQuestionHowMuch() {
        return buttonQuestionHowMuch.getText();
    }

    public String getTextAnswerHowMuch() {
        return textAnswerHowMuch.getText();
    }

    public String getTextAnswerMultipleScooters() {
        return textAnswerMultipleScooters.getText();
    }

    public String getTextAnswerRentalTime() {
        return textAnswerRentalTime.getText();
    }

    public String getTextAnswerOrderToday() {
        return textAnswerOrderToday.getText();
    }

    public String getTextAnswerReturnScooter() {
        return textAnswerReturnScooter.getText();
    }

    public String getTextAnswerBatteryScooter() {
        return textAnswerBatteryScooter.getText();
    }

    public String getTextAnswerOrderCancel() {
        return textAnswerOrderCancel.getText();
    }

    public String getTextAnswerLifeMkad() {
        return textAnswerLifeMkad.getText();
    }

    public void scrollToQuestion(String questionText){
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();",
                driver.findElement(this.getQuestion(questionText))
        );
    }

    public By getQuestion(String questionText) {
        var xpath = String.format("//div[@class='accordion__button' and contains(text(),'%s')]", questionText);

        return By.xpath(xpath);
    }
}