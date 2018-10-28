package kata.tdd.socialnetworking.infrastructure.controllers;

import kata.tdd.socialnetworking.application.usecases.PublishMessage;
import kata.tdd.socialnetworking.application.usecases.ReadUserMessages;
import kata.tdd.socialnetworking.domain.post.Post;
import kata.tdd.socialnetworking.domain.post.PostCreationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class SocialNetworkController {

  private final PublishMessage publishMessage;
  private final ReadUserMessages readUserMessages;

  public SocialNetworkController(PublishMessage publishMessage, ReadUserMessages readUserMessages) {
    this.publishMessage = publishMessage;
    this.readUserMessages = readUserMessages;
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(path = "/user/{username}/post", consumes = MediaType.APPLICATION_JSON_VALUE)
  public void publishMessage(@PathVariable(name = "username") String username, @RequestBody Map<String, String> body) {
    publishMessage.execute(new Post(username, body.get("message")));
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(path="/read", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<String> getUserMessages(@RequestParam String username) {
    List<Post> execute = readUserMessages.execute(username);
    return execute.stream().map(post -> post.getMessage()).collect(Collectors.toList());
  }


  @ExceptionHandler(PostCreationException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public String handleException(PostCreationException exception) {
    return exception.getMessage();
  }

}
