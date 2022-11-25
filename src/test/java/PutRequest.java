import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class PutRequest {
    @BeforeClass
    void setup(){
        RestAssured.baseURI = "https://reqres.in";
    }
    @Test
    void UpdateUser(){
        String jsonString = "{\"name\" : \"morpheus\",\"job\" : \"zion resident\"}";
        given().contentType(ContentType.JSON)
                .body(jsonString)
                .when()
                .put("/api/users/2")
                .then().assertThat()
                .statusCode(200)
                .body("name", Matchers.equalTo("morpheus"))
                .body("job", Matchers.equalTo("zion resident")).log().body();
    }
}
