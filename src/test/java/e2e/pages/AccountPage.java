package e2e.pages;

import com.github.javafaker.Faker;
import e2e.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.Objects;

public class AccountPage extends CommonMethods {

    Faker faker = new Faker();
    String userName="";
    String userLastName="";
    String email="";
    String phoneNumber="";
    String password="Password1";
    public AccountPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(partialLinkText = "Sign")
    private WebElement signUpButton;
    @FindBy(xpath = "//h1[contains(text(),'Sign Up')]")
    private WebElement signUpText;
    @FindBy(css = "input[name='userFirstName']")
    private WebElement firstName;
    @FindBy(css = "input[name='userLastName']")
    private WebElement lastName;
    @FindBy(css = "input[name='userEmail']")
    private WebElement userEmail;
    @FindBy(css = "input[name='userPhoneNumber']")
    private WebElement userPhoneNumber;
    @FindBy(css = "input[name='userPassword']")
    private WebElement userPassword;
    @FindBy(css = "input[name='userPasswordRepeat']")
    private WebElement userPasswordRepeat;
    @FindBy(css = "div[class='form-check row '] label")
    private List<WebElement> gender;
    @FindBy(css = ".btn.btn-primary.mt-3")
    private WebElement signUp;
    @FindBy(css = ".alert.alert-success")
    private WebElement alertMessage;
    @FindBy(xpath = "//div[contains(text(),'Minimum eight characters, at least one uppercase letter, one lowercase letter, one number')]")
    private WebElement wrongPassword;

    public void setSignUpButton(){
        click(signUpButton);
    }
    public String setSignUpText(){
        return signUpText.getText();
    }
    public void setFirstName(){
        userName = faker.name().firstName();
        firstName.sendKeys(userName);
    }
    public void setUserLastName(){
        userLastName = faker.name().lastName();
        lastName.sendKeys(userLastName);
    }
    public void setEmail(){
        email=faker.internet().emailAddress();
        userEmail.sendKeys(email);
    }
    public void setPhoneNumber(){
        phoneNumber = faker.phoneNumber().cellPhone();
        userPhoneNumber.sendKeys(phoneNumber);
    }
    public void setPassword(){
        userPassword.sendKeys("password1");
    }
    public void setUserPasswordRepeat(){
        userPasswordRepeat.sendKeys("password1");
    }
    public void setGender(){
        for (WebElement element:
             gender) {
            if (Objects.equals(element.getText(),"Female")){
                element.click();
                System.out.println("radio button for Female is selected");
            }else {
                System.out.println("Not Selected");
            }
        }
    }
    public void setSignUp(){
        click(signUp);
    }
    public String setAlertMessage(){
        Assert.assertTrue(wrongPassword.isDisplayed());
        if (wrongPassword.isDisplayed()){
            userPassword.clear();
            userPassword.sendKeys(password);
            userPasswordRepeat.clear();
            userPasswordRepeat.sendKeys(password);
            click(signUp);
            return alertMessage.getText();
        }else {
            return alertMessage.getText();
        }
    }






}
