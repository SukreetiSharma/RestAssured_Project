import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class AuthorizationKey {
    @Test
    void Authorization(){
        RestAssured.baseURI = "http://api.weatherapi.com/v1";
        given()
                .header("key", "50d72609b90f4566816162026220311")
                .header("Accept", "application/json")
                .queryParam("q", "Paris")
                .get("/forecast.json")
                .then()
                .log().all();
    }
}
