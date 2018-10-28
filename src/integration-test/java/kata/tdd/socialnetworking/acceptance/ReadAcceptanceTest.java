package kata.tdd.socialnetworking.acceptance;

import org.junit.Ignore;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;
import static java.net.HttpURLConnection.HTTP_OK;

public class ReadAcceptanceTest extends AcceptanceTest {

  @Test
  public void should_fail_when_non_informed_username() {
    given()
        .accept("application/json")
        .get("/read")
        .then()
        .statusCode(HTTP_BAD_REQUEST)
        .contentType("application/json");
  }

  @Ignore
  @Test
  public void should_read_a_user_messages() {
    //TODO: To be decided if validate response json here is a good idea (I think yes?)
    given()
        .param("username", "Pedro")
        .accept("application/json")
        .get("/read")
        .then()
        .statusCode(HTTP_OK)
        .contentType("application/json");
  }
}
