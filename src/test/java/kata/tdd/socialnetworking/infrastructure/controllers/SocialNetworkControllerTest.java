package kata.tdd.socialnetworking.infrastructure.controllers;

import kata.tdd.socialnetworking.application.usecases.PublishMessage;
import kata.tdd.socialnetworking.domain.post.Post;
import kata.tdd.socialnetworking.domain.post.PostCreationException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.eq;

@RunWith(MockitoJUnitRunner.class)
public class SocialNetworkControllerTest {

  public static final String MESSAGE = "Hello, I'm the message";
  public static final String USER_NAME = "Anna";

  @Mock
  PublishMessage publishMessage;

  private SocialNetworkController socialNetworkController;

  @Before
  public void setUp() throws Exception {
    socialNetworkController = new SocialNetworkController(publishMessage);
  }

  @Test
  public void should_publish_a_message() {
    socialNetworkController.publishMessage(USER_NAME, MESSAGE);
    Mockito.verify(publishMessage, Mockito.times(1)).execute(eq(new Post(USER_NAME, MESSAGE)));
  }

  @Test(expected = PostCreationException.class)
  public void should_not_publish_a_message_without_username() {
    socialNetworkController.publishMessage(null, MESSAGE);
  }

  @Test(expected = PostCreationException.class)
  public void should_not_publish_a_message_with_empty_username() {
    socialNetworkController.publishMessage("", MESSAGE);
  }

  @Test(expected = PostCreationException.class)
  public void should_not_publish_a_message_without_message() {
    socialNetworkController.publishMessage(USER_NAME, null);
  }

  @Test(expected = PostCreationException.class)
  public void should_not_publish_a_message_with_empty_message() {
    socialNetworkController.publishMessage(USER_NAME, " ");
  }
}


