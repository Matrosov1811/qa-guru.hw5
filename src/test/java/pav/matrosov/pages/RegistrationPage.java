package pav.matrosov.pages;

import com.codeborne.selenide.SelenideElement;
import pav.matrosov.pages.components.Calendar;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {


    public static Calendar calendar = new Calendar();
    // Locators

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderChoice =  $(byText("Male")),
            userPhone = $("#userNumber"),
            subject = $("#subjectsInput"),
            hobbiesCheckbox = $("[for=hobbies-checkbox-3]"),
            uploadFile = $("#uploadPicture"),
            adress = $("#currentAddress"),
            stateContainer = $("#state"),
            stateCityWrapper = $("#stateCity-wrapper"),
            cityContainer = $("#city"),
            pressSubmit = $("#submit"),
            resultsTable = $(".table-responsive");


    //actions
    public RegistrationPage openPage () {
        open("https://demoqa.com/automation-practice-form");
        return this;
    }

    public RegistrationPage typeFirstName (String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeLastName (String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeUserEmail (String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage choiceGender () {
        genderChoice.click();
        return this;
    }

    public RegistrationPage typeUserPhone (String value) {
        userPhone.setValue(value);
        return this;
    }

    public RegistrationPage subjectChoise (String value) {
        subject.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage choiceHobbies () {
        hobbiesCheckbox.click();
        return this;
    }

    public RegistrationPage uploadFile () {
        uploadFile.uploadFile(new File("src/test/resources/qa-guru.PNG"));
        return this;
    }

    public RegistrationPage typeAdress (String value) {
        adress.setValue(value);
        return this;
    }

    public RegistrationPage choiceState(String state) {
        stateContainer.scrollIntoView(true).click();
        stateCityWrapper.$(byText(state)).click();
        return this;
    }

    public RegistrationPage choiceCity(String city) {
        cityContainer.click();
        stateCityWrapper.$(byText(city)).click();
        return this;
    }
    public RegistrationPage clickSubmit() {
        pressSubmit.pressEnter();
        return this;
    }
    public RegistrationPage checkResultsValue(String key, String value) {
        resultsTable.$(byText(key))
                .parent().shouldHave(text(value));
        return this;
    }






}

