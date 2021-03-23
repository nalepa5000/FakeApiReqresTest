import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class GetUsersTest extends BaseTest{

    @Test
    public void getUsersTest(){
        given()
                .spec(reqSpec)
                .queryParam("page", 2).
                when()
                .get().
                then()
                .spec(resSpec);
    }
}
