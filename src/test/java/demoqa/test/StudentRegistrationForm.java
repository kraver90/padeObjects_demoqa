package demoqa.test;

import org.junit.jupiter.api.Test;

public class StudentRegistrationForm extends TestBase {

    @Test
    void fullFormTest() {
        //заходим на сайт demoqa
        registationPage.openPage();

        //заполняем основные поля
        registationPage
                .typeFirstName("Dmitryi")
                .typeLastName("Kochurov")
                .typeEmail("test@test.ru")
                .typeGender("Male")
                .typePhoneNumber("9000431111")
                .typeSubject("Arts")
                .typeUploadPicture("image.png")
                .typeHobbies("Reading")
                .typeHobbies("Music")
                .typeCurrentAddress("Мой адрес не дом и не улица, мой адрес сегодня такой")
                .typeState("NCR")
                .typeCity("Noida");

        //выбираем календарь и заполняем дд.мм.гг
        registationPage.calendarComponent.setDate("18", "July", "1990");

        //подтвердить
        registationPage.submitClick();

        //Сравниваем полученное значение
        registationPage
                .checkResultsValue("Student Name", "Dmitryi Kochurov")
                .checkResultsValue("Student Email", "test@test.ru")
                .checkResultsValue("Gender", "Male")
                .checkResultsValue("Mobile", "9000431111")
                .checkResultsValue("Date of Birth", "18 July,1990")
                .checkResultsValue("Subjects", "Arts")
                .checkResultsValue("Hobbies", "Reading, Music")
                .checkResultsValue("Picture", "image.png")
                .checkResultsValue("Address", "Мой адрес не дом и не улица, мой адрес сегодня такой")
                .checkResultsValue("State and City", "NCR Noida");
    }
}
