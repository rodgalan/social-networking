package kata.tdd.socialnetworking.infrastructure.repositories;

import kata.tdd.socialnetworking.domain.post.Post;

import java.util.HashMap;
import java.util.Map;

class InMemoryDataStore {

  private final static Map<String, Post> dataStore = new HashMap<>();

  static Post findBy(String username) {
    return dataStore.get(username);
  }

  static void save(Post post) {
    dataStore.put(post.getUsername(), post);
  }
}
