package ru.yandex.practicum;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage extends PageBase {
    private WebDriverWait wait;


    @FindBy(id = "accordion__heading-0")
    private WebElement buttonAccordionHeading0;


    @FindBy(id = "accordion__panel-0")
    private WebElement regionAccordionPanel0;


    @FindBy(id = "accordion__heading-1")
    private WebElement buttonAccordionHeading1;


    @FindBy(id = "accordion__panel-1")
    private WebElement regionAccordionPanel1;


    @FindBy(id = "accordion__heading-2")
    private WebElement buttonAccordionHeading2;


    @FindBy(id = "accordion__panel-2")
    private WebElement regionAccordionPanel2;


    @FindBy(id = "accordion__heading-3")
    private WebElement buttonAccordionHeading3;


    @FindBy(id = "accordion__panel-3")
    private WebElement regionAccordionPanel3;


    @FindBy(id = "accordion__heading-4")
    private WebElement buttonAccordionHeading4;


    @FindBy(id = "accordion__panel-4")
    private WebElement regionAccordionPanel4;


    @FindBy(id = "accordion__heading-5")
    private WebElement buttonAccordionHeading5;


    @FindBy(id = "accordion__panel-5")
    private WebElement regionAccordionPanel5;


    @FindBy(id = "accordion__heading-6")
    private WebElement buttonAccordionHeading6;


    @FindBy(id = "accordion__panel-6")
    private WebElement regionAccordionPanel6;


    @FindBy(id = "accordion__heading-7")
    public WebElement buttonAccordionHeading7;


    @FindBy(id = "accordion__panel-7")
    private WebElement regionAccordionPanel7;


    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public void clickButtonAccordionHeading0(){
        buttonAccordionHeading0.click();
    }


    public void clickButtonAccordionHeading1(){
        buttonAccordionHeading1.click();
    }


    public void clickButtonAccordionHeading2(){
        buttonAccordionHeading2.click();
    }


    public void clickButtonAccordionHeading3(){
        buttonAccordionHeading3.click();
    }


    public void clickButtonAccordionHeading4(){
        buttonAccordionHeading4.click();
    }


    public void clickButtonAccordionHeading5(){
        buttonAccordionHeading5.click();
    }


    public void clickButtonAccordionHeading6(){
        buttonAccordionHeading6.click();
    }


    public void clickButtonAccordionHeading7(){
        buttonAccordionHeading7.click();
    }

    public String getButtonAccordionHeading0() {
        return buttonAccordionHeading0.getText();
    }

    public String getRegionAccordionPanel0() {
        return regionAccordionPanel0.getText();
    }


    public String getRegionAccordionPanel1() {
        return regionAccordionPanel1.getText();
    }


    public String getRegionAccordionPanel2() {
        return regionAccordionPanel2.getText();
    }


    public String getRegionAccordionPanel3() {
        return regionAccordionPanel3.getText();
    }


    public String getRegionAccordionPanel4() {
        return regionAccordionPanel4.getText();
    }


    public String getRegionAccordionPanel5() {
        return regionAccordionPanel5.getText();
    }


    public String getRegionAccordionPanel6() {
        return regionAccordionPanel6.getText();
    }


    public String getRegionAccordionPanel7() {
        return regionAccordionPanel7.getText();
    }


    public By getQuestion(String questionText) {
        return  By.xpath("//div[@class='accordion__button' and contains(text(),'" + questionText + "')]");
    }
}