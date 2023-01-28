package partinPersonalWeb.guiTests.services;

import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;
import partinPersonalWeb.guiTests.models.Pages;

public class UtilStepsService extends UIInteractions {

    @Step("Search by keyword '{0}'")
    public void clickResume(Pages page) {
        String pageButtonUpperCase = page.name().toLowerCase();
        String pageTextValue = pageButtonUpperCase.substring(1).toLowerCase();
        $("//span[contains(text(),'"+pageTextValue+"')]").click();
    }
}
