package kata.tdd.socialnetworking.infrastructure.configuration;

import kata.tdd.socialnetworking.application.usecases.PublishMessage;
import kata.tdd.socialnetworking.application.usecases.ReadUserMessages;
import kata.tdd.socialnetworking.domain.post.PostRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCasesConfiguration {

  @Bean
  public PublishMessage publishMessage(PostRepository postRepository) {
    return new PublishMessage(postRepository);
  }

  @Bean
  public ReadUserMessages readUserMessages(PostRepository postRepository){
    return new ReadUserMessages(postRepository);
  }

}
