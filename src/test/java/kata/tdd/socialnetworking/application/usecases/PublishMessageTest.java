package kata.tdd.socialnetworking.application.usecases;

import kata.tdd.socialnetworking.domain.post.Post;
import kata.tdd.socialnetworking.domain.post.PostCreationException;
import kata.tdd.socialnetworking.domain.post.PostRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.eq;

@RunWith(MockitoJUnitRunner.class)
public class PublishMessageTest {

  @Mock
  private PostRepository postRepository;

  private PublishMessage publishMessage;

  public static final String MESSAGE = "Hello, I'm the message";
  public static final String USER_NAME = "Anna";

  @Before
  public void setUp() throws Exception {
    publishMessage = new PublishMessage(postRepository);
  }

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

  @Test
  public void should_publish_a_message() {
    publishMessage.execute(USER_NAME, MESSAGE);
    Post expectedPost = new Post(USER_NAME, MESSAGE);
    Mockito.verify(postRepository, Mockito.times(1)).save(eq(expectedPost));
  }
}
