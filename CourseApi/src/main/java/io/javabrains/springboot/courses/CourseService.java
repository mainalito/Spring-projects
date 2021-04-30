package io.javabrains.springboot.courses;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CourseService {

	@Autowired // this allows one to use another class 
	private CoursesRepository courseRepository;
	

	
	public Optional<Courses> getCourse(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		//lambda expressions
		 return courseRepository.findById(id);
	}
	public void addCourse(Courses course) {
//		topics.add(topic);
		courseRepository.save(course); //save the topic object to the db
	}

	public void updateCourse(Courses course) {
		
		// TODO Auto-generated method stub
		courseRepository.save(course); //updates
	}

	public void deleteCourse(String id) {
		// TODO Auto-generated method stub
		courseRepository.deleteById(id);
		//topics.removeIf(t -> t.getId().equals(id));
	}

	public List<Courses> getAllcourses(String topicId) {
	//return topics;
		
		List<Courses> courses = new ArrayList<>();
		
		courseRepository.findByTopicId(topicId) //returns all instances in the table
		//we need to iterate 
		.forEach(courses::add); //we have used method reference RESEARCH MORE ABOUT THIS
		
		return courses;
	}
	
}


