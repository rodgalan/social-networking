package kata.tdd.socialnetworking.infrastructure.controllers;

import kata.tdd.socialnetworking.application.usecases.PublishMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SocialNetworkController {

  private final PublishMessage publishMessage;

  public SocialNetworkController(PublishMessage publishMessage) {
    this.publishMessage = publishMessage;
  }

  @RequestMapping(value = "/user/{username}/post", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public void publishMessage(@PathVariable(name = "username") String username, @RequestBody String message) {
    publishMessage.execute(username, message);
  }
}
