package com.amazon.tests.amazonE2ETests;

import com.amazon.pages.BookPage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.YourListPage;
import com.amazon.tests.TestBase;
import com.amazon.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Amazon_CreateList extends TestBase {
    /** Amazon E2E Task
     *  go to https://www.amazon.com.tr/ web page
     *  if there are cookies accept cookies
     *  log in with your own valid credential
     *  Verify that login is successful
     *  Click a new list from Hesap ve Listeler
     *  Create a new list named as Umut
     *  Verify that Umut list is created
     *  Delete Umut list
     *  Select any category from the section tab next to the search box (click search button)
     *  Verify that category  is selected
     *  Write any product to search box and click
     *  Verify that the product name is displayed on the result page

     Project Name:EuroTech_SeleniumTestNG_Amazon
     */

    LoginPage loginPage;
    YourListPage yourListPage;
    BookPage bookPage;
    @Test
    public void TC001_ListTest(){
        loginPage=new LoginPage();
        yourListPage=new YourListPage();
        bookPage=new BookPage();

        extentLogger=report.createTest("TC001_List Test");

        extentLogger.info("go to "+ConfigurationReader.get("url")+" web page");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("if there are cookies accept cookies");
        loginPage.acceptCookies();

        extentLogger.info("log in with your own valid credential");
        loginPage.login();

        extentLogger.info("Verify that login is successful");
        String actualUsername = loginPage.getUsername();
        String expectedUsername=ConfigurationReader.get("username");
        Assert.assertEquals(actualUsername,expectedUsername);

        extentLogger.info("Click a new list from Hesap ve Listeler");
        yourListPage.createANewList();

        extentLogger.info("Create a new list named as Umut");
        yourListPage.createANewListMethod("Umut");

        extentLogger.info("Verify that Umut list is created");
        yourListPage.verificationOfCreatedList("Umut");

        extentLogger.info("Delete shopping list");
        yourListPage.deleteList();

        extentLogger.info("Select any category from the section tab next to the search box (click search button)");
        yourListPage.selectCategory("Kitaplar");
        yourListPage.clickSearchButton();

        extentLogger.info("Verify that category  is selected");
        bookPage.verificationOfSelectedCategory("Kitaplar");

        extentLogger.info("Write any product to search box and click");
        bookPage.searchingProduct("Selenium");

        extentLogger.info("Verify that the product name is displayed on the result page");
        bookPage.verificationOfSearchingResult("Selenium");

        extentLogger.pass("Passed...!");

    }
}
