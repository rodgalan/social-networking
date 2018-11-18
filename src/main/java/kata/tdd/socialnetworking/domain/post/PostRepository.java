package kata.tdd.socialnetworking.domain.post;

import java.util.List;

public interface PostRepository {

  void save(Post post);

  List<Post> findBy(String username);

}
