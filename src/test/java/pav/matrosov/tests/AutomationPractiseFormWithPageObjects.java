package pav.matrosov.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pav.matrosov.pages.RegistrationPage;

public class AutomationPractiseFormWithPageObjects extends TestBase {

    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress("en");
    String userNumber = faker.phoneNumber().subscriberNumber(10);
    String streetAddress = faker.address().streetAddress();

    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserEmail(userEmail)
                .choiceGender()
                .typeUserPhone(userNumber);
        RegistrationPage.calendar.setDate("01", "August", "1900");
        registrationPage.subjectChoise("Maths")
                .choiceHobbies()
                .uploadFile()
                .typeAdress(streetAddress)
                .choiceState("NCR")
                .choiceCity("Delhi")
                .clickSubmit();


        registrationPage
                .checkResultsValue("Student Name", firstName + " " + lastName)
                .checkResultsValue("Student Email", userEmail)
                .checkResultsValue("Gender", "Male")
                .checkResultsValue("Mobile", userNumber)
                .checkResultsValue("Date of Birth", "01 August,1900")
                .checkResultsValue("Subjects", "Maths")
                .checkResultsValue("Hobbies", "Music")
                .checkResultsValue("Picture", "qa-guru.PNG")
                .checkResultsValue("Address", streetAddress)
                .checkResultsValue("State and City", "NCR Delhi");

    }
}
