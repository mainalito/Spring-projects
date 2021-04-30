package io.javabrains.springboot.courses;
import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface CoursesRepository extends CrudRepository<Courses, String> {

	public List<Courses>findByTopicId(String topicId);
	public List<Courses> findByName(String name);
}
