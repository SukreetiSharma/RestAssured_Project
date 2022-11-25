package OrangeHRM;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class Retrieve_PIMDataTable {
    @BeforeClass
    void setup(){
        RestAssured.baseURI = "https://demoqa.com";
    }
    @Test
    void getDetails(){
        RestAssured.baseURI = "https://demoqa.com";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/BookStore/v1/Books");
        String Response = response.asString();
        System.out.println("Response Body is =>  " + Response);
    }
}
