import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest {
    @Test
    void getDetails(){
        RestAssured.baseURI = "https://reqres.in/";
        RequestSpecification httpRequest = given();
        Response response = httpRequest.request(Method.GET);
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is :" + responseBody);
        int StatusCode = response.getStatusCode();
        System.out.println("Status code is : "+ StatusCode);
        Assert.assertEquals(StatusCode,200);
    }
    @Test
    public static void GetSingleUserDetail(){
        given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data.id[0]", equalTo(7));
    }

}
