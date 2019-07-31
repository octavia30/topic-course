package io.internship.springstart.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopics(){
		//return topics; //without database
		
		//for database
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
		}
	
	public Topic getTopic(String id) {
		//without database
		//return topics.stream().filter(t -> t.getId().contentEquals(id)).findFirst().get();
		
		//for database
		//return topicRepository.findById(id);
		return  topicRepository.findById(id).orElse(null);
	}

	public void addTopic(Topic topic) {
		//topics.add(topic); //without database
		
		//for database
		topicRepository.save(topic);
		
	}

	public void updateTopic(String id, Topic topic) {
		//without database
//		for(int i = 0; i< topics.size(); i++) {
//			Topic t = topics.get(i);
//			if(t.getId().equals(id)) {
//				topics.set(i, topic);
//				return;
//			}
//			
//		}
		
		//for database
		topicRepository.save(topic);
		
	}

	public void deleteTopic(String id) {
		//without database
		//topics.removeIf(t -> t.getId().contentEquals(id));
		topicRepository.deleteById(id);
	}
}
