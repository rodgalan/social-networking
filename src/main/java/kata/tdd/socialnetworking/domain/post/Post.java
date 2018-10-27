package kata.tdd.socialnetworking.domain.post;

import java.util.Objects;

public class Post {
  private final String username;
  private final String message;

  public Post(String username, String message) {

    validateUsername(username);
    validateMessage(message);

    this.username = username;
    this.message = message;
  }

  private void validateMessage(String message) {
    if(message == null || message.trim().isEmpty()){
      throw new PostCreationException("Message cannot be neither null or empty");
    }
  }

  private void validateUsername(String username) {
    if(username==null || username.trim().isEmpty()){
      throw new PostCreationException("Username cannot be neither null or empty");
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Post)) return false;
    Post post = (Post) o;
    return Objects.equals(username, post.username) &&
        Objects.equals(message, post.message);
  }

  @Override
  public int hashCode() {

    return Objects.hash(username, message);
  }
}
