package kata.tdd.socialnetworking.application.usecases;

import kata.tdd.socialnetworking.domain.post.Post;
import kata.tdd.socialnetworking.domain.post.PostRepository;

public class PublishMessage {

  private final PostRepository postRepository;

  public PublishMessage(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  public void execute(String username, String message) {
    Post post = new Post(username, message);
    postRepository.save(post);
  }
}
