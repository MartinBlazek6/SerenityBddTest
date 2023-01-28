package starter.wikipedia.urls;

import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;


public class NavigateActions extends UIInteractions {

    @Step("Navigate to the home page")
    public void toTheHomePage() {
        openUrl( System.getenv("RUN_TEST_AGAINS_MASTER").equals("false") ? "https://martinpersonalweb.vercel.app/" : "http://localhost:3000/");
      //  openUrl("https://martinpersonalweb.vercel.app/");
    }
}
