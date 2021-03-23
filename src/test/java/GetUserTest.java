import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class GetUserTest extends BaseTest{

    @Test
    public void getTest(){
        given()
                .pathParam("userId", 8)
                .spec(reqSpec).
                when()
                .get("{userId}").
                then()
                .spec(resSpec);
    }

}
