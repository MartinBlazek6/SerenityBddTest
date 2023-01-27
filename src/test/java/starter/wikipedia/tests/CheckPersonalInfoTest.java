package starter.wikipedia.tests;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import starter.wikipedia.models.Pages;
import starter.wikipedia.services.SearchService;
import starter.wikipedia.services.UtilStepsService;
import starter.wikipedia.urls.NavigateActions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class CheckPersonalInfoTest {
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
    void checkJobTitle() {
        Serenity.reportThat("This is checking if job title is Java Test Automation Engineer",
                () -> assertThat(searchService.checkJobTitle()).isEqualTo("Java Test Automation Engineer"));
    }

    @Test
    void checkFullName() {
        Serenity.reportThat("This is checking if full name is martin Blazek",
                () -> assertThat(searchService.checkFullName()).isEqualTo("Martin Blazek"));
    }
}
