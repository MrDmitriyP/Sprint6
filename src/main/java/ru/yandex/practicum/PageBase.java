package ru.yandex.practicum;


import org.openqa.selenium.WebDriver;


public abstract class PageBase {
    WebDriver driver;


    public PageBase(WebDriver driver) {
        this.driver = driver;
    }
}