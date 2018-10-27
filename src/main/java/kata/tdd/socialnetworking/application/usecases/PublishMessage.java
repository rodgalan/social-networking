package kata.tdd.socialnetworking.application.usecases;

import kata.tdd.socialnetworking.domain.post.Post;

public class PublishMessage {

  public void execute(String username, String message) {
    new Post(username, message);
  }
}
