import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostRequest {
    @BeforeClass
    void setup(){
        RestAssured.baseURI = "https://reqres.in/";
    }
    @Test
    void RecordCreated(){
        RequestSpecification httpRequest = given();
        JSONObject RequestParams = new JSONObject();
        RequestParams.put("name","morpheus");
        RequestParams.put("job","leader");
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(RequestParams.toJSONString());
        Response response = httpRequest.request(Method.POST,"api/users");
        ResponseBody body = response.getBody();
        System.out.println(body.asString());
        String StatusLine = response.getStatusLine();
        System.out.println("Status line is :" +StatusLine);
        Assert.assertEquals(StatusLine,"HTTP/1.1 201 Created");
    }
}

