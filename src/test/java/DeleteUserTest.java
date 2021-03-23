import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class DeleteUserTest extends BaseTest{

    @Test
    public void deleteUser(){
        given()
                .pathParam("userId",5)
                .spec(reqSpec).
                when()
                .delete("{userId}").
                then()
                .statusCode(204);
    }

}
