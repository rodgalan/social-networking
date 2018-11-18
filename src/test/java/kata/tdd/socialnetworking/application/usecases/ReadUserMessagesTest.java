package kata.tdd.socialnetworking.application.usecases;

import kata.tdd.socialnetworking.domain.post.Post;
import kata.tdd.socialnetworking.domain.post.PostRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReadUserMessagesTest {

  @Mock
  PostRepository postRepository;

  @Test
  public void should_get_requested_user_messages() {
    String username = "Pedro";

    List<Post> expected_posts = new ArrayList<>(Arrays.asList(
        new Post(username, "Hola"),
        new Post(username, "Adios")));

    when(postRepository.findBy(eq(username))).thenReturn(expected_posts);

    ReadUserMessages readUserMessages = new ReadUserMessages(postRepository);

    List<Post> userPosts = readUserMessages.execute(username);

    assertThat(userPosts).isEqualTo(expected_posts);
  }

}
