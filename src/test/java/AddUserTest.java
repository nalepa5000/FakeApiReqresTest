import io.restassured.http.ContentType;
import model.User;
import org.testng.annotations.Test;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class AddUserTest extends BaseTest {

    @Test
    public void addUserClass(){
        User newUser = new User();
        newUser.setEmail("new.user@reqres.in");
        newUser.setFirst_name("New");
        newUser.setLast_name("User");

        given()
                .spec(reqSpec)
                .contentType(ContentType.JSON)
                .body(newUser).
                when()
                .post().
                then()
                .statusCode(201);
    }

    @Test
    public void addUserFile(){
        File newUser = new File("src/test/resources/user.json");
        given()
                .spec(reqSpec)
                .contentType(ContentType.JSON)
                .body(newUser).
                when()
                .post().
                then()
                .statusCode(201);
    }

    @Test
    public void addUserMap(){
        Map<String,Object> newUser = new HashMap<>();
        newUser.put("first_name", "Karol");
        newUser.put("last_name", "Krzesiwo");
        newUser.put("email","kacper.krzesiwo@tester.in");
        given()
                .spec(reqSpec)
                .contentType(ContentType.JSON)
                .body(newUser).
                when()
                .post().
                then()
                .statusCode(201);
    }

}
