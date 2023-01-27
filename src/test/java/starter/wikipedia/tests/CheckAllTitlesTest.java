package starter.wikipedia.tests;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
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
class CheckAllTitlesTest {

    @Managed(driver = "chrome", options = "headless")
    WebDriver driver;

    private NavigateActions navigate;

    private UtilStepsService utilStepsService;

    private SearchService searchService;


    @Test
    void searchForMainTittles() {
        List<String> maintTitles = new ArrayList<>();
        Arrays.stream(Pages.values()).forEach(title->maintTitles.add(title.name().substring(1).toLowerCase()));
        navigate.toTheHomePage();
        utilStepsService.clickResume(Pages.RESUME);
        Serenity.reportThat("This is checking if Resume,About and Projects buttons are displayed",
                () -> maintTitles.forEach(title ->assertThat(searchService.titleIsDisplayed(title)).isTrue()));
    }

    @Test
    void checkAllTittlesOnResumePage() {
        List<String> listOfTitleTextValues
                = List.of("Education", "Experience", "Language & Framework", "Tools & Softwares");
        navigate.toTheHomePage();
        utilStepsService.clickResume(Pages.RESUME);
        Serenity.reportThat("This is checking all tittles in Resume page",
                () -> IntStream.range(0, listOfTitleTextValues
                        .size()).forEach(string
                        -> assertThat(searchService.getResumeTitlesList().get(string)).isEqualTo(listOfTitleTextValues
                        .get(string))));
    }

    @Test
    void checkAllTittlesOnAboutPage() {
        List<String> listOfTitleTextValues
                = List.of("Automation Testing", "Backend Development", "API Development", "Front End Development");
        navigate.toTheHomePage();
        utilStepsService.clickResume(Pages.ABOUT);
        Serenity.reportThat("This is checking all tittles in About page",
                () -> IntStream.range(0, listOfTitleTextValues
                        .size()).forEach(string
                        -> assertThat(searchService.getAboutTitlesList().get(string)).isEqualTo(listOfTitleTextValues
                        .get(string))));
    }
    @Test
    void checkAllTittlesOnProjectsPage() {
        List<String> listOfTitleTextValues
                = List.of("All","Automation","Api","Web App","Algorithm","Frontend","Desktop App");
        navigate.toTheHomePage();
        utilStepsService.clickResume(Pages.PROJECTS);
        Serenity.reportThat("This is checking all tittles in Projects page",
                () -> IntStream.range(0, listOfTitleTextValues
                        .size()).forEach(string
                        -> assertThat(searchService.getProjectsTitlesList().get(string)).isEqualTo(listOfTitleTextValues
                        .get(string))));
    }

}
