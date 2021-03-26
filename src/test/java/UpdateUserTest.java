import io.restassured.http.ContentType;
import model.User;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class UpdateUserTest extends BaseTest{

    @Test
    public void updateUser(){
        User newUser = User.builder().email("some.email@reqres.in").build();

        given()
                .spec(reqSpec)
                .pathParam("userId", 2)
                .contentType(ContentType.JSON)
                .body(newUser).
                when()
                .put("{userId}").
                then()
                .spec(resSpec);

    }
}
