package kata.tdd.socialnetworking.infrastructure.controllers;

import kata.tdd.socialnetworking.domain.post.Post;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

public class SocialNetworkController_ReadMessageTest extends SocialNetworkControllerTest {

  @Test
  public void should_return_requested_user_messages() {
    String requestedUser = "Pedro";
    String user_message = "Pedro Message";
    List<Post> userPosts = Arrays.asList(new Post(requestedUser, user_message));

    when(readUserMessages.execute(eq(requestedUser))).thenReturn(userPosts);

    List<String> userMessages = socialNetworkController.getUserMessages(requestedUser);

    assertThat(userMessages).containsExactly(user_message);

  }
}
