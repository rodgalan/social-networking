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

  @Before
  public void setUp() throws Exception {
    publishMessage = new PublishMessage(postRepository);
  }

  @Test
  public void should_publish_a_message() {
    Post post = new Post("Anna", "Hello, I'm the message");
    publishMessage.execute(post);
    Mockito.verify(postRepository, Mockito.times(1)).save(eq(post));
  }
}
