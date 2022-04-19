import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static java.time.zone.ZoneRulesProvider.refresh; //?
import static org.hamcrest.Matchers.is;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import java.util.Map;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DemoWebShopWishlist {

    @Test
    //тесты на вишлист (ОБРАЗЕЦ!)
    @Tag("demowebshop")
    @DisplayName("Add Item. Wishlist. Demowebshop (UI)")
    void addToWishListTest() {

        for(int i = 0; i<10; i++) {
         given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body("addtocart_51.EnteredQuantity=1")
                .when()
                .post("http://demowebshop.tricentis.com/addproducttocart/details/51/2")
                .then()
                .log().all()
                .statusCode(200)
                .body("success", is(true))
                .body("message", is("The product has been added to your " +
                                "<a href=\"/wishlist\">wishlist</a>"
                              //"<a href=\"/cart\">shopping cart</a>"
                      ))
 //               .body("updatetopcartsectionhtml", is("\"(1)\"")); //?
                .body("updatetopwishlistsectionhtml", is(notNullValue())
                ); //??
    }

    // Закрываем браузер
    closeWebDriver();
}
}
