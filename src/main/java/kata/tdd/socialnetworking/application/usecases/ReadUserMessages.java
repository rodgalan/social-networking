package kata.tdd.socialnetworking.application.usecases;

import kata.tdd.socialnetworking.domain.post.Post;
import kata.tdd.socialnetworking.domain.post.PostRepository;

import java.util.List;

public class ReadUserMessages {

  private PostRepository postRepository;

  public ReadUserMessages(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  public List<Post> execute(String username) {
    return postRepository.findBy(username);
  }

}
