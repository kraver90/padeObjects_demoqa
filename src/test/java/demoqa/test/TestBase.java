package demoqa.test;

import com.codeborne.selenide.Configuration;
import demoqa.pages.RegistationPage;
import demoqa.testData.TestData;
import org.junit.jupiter.api.BeforeAll;


public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "Firefox";
        Configuration.browserSize = "1920x1080";
    }

    RegistationPage registationPage = new RegistationPage();
    TestData testData = new TestData();
}
