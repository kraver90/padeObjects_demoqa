package demoqa.test;

import org.junit.jupiter.api.Test;

public class StudentRegistrationFormTest extends TestBase {

    @Test
    void fullFormTest() {
        //заходим на сайт demoqa
        registationPage.openPage();

        //заполняем основные поля
        registationPage
                .typeFirstName(testData.firstName)
                .typeLastName(testData.lastName)
                .typeEmail(testData.email)
                .typeGender("Male")
                .typePhoneNumber(testData.phoneNumber)
                .typeSubject("Arts")
                .typeUploadPicture(testData.picture)
                .typeHobbies("Reading")
                .typeHobbies("Music")
                .typeCurrentAddress(testData.address)
                .typeState("NCR")
                .typeCity("Noida");

        //выбираем календарь и заполняем дд.мм.гг
        registationPage.calendarComponent.setDate("18", "July", "1990");

        //подтвердить
        registationPage.submitClick();

        //Сравниваем полученное значение
        registationPage
                .checkResultsValue("Student Name", testData.firstName + " " + testData.lastName)
                .checkResultsValue("Student Email", testData.email)
                .checkResultsValue("Gender", "Male")
                .checkResultsValue("Mobile", testData.phoneNumber)
                .checkResultsValue("Date of Birth", "18 July,1990")
                .checkResultsValue("Subjects", "Arts")
                .checkResultsValue("Hobbies", "Reading, Music")
                .checkResultsValue("Picture", testData.picture)
                .checkResultsValue("Address", testData.address)
                .checkResultsValue("State and City", "NCR Noida");
    }
}
