package starter.wikipedia.tests;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import starter.wikipedia.models.Buttons;
import starter.wikipedia.services.SearchService;
import starter.wikipedia.services.UtilStepsService;
import starter.wikipedia.urls.NavigateActions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class CheckAllButtonsTest {

    @Managed(driver = "chrome", options = "headless")
    WebDriver driver;

    private NavigateActions navigate;

    private UtilStepsService utilStepsService;

    private SearchService searchService;
    @BeforeEach
    void beforeEach(){
        navigate.toTheHomePage();
    }


    @Test
    void checkIfIconButtonsRedirectedCorrectly() {
        navigate.toTheHomePage();
        utilStepsService.clickButton(Buttons.JOB);
        Assertions.assertTrue( navigate.isUrl("https://www.ness.com/"));
    }
    @Test
    void checkIfIconButtonsRedirectedCorrectly2() {
        utilStepsService.clickButton(Buttons.LINKEDIN);
        Assertions.assertTrue( navigate.isUrl("https://www.linkedin.com/in/martin-blažek/"));
    }
    @Test
    void checkIfIconButtonsRedirectedCorrectly3() {
        utilStepsService.clickButton(Buttons.GITHUB);
        Assertions.assertTrue( navigate.isUrl("https://github.com/MartinBlazek6"));
    }
}
