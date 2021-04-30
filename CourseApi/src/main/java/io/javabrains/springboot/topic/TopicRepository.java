package io.javabrains.springboot.topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> {

	//Topic is the entity class we are working with
	
	// next add the id of the class
	
	//getAllTopics()
	//getTopic(String id)
	//updateTopic(Topic t)
	//deleteTopic(String id)
	//the frameworks has an inbuilt methods for CRUD OPERATIONS . NO NEED TO WRITE THE DATA LAYER
	//research about interfaces
	
}
