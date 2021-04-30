package io.javabrains.springboot.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//business are singleton --> spring creates an instance of this class and holds unto it.

@Service
public class TopicService {
	
	@Autowired // this allows one to use another class 
	private TopicRepository topicRepository;
	
	
	public List<Topic> getAlltopics(){
		//return topics;
		
		List<Topic> topics = new ArrayList<>();
		
		topicRepository.findAll() //returns all instances in the table
		//we need to iterate 
		.forEach(topics::add); //we have used method reference RESEARCH MORE ABOUT THIS
		
		return topics;
	}
	
	public Optional<Topic> getTopic(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		//lambda expressions
		 return topicRepository.findById(id);
	}
	public void addTopic(Topic topic) {
//		topics.add(topic);
		topicRepository.save(topic); //save the topic object to the db
	}

	public void updateTopic(String id,Topic topic) {
		
		// TODO Auto-generated method stub
		topicRepository.save(topic); //updates
	}

	public void deleteTopic(String id) {
		// TODO Auto-generated method stub
		topicRepository.deleteById(id);
		//topics.removeIf(t -> t.getId().equals(id));
	}
	
}
