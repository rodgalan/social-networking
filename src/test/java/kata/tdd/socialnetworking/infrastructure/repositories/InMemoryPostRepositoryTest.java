package kata.tdd.socialnetworking.infrastructure.repositories;

import kata.tdd.socialnetworking.domain.post.Post;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InMemoryPostRepositoryTest {

  private InMemoryPostRepository inMemoryPostRepository = new InMemoryPostRepository();

  @Test
  public void should_save_two_posts() {
    String username = "Maria";
    Post post_1 = new Post(username, "New Message 1");
    Post post_2 = new Post(username, "New Message 2");

    inMemoryPostRepository.save(post_1);
    inMemoryPostRepository.save(post_2);

    List<Post> expectedSavedPosts = InMemoryDataStore.findBy(username);

    assertThat(expectedSavedPosts).containsExactlyInAnyOrder(post_1, post_2);
  }

}
