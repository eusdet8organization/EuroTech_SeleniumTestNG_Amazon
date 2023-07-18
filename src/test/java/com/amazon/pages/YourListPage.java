package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourListPage extends BasePage{

    @FindBy(className = "a-button-input")
    public WebElement aNewListLink;

    @FindBy(id="list-name")
    public WebElement listNameBox;

    @FindBy(xpath = "//span[text()='Liste Oluştur']")
    public WebElement listeOlusturBtn;

    public void createANewListMethod(String listName){
        aNewListLink.click();
        BrowserUtils.waitForClickablility(By.id("list-name"),7);
        BrowserUtils.clearAndSendKeys(listNameBox,listName);
        BrowserUtils.waitForVisibility(listeOlusturBtn,7);
        BrowserUtils.clickWithJS(listeOlusturBtn);
    }
}
