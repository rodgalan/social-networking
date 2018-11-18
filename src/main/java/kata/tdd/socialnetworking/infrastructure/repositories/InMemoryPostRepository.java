package kata.tdd.socialnetworking.infrastructure.repositories;

import kata.tdd.socialnetworking.domain.post.Post;
import kata.tdd.socialnetworking.domain.post.PostRepository;

import java.util.List;

public class InMemoryPostRepository implements PostRepository {
  private final InMemoryDataStore inMemoryDataStore;

  public InMemoryPostRepository(InMemoryDataStore inMemoryDataStore) {
    this.inMemoryDataStore = inMemoryDataStore;
  }

  @Override
  public void save(Post post) {
    inMemoryDataStore.save(post);
  }

  @Override
  public List<Post> findBy(String username) {
    return inMemoryDataStore.findBy(username);
  }
}
