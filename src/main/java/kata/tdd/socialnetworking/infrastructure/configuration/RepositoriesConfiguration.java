package kata.tdd.socialnetworking.infrastructure.configuration;

import kata.tdd.socialnetworking.domain.post.PostRepository;
import kata.tdd.socialnetworking.infrastructure.repositories.InMemoryDataStore;
import kata.tdd.socialnetworking.infrastructure.repositories.InMemoryPostRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoriesConfiguration {

  @Bean
  public PostRepository postRepository(InMemoryDataStore inMemoryDataStore) {
    return new InMemoryPostRepository(inMemoryDataStore);
  }

  @Bean
  public InMemoryDataStore inMemoryDataStore(){
    return new InMemoryDataStore();
  }

}
