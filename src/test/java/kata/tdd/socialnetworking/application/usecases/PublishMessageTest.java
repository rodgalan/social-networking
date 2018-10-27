package kata.tdd.socialnetworking.application.usecases;

import kata.tdd.socialnetworking.domain.post.PostCreationException;
import org.junit.Test;

public class PublishMessageTest {

  private final PublishMessage publishMessage = new PublishMessage();
  public static final String MESSAGE = "Hello, I'm the message";
  public static final String USER_NAME = "Anna";

  @Test(expected = PostCreationException.class)
  public void should_not_publish_a_message_without_username() {
    publishMessage.execute(null, MESSAGE);
  }

  @Test(expected = PostCreationException.class)
  public void should_not_publish_a_message_with_empty_username() {
    publishMessage.execute("", MESSAGE);
  }

  @Test(expected = PostCreationException.class)
  public void should_not_publish_a_message_without_message() {
    publishMessage.execute(USER_NAME, null);
  }

  @Test(expected = PostCreationException.class)
  public void should_not_publish_a_message_with_empty_message() {
    publishMessage.execute(USER_NAME, " ");
  }
}
