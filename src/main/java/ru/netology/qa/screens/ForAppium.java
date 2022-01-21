package ru.netology.qa.screens;

import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ForAppium {

    private final AppiumDriver driver;

    @AndroidFindBy(id = "textToBeChanged")
    public MobileElement textBefore;

    @AndroidFindBy(id = "userInput")
    public MobileElement input;

    @AndroidFindBy(id = "buttonChange")
    public MobileElement buttonChange;

    @AndroidFindBy(id = "buttonActivity")
    public MobileElement buttonActivity;

    @AndroidFindBy(id = "text")
    public MobileElement activityText;

    public ForAppium(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
    }

}
