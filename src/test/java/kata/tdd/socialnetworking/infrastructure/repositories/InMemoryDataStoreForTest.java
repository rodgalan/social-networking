package kata.tdd.socialnetworking.infrastructure.repositories;

public class InMemoryDataStoreForTest extends InMemoryDataStore{
  void clean(){
    dataStore.clear();
  }
}
