package demoqa.test;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import demoqa.pages.RegistationPage;
import org.junit.jupiter.api.BeforeAll;

import java.util.Locale;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "Firefox";
        Configuration.browserSize = "1920x1080";
    }

    RegistationPage registationPage = new RegistationPage();
    Faker faker = new Faker(new Locale("ru"));
}
