package io.javabrains.springbootstarter.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.springbootstarter.topic.Topic;
import io.javabrains.springbootstarter.topic.TopicService;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;	
	
	@Autowired
	TopicService topicService;

	public List<Course> getAllCourses(){
		List<Course> courses = new ArrayList<>();
		courseRepository.findAll().forEach(courses::add);
		return courses;
	}
	
	public List<Course> getAllCourses(Long topicId){
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}
	
	public Course getCourse(Long id) {
		return courseRepository.findOne(id);
	}	
	
	public void updateCourse(Long id, Course course) {
		courseRepository.save(course);
	}
	
	public void deleteCourse(Long id) {
		courseRepository.delete(id);
	}

	public void addCourse(Long topicId, Course course) {
		Topic topic = topicService.getTopic(topicId);
		course.setTopic(topic);
		courseRepository.save(course);
	}

	public void updateCourse(Long topicId, Course course, Long id) {		
		Topic topic = topicService.getTopic(topicId);
		course.setTopic(topic);
		courseRepository.save(course);
	}
}
