package kata.tdd.socialnetworking.infrastructure.configuration;

import kata.tdd.socialnetworking.application.usecases.PublishMessage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCasesConfiguration {

  @Bean
  public PublishMessage publishMessage() {
    return new PublishMessage();
  }

}
