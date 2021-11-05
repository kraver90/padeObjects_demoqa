package demoqa.test;

import org.junit.jupiter.api.Test;
import static demoqa.test.TestData.*;

public class StudentRegistrationForm extends TestBase {

    //не получилось поле класса JavaFaker убрать в класс TestData
    String firstName = faker.name().firstName();

    @Test
    void fullFormTest() {
        //заходим на сайт demoqa
        registationPage.openPage();

        //заполняем основные поля
        registationPage
                .typeFirstName(firstName)
                .typeLastName(lastname)
                .typeEmail(email)
                .typeGender("Male")
                .typePhoneNumber(phoneNumber)
                .typeSubject("Arts")
                .typeUploadPicture(picture)
                .typeHobbies("Reading")
                .typeHobbies("Music")
                .typeCurrentAddress(address)
                .typeState("NCR")
                .typeCity("Noida");

        //выбираем календарь и заполняем дд.мм.гг
        registationPage.calendarComponent.setDate("18", "July", "1990");

        //подтвердить
        registationPage.submitClick();

        //Сравниваем полученное значение
        registationPage
                .checkResultsValue("Student Name", firstName)
                .checkResultsValue("Student Email", email)
                .checkResultsValue("Gender", "Male")
                .checkResultsValue("Mobile", phoneNumber)
                .checkResultsValue("Date of Birth", "18 July,1990")
                .checkResultsValue("Subjects", "Arts")
                .checkResultsValue("Hobbies", "Reading, Music")
                .checkResultsValue("Picture", picture)
                .checkResultsValue("Address", address)
                .checkResultsValue("State and City", "NCR Noida");
    }
}
