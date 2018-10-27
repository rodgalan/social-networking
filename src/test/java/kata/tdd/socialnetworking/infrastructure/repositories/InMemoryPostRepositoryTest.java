package kata.tdd.socialnetworking.infrastructure.repositories;

import kata.tdd.socialnetworking.domain.post.Post;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class InMemoryPostRepositoryTest {

  private InMemoryPostRepository inMemoryPostRepository = new InMemoryPostRepository();

  @Test
  public void should_save_a_post() {
    Post post = new Post("Anna", "New Message");

    inMemoryPostRepository.save(post);

    Post expectedSavedPost = InMemoryDataStore.findBy(post.getUsername());

    assertThat(post).isEqualTo(expectedSavedPost);
  }
}
