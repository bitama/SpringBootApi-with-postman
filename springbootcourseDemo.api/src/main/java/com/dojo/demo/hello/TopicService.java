package com.dojo.demo.hello;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic>topics= new ArrayList<Topic>(Arrays.asList(
			
			new Topic("Python","Django","Django Framework"),
			new Topic("Java","Spring","Spring Framework"),
			new Topic("Javascript","React","React Framework"),
			new Topic("Python","Flask","Flask Framework"),
			new Topic("Javascript","Node","Node Framework"),
			new Topic("CSS","Bootstrap","bootstrap Framework"),
			new Topic("HTM","XML","XML Framework")
			));
	
	public List<Topic>getAllTopics(){
//		List<Topic> topics = new ArrayList<>();
//		topicRepository.findAll().forEach(topics::add);
//		return topics;
		return(List<Topic>)topicRepository.findAll();
	}
	
	
	
	public List<Topic> getTopic(String id){
//		return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
		
		return(List<Topic>)topicRepository.findById(id).orElse(null);
		
	}
	
	public void addTopic( Topic topic) {
		topicRepository.save(topic);
	}
	


	public void updateTopic(String id, Topic topic) {
		for(int i=0; i<topics.size();i++) {
			Topic t= topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}


	public void deleteTopic(String id) {
		topics.removeIf(t->t.getId().equals(id));
	}


}
