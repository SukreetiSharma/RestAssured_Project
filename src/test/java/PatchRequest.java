import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PatchRequest {
        @Test
        void UpdateUserDetails() {
            RestAssured.baseURI = "https://reqres.in/";
            RequestSpecification httpRequest = RestAssured.given();
            //Request payload sending along with post request
            JSONObject RequestParams = new JSONObject();
            RequestParams.put("name", "John");
            RequestParams.put("job", "leader");
            httpRequest.header("Content-Type", "application/json");
            httpRequest.body(RequestParams.toJSONString());
            Response response = httpRequest.request(Method.PATCH, "api/users/2");
            ResponseBody body = response.getBody();
            System.out.println(body.asString());
            String StatusLine = response.getStatusLine();
            System.out.println("Status line is :" + StatusLine);
            Assert.assertEquals(StatusLine, "HTTP/1.1 200 OK");
        }
    }
