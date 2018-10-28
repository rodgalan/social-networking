package kata.tdd.socialnetworking.acceptance;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;
import static java.net.HttpURLConnection.HTTP_CREATED;
import static java.net.HttpURLConnection.HTTP_UNSUPPORTED_TYPE;

public class PostAcceptanceTest extends AcceptanceTest {

  @Test
  public void should_publish_a_message() {
    String username = "Anna";
    String message = "Hello world, I'm here!";
    String body = new ObjectMapper().createObjectNode().put("message", message).toString();

    given()
        .pathParam("username", username)
        .body(body)
        .contentType("application/json")
        .post("/user/{username}/post")
        .then().statusCode(HTTP_CREATED);
  }

  @Test
  public void should_fail_when_content_type_is_not_valid() {
    String username = "Anna";
    String message = "Hello world, I'm here!";
    String body = new ObjectMapper().createObjectNode().put("message", message).toString();

    given()
        .pathParam("username", username)
        .body(body)
        .post("/user/{username}/post")
        .then().statusCode(HTTP_UNSUPPORTED_TYPE);

  }

  @Test
  public void should_fail_when_body_is_not_present() {
    String username = "Anna";

    given()
        .pathParam("username", username)
        .contentType("application/json")
        .post("/user/{username}/post")
        .then().statusCode(HTTP_BAD_REQUEST);
  }

  @Test
  public void should_fail_when_data_is_not_valid() throws JsonProcessingException {
    String username = "Anna";
    ObjectMapper objectMapper = new ObjectMapper();
    ObjectNode a = objectMapper.createObjectNode().put("message", " ");
    String body = objectMapper.writeValueAsString(a);

    given()
        .pathParam("username", username)
        .body(body)
        .contentType("application/json")
        .post("/user/{username}/post")
        .then().statusCode(HTTP_BAD_REQUEST);
  }
}
