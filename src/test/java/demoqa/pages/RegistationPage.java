package demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import demoqa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistationPage {

    private final String FORM_TITLE = "Student Registration Form";
    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderRadioButton = $("#genterWrapper"),
            phoneNumberInput = $("#userNumber"),
            subjectMultiInpunt = $("#subjectsInput"),
            uploadPictureButton = $("input[id=uploadPicture]"),
            hobbiesCheckbox = $("#hobbiesWrapper"),
            currentAddressInput = $("#currentAddress"),
            stateCitySelected = $("#stateCity-wrapper"),
            stateSelected = $("#state"),
            citySelected = $("#city"),
            submitClick = $("#submit"),
            resultsTable = $(".table-responsive");

    public CalendarComponent calendarComponent = new CalendarComponent();


    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
    }

    public RegistationPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistationPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistationPage typeEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistationPage typeGender(String value) {
        genderRadioButton.find(byText(value)).click();
        return this;
    }

    public RegistationPage typePhoneNumber(String value) {
        phoneNumberInput.setValue(value);
        return this;
    }

    public RegistationPage typeSubject(String value) {
        subjectMultiInpunt.setValue(value).pressEnter();
        return this;
    }

    public RegistationPage typeUploadPicture(String value) {
        uploadPictureButton.uploadFromClasspath(value);
        return this;
    }

    public RegistationPage typeHobbies(String value) {
        hobbiesCheckbox.findElement(byText(value)).click();
        return this;
    }

    public RegistationPage typeCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistationPage typeState(String value) {
        stateSelected.click();
        stateCitySelected.$(byText(value)).scrollTo().click();
        return this;
    }

    public RegistationPage typeCity(String value) {
        citySelected.click();
        stateCitySelected.$(byText(value)).scrollTo().click();
        return this;
    }

    public void submitClick() {
        submitClick.click();
    }

    public RegistationPage checkResultsValue(String key, String value) {
        resultsTable.$(byText(key)).
                parent().shouldHave(text(value));
        return this;
    }
}
