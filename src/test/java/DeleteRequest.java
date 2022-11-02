import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeleteRequest {
    @Test
    void deleteUser(){
        RestAssured.baseURI ="https://reqres.in/";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
        Response response = httpRequest.request(Method.DELETE, "api/users/2");
        int s = response.getStatusCode();
        Assert.assertEquals(s, 204);
    }
}
