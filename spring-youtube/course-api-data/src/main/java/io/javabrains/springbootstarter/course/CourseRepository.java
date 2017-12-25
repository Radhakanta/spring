package io.javabrains.springbootstarter.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long>{
	public List<Course> findByName(String name);
	public List<Course> findByDescription(String description);
	public List<Course> findByTopicId(Long topicId);
}
