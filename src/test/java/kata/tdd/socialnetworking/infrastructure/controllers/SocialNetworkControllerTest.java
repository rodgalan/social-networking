package kata.tdd.socialnetworking.infrastructure.controllers;

import kata.tdd.socialnetworking.application.usecases.PublishMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SocialNetworkControllerTest {

  @Mock
  PublishMessage publishMessage;

  @Test
  public void should_publish_a_message() {

    SocialNetworkController socialNetworkController = new SocialNetworkController(publishMessage);
    String username = "Anna";
    String message = "Hellow, I'm here!";
    socialNetworkController.publishMessage(username, message);

    Mockito.verify(publishMessage, Mockito.times(1)).execute(username, message);

  }
}


