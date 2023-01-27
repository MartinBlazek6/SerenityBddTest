package starter.wikipedia.services;

import net.serenitybdd.core.pages.PageComponent;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchService extends PageComponent {

    @FindBy(id="firstHeading")
    private WebElementFacade firstHeading;

    public String getFirstHeading() {
        return firstHeading.getText();
    }

    public String getEducationHeading() {
        return findElementByText("Education","*").getText();
    }

    public List<String> getResumeTitlesList() {
        return getTextValuesFromTitles(List.of("Education","Experience","Language & Framework","Tools & Softwares"),"*");
    }

        public List<String> getAboutTitlesList() {
        return getTextValuesFromTitles(List.of("Automation Testing","Backend  Development","API Development","Front End Development"),"*");
    }

    public List<String> getProjectsTitlesList() {
        return getTextValuesFromTitles(List.of("all","automation","api","web app","algorithm","frontend","desktop app"),"li");
    }

    public Boolean titleIsDisplayed(String titleName){
       return findElementByText(titleName,"*").isEnabled();
    }
    public String checkJobTitle(){
        return getDriver().findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/p")).getText();
    }
    public String checkFullName(){
        return getDriver().findElement(By.xpath("//*[@id=\"__next\"]/div/div[1]/h3")).getText();
    }

    private List<String> getTextValuesFromTitles(List<String> checkList, String HTMLatribute) {
        List<String> listOfResumeTitles = new ArrayList<>();
        checkList.forEach(title-> listOfResumeTitles.add(findElementByText(title,HTMLatribute).getText()));
        return listOfResumeTitles;
    }

    private WebElement findElementByText(String textValueOfElement,String HTMLatribute){
       return getDriver().findElement(By.xpath("//"+HTMLatribute+"[contains(text(),'"+textValueOfElement+"')]"));
    }
}
