package io.javabrains.springbootstarter.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@RequestMapping("/courses")
	public List<Course> getAllCourses() {
		return courseService.getAllCourses();
	}
	
	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getAllCoursesByTopic(@PathVariable Long topicId) {
		return courseService.getAllCourses(topicId);
	}
	
	@RequestMapping("/courses/{id}")
	public Course getCourse(@PathVariable Long id) {
		return courseService.getCourse(id);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value="/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable Long topicId) {
		courseService.addCourse(topicId, course);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable Long topicId, @PathVariable Long id) {
		courseService.updateCourse(topicId, course, id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/courses/{id}")
	public void deleteCourse(@PathVariable Long id) {
		courseService.deleteCourse(id);
	}

}
