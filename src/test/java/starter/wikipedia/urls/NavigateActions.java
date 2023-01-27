package starter.wikipedia.urls;

import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;


public class NavigateActions extends UIInteractions {
    @Step("Navigate to the wiki page")
    public void toTheWikiPage() {
        openUrl("http://wikipedia.com/");
    }

    @Step("Navigate to the home page")
    public void toTheHomePage() {
        openUrl("https://martinpersonalweb.vercel.app/");
    }
}
