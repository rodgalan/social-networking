package kata.tdd.socialnetworking.infrastructure.controllers;

import kata.tdd.socialnetworking.domain.post.Post;
import kata.tdd.socialnetworking.domain.post.PostCreationException;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.eq;

public class SocialNetworkController_PublishMessageTest extends SocialNetworkControllerTest {

  public static final Map<String, String> BODY = new HashMap<String, String>() {{
    put("message", "Hello, I'm the message");
  }};

  public static final String USER_NAME = "Anna";

  @Test
  public void should_publish_a_message() {
    socialNetworkController.publishMessage(USER_NAME, BODY);
    Mockito.verify(publishMessage, Mockito.times(1)).execute(eq(new Post(USER_NAME, BODY.get("message"))));
  }

  @Test(expected = PostCreationException.class)
  public void should_not_publish_a_message_without_username() {
    socialNetworkController.publishMessage(null, BODY);
  }

  @Test(expected = PostCreationException.class)
  public void should_not_publish_a_message_with_empty_username() {
    socialNetworkController.publishMessage("", BODY);
  }

  @Test(expected = PostCreationException.class)
  public void should_not_publish_a_message_without_message() {
    Map<String,String> BODY_WITHOUT_MESSAGE = new HashMap<>();

    socialNetworkController.publishMessage(USER_NAME, BODY_WITHOUT_MESSAGE);
  }

  @Test(expected = PostCreationException.class)
  public void should_not_publish_a_message_with_empty_message() {
    Map<String,String> BODY_WITH_EMPTY_MESSAGE = new HashMap<String, String>(){{
      put("message", " ");
    }};

    socialNetworkController.publishMessage(USER_NAME, BODY_WITH_EMPTY_MESSAGE);
  }
}


