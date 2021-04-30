package io.javabrains.springboot.courses;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springboot.topic.Topic;

@RestController
public class CourseController {

	
	

		@Autowired //checks for a dependency class service
		private CourseService courseService;
		
		@RequestMapping("/tests")
		public String test() {
			return "testing";
		}
		@RequestMapping("/topic/{id}/courses")
		public List<Courses> getAllcourses(@PathVariable String id) {
			return courseService.getAllcourses(id);
		}
		
		@RequestMapping("/topic/{topicid}/courses/{id}")
		public Optional<Courses> getCourse(@PathVariable String id) {
			return courseService.getCourse(id);
		}
		
		@RequestMapping(method=RequestMethod.POST ,value= "/topic/{topicId}/courses") //map the url using post request
		public void addCourse(@RequestBody Courses courses,@PathVariable String topicId) {//converts the topic body to an instance{
			courses.setTopic(new Topic(topicId,"",""));
			courseService.addCourse(courses);
		}
		@RequestMapping(method=RequestMethod.PUT ,value= "/topic/{topicId}/courses/{id}") //map the url using put request
		public void updateCoure(@RequestBody Courses courses, @PathVariable String topicId) {//converts the topic body to an instance{
			courses.setTopic(new Topic(topicId,"",""));
			courseService.updateCourse(courses);
		}
		@RequestMapping(method=RequestMethod.DELETE ,value= "/topic/{topicId}/courses/{id}") //map the delete using post request
		public void deleteTopic(@PathVariable String id) {
			 courseService.deleteCourse(id);
		}
	}


