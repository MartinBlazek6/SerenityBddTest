package partinPersonalWeb.guiTests.tests;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import partinPersonalWeb.guiTests.models.PersonalInfo;
import partinPersonalWeb.guiTests.services.SearchService;
import partinPersonalWeb.guiTests.services.UtilStepsService;
import partinPersonalWeb.guiTests.urls.NavigateActions;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class CheckPersonalInfoTest {
    @Managed(driver = "chrome", options = "headless")
    WebDriver driver;

    private NavigateActions navigate;

    private UtilStepsService utilStepsService;

    private SearchService searchService;
    static final HashMap<PersonalInfo, String> personalInfo = new HashMap<>();

    @BeforeEach
    void beforeEach(){
        navigate.toTheHomePage();
        personalInfo.put(PersonalInfo.FULL_NAME, "Martin Blazek");
        personalInfo.put(PersonalInfo.JOB_TITTLE, "Java Test Automation Engineer");
        personalInfo.put(PersonalInfo.LOCATION, "Martin, Slovakia");
        personalInfo.put(PersonalInfo.EMAIL, "martinblazek6@gmail.com");
    }

    @Test
    void checkJobTitle() {
        Serenity.reportThat("This is checking if job title is "+personalInfo.get(PersonalInfo.JOB_TITTLE),
                () -> assertThat(searchService.checkJobTitle()).isEqualTo(personalInfo.get(PersonalInfo.JOB_TITTLE)));
    }

    @Test
    void checkFullName() {
        Serenity.reportThat("This is checking if full name is " + personalInfo.get(PersonalInfo.FULL_NAME),
                () -> assertThat(searchService.checkFullName()).isEqualTo(personalInfo.get(PersonalInfo.FULL_NAME)));
    }
    @Test
    void checkLocation() {
        Serenity.reportThat("This is checking if location is " + personalInfo.get(PersonalInfo.LOCATION),
                () -> assertThat(searchService.checkLocation()).isEqualTo(personalInfo.get(PersonalInfo.LOCATION)));
    }
    @Test
    void checkEmailAddress() {
        Serenity.reportThat("This is checking if email address is " + personalInfo.get(PersonalInfo.EMAIL),
                () -> assertThat(searchService.checkEmailAddress()).isEqualTo(personalInfo.get(PersonalInfo.EMAIL)));
    }
}
