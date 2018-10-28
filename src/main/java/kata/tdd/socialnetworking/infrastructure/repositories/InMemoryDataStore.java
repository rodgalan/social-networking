package kata.tdd.socialnetworking.infrastructure.repositories;

import kata.tdd.socialnetworking.domain.post.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class InMemoryDataStore {

  private final static Map<String, List<Post>> dataStore = new HashMap<>();

  static List<Post> findBy(String username) {
    return dataStore.get(username);
  }

  static void save(Post post) {
    List<Post> userPostsList = dataStore.getOrDefault(post.getUsername(), new ArrayList<Post>());
    userPostsList.add(post);
    dataStore.put(post.getUsername(), userPostsList);
  }
}
