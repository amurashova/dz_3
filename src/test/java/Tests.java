import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Tests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {
        //открыть страницу, убрать баннер
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");
        //имя
        $("#firstName").setValue("Anastasiya");
        //фамилия
        $("#lastName").setValue("Murashova");
        //емейл
        $("#userEmail").setValue("qwe@qwe.qwe");
        //пол
        $(byText("Female")).click();
        //номер телефона
        $("#userNumber").setValue("0123456789");
        //дата рождения
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1995");
        //клик для закрытия дата пикера
        $("body").click();
        //навыки
        $("#subjectsInput").setValue("e");
        $(byText("English")).click();
        //хобби
        $("label[for='hobbies-checkbox-1']").click();
        //загрузка картинки
        $("#uploadPicture").uploadFromClasspath("dog.jpg");
        //ввод адреса
        $("#currentAddress").setValue("Morozova srt., 12-74").click();
        $("#state input").setValue("N");
        $(byText("NCR")).click();
        $("#city input").setValue("D").click();
        $(byText("Delhi")).click();
        //отправка введенных значений
        $("#submit").click();
        //проверка введенных значений
        $("[class=table-responsive]").shouldHave(text("Anastasiya Murashova"));
        $("[class=table-responsive]").shouldHave(text("qwe@qwe.qwe"));
        $("[class=table-responsive]").shouldHave(text("Female"));
        $("[class=table-responsive]").shouldHave(text("0123456789"));
        $("[class=table-responsive]").shouldHave(text("16 February,1995"));
        $("[class=table-responsive]").shouldHave(text("English"));
        $("[class=table-responsive]").shouldHave(text("Sports"));
        $("[class=table-responsive]").shouldHave(text("dog.jpg"));
        $("[class=table-responsive]").shouldHave(text("Morozova srt., 12-74"));
        $("[class=table-responsive]").shouldHave(text("NCR Delhi"));

        //закрытие формы
        $("#closeLargeModal").click();

    }
}
