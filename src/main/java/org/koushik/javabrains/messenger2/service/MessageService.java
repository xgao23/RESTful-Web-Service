package org.koushik.javabrains.messenger2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.koushik.javabrains.messenger2.database.DatabaseClass;
import org.koushik.javabrains.messenger2.model.Message;

public class MessageService {
	Map<Long,Message> messages=DatabaseClass.getMessage();
	
	public MessageService(){
		messages.put(1L,new Message(1L,"Hello world","Xian"));
		messages.put(3L,new Message(2L,"Hello everyone","Xian"));
	}
	
	
	
	public List<Message>getAllMessages(){
		List list=new ArrayList(messages.values());
		return list;
	}
	public Message getMessage(long id){
		return messages.get(id);
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	public Message updateMessage(Message message){
		if(message.getId()<=0) return null;
		messages.put(message.getId(),message);
		return message;
	}

}
