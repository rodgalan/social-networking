package kata.tdd.socialnetworking.infrastructure.controllers;

import kata.tdd.socialnetworking.application.usecases.PublishMessage;
import kata.tdd.socialnetworking.application.usecases.ReadUserMessages;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public abstract class SocialNetworkControllerTest {

  @Mock
  protected PublishMessage publishMessage;
  @Mock
  protected ReadUserMessages readUserMessages;

  protected SocialNetworkController socialNetworkController;

  @Before
  public void setUp() {
    socialNetworkController = new SocialNetworkController(publishMessage, readUserMessages);
  }

}
