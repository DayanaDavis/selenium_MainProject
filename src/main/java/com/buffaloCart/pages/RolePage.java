package com.buffaloCart.pages;

import com.buffaloCart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RolePage extends ObjectUtility {
    WebDriver driver;
    public RolePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@class='btn btn-block btn-primary']")
    WebElement addRole;
    @FindBy(xpath = "//input[@class='form-control input-sm']")
    WebElement search;
    @FindBy(xpath = "//td[@class='sorting_1']")
    WebElement job;
    @FindBy(xpath = "//i[@class='glyphicon glyphicon-trash']")
    WebElement delete;
    @FindBy(xpath = "//td[@class='dataTables_empty']")
    WebElement error_NoRole;
    @FindBy(xpath = "//i[@class='glyphicon glyphicon-edit']")
    WebElement editRole;
    @FindBy(xpath = "//button[@class='swal-button swal-button--confirm swal-button--danger']")
    WebElement ok_confirmDelete;
     public String getPageTitle(){
        String title=page.getPageTitle(driver);
        return title;
     }
     public AddRolesPage clickOnAddRole(){
         wait.waitUntilVisibilityOfElement(1000,driver,addRole);
         page.clickOnElement(addRole);
         return new AddRolesPage(driver);
     }
     public void enterValueOnSearch(String value){
         wait.waitUntilElementIsClickable(500,driver,search);
         page.enterText(search,value);
         wait.hardWait(5000);
     }
     public String getRole(){
         wait.waitUntilVisibilityOfElement(500,driver,job);
         String jobs=page.getElementText(job);
         return jobs;
     }
     public void clickOnDeleteRole(){
         wait.waitUntilVisibilityOfElement(500,driver,delete);
         page.clickOnElement(delete);
         wait.waitUntilVisibilityOfElement(500,driver,ok_confirmDelete);
         page.clickOnElement(ok_confirmDelete);
     }
     public String getErrorMsgForNoRoleFound(){
         wait.waitUntilVisibilityOfElement(500,driver,error_NoRole);
         String msg=page.getElementText(error_NoRole);
         return msg;
     }
     public EditRolePage clickOnEditButton(){
         wait.waitUntilVisibilityOfElement(500,driver,editRole);
         page.clickOnElement(editRole);
         return new EditRolePage(driver);
     }

}
