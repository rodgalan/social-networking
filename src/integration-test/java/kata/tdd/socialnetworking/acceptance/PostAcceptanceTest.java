package kata.tdd.socialnetworking.acceptance;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.restassured.RestAssured;
import kata.tdd.socialnetworking.infrastructure.SocialNetworkingApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SocialNetworkingApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AcceptanceTest {

  @LocalServerPort
  private int port;

  @Before
  public void setup() {
    RestAssured.baseURI = "http://localhost";
    RestAssured.port = port;
  }

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
        .then().statusCode(HttpStatus.CREATED.value());
  }

  @Test
  public void should_not_publish_a_message_when_content_type_is_not_valid() {
    String username = "Anna";
    String message = "Hello world, I'm here!";
    String body = new ObjectMapper().createObjectNode().put("message", message).toString();

    given()
        .pathParam("username", username)
        .body(body)
        .post("/user/{username}/post")
        .then().statusCode(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value());
  }

  @Test
  public void should_not_publish_a_message_when_body_is_not_present() {
    String username = "Anna";

    given()
        .pathParam("username", username)
        .contentType("application/json")
        .post("/user/{username}/post")
        .then().statusCode(HttpStatus.BAD_REQUEST.value());
  }

  @Test
  public void should_not_publish_a_message_when_data_is_not_valid() throws JsonProcessingException {
    String username = "Anna";
    ObjectMapper objectMapper = new ObjectMapper();
    ObjectNode a = objectMapper.createObjectNode().put("message", " ");
    String body = objectMapper.writeValueAsString(a);

    given()
        .pathParam("username", username)
        .body(body)
        .contentType("application/json")
        .post("/user/{username}/post")
        .then().statusCode(HttpStatus.BAD_REQUEST.value());
  }
}
