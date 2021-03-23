import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    static RequestSpecification reqSpec;
    static ResponseSpecification resSpec;

    @BeforeSuite
    public void setUp(){
        reqSpec = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .setBasePath("/api/users")
                .build();
        resSpec = new ResponseSpecBuilder()
                .expectStatusCode(200).build();

        ResponseLoggingFilter resFilter = new ResponseLoggingFilter();
        RequestLoggingFilter reqFilter = new RequestLoggingFilter();
        RestAssured.filters(reqFilter, resFilter);
    }

}