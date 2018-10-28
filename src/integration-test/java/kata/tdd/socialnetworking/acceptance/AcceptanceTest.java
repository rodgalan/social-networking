package kata.tdd.socialnetworking.acceptance;

import io.restassured.RestAssured;
import kata.tdd.socialnetworking.infrastructure.SocialNetworkingApplication;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SocialNetworkingApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class AcceptanceTest {

  @LocalServerPort
  private int port;

  @Before
  public void setup() {
    RestAssured.baseURI = "http://localhost";
    RestAssured.port = port;
  }

}
