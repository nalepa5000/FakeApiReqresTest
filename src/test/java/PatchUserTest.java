import io.restassured.http.ContentType;
import model.User;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class PatchUserTest extends BaseTest {

    @Test
    public void patchUser(){
        User newUser = User.builder().email("new.email@reqres.in").build();

        given()
                .spec(reqSpec)
                .pathParam("userId", 5)
                .contentType(ContentType.JSON)
                .body(newUser).
                when()
                .patch("{userId}").
                then()
                .spec(resSpec);

    }

}
