package starter.wikipedia.urls;

import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;
import org.junit.jupiter.api.Tag;


public class NavigateActions extends UIInteractions {

    @Step("Navigate to the home page")
    public void toTheHomePage() {
        openUrl( System.getenv("master").equals("false") ? "https://martinpersonalweb.vercel.app/" : "http://localhost:3000/");
    }
}
