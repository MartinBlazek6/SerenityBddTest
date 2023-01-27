package starter.wikipedia.services;

import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import starter.wikipedia.models.Buttons;
import starter.wikipedia.models.Pages;

public class UtilStepsService extends UIInteractions {

    private ButtonService buttonService;

    public UtilStepsService(ButtonService buttonService) {
        this.buttonService = buttonService;
    }

    @Step("Click optional title")
    public void clickTitle(Pages page) {
        String pageButtonUpperCase = page.name().toLowerCase();
        String pageTextValue = pageButtonUpperCase.substring(1).toLowerCase();
        $("//span[contains(text(),'"+pageTextValue+"')]").click();
    }
    @Step("Click optional button")
    public void clickButton(Buttons button) {
        getDriver().findElement(By.id(buttonService.buttonsHashMap().get(button))).click();
    }
}
