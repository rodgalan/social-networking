package kata.tdd.socialnetworking.acceptance;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import kata.tdd.socialnetworking.infrastructure.SocialNetworkingApplication;
import org.junit.Before;
import org.junit.Ignore;
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
  @Ignore
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
  public void should_not_publish_a_message_when_non_valid_request() {
    String username = "Anna";

    given()
        .pathParam("username", username)
        .contentType("application/json")
        .post("/user/{username}/post")
        .then().statusCode(HttpStatus.BAD_REQUEST.value());
  }
}
