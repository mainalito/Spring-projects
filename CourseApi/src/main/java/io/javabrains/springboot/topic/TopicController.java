package io.javabrains.springboot.topic;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@Autowired //checks for a dependency class service
	private TopicService topicService;
	
	@RequestMapping("/test")
	public String test() {
		return "testing";
	}
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAlltopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Optional<Topic> getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST ,value= "/topics") //map the url using post request
	public void addTopic(@RequestBody Topic topic) {//converts the topic body to an instance{
		 topicService.addTopic(topic);
	}
	@RequestMapping(method=RequestMethod.PUT ,value= "/topics/{id}") //map the url using put request
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {//converts the topic body to an instance{
		 topicService.updateTopic(id,topic);
	}
	@RequestMapping(method=RequestMethod.DELETE ,value= "/topics/{id}") //map the delete using post request
	public void deleteTopic(@PathVariable String id) {
		 topicService.deleteTopic(id);
	}
}
