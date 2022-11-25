import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
public class GetRequest {
    @BeforeClass
    void setup(){
        RestAssured.baseURI = "https://reqres.in";
    }
    @Test
    void getDetails(){
        given().header("Content-Type","application/json")
                .get("/api/users?page=2")
                .then()
                .statusCode(200).log().all();
    }
    @Test
    public static void GetSingleUserDetail(){
        given().get("/api/unknown").then().statusCode(200).log().body();
    }

}
