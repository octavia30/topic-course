package io.internship.springstart.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
//	private List<Course> courses = new ArrayList<>(Arrays.asList(
//			new Course("id1","name1","description1"),
//			new Course("id2","name2","description2"),
//			new Course("id3","name3","description3"),
//			new Course("id4","name4","description4")
//			));
	
	public List<Course> getAllCourses(String topicId){
		//for database
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId)
		.forEach(courses::add);
		return courses;
		}
	
	public Course getCourse(String id) {
		//for database
		//courseRepository.findByName(name);
		return  courseRepository.findById(id).orElse(null);
	}

	public void addCourse(Course course) {
		//for database
		courseRepository.save(course);
		
	}

	public void updateCourse(Course course) {
		//for database
		courseRepository.save(course);
		
	}

	public void deleteCourse(String id) {
		//for database
		courseRepository.deleteById(id);
	}
}
