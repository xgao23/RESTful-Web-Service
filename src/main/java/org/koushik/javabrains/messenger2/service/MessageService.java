package org.koushik.javabrains.messenger2.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.koushik.javabrains.messenger2.database.DatabaseClass;
import org.koushik.javabrains.messenger2.model.Comment;
import org.koushik.javabrains.messenger2.model.Message;

public class MessageService {
	Map<Long,Message> messages=DatabaseClass.getMessage();
	
	public MessageService(){
		Message m1=new Message(1L,"Hello world","Xian");
		Comment c1=new Comment(1L,"That's great","lala");
		Map<Long, Comment> map=m1.getComments();
		map.put(1L, c1);
		
		messages.put(1L,m1);
		messages.put(2L,new Message(2L,"Hello everyone","Xian"));
	}
	
	
	
	public List<Message>getAllMessages(){
		List list=new ArrayList(messages.values());
		return list;
	}
	
	public List<Message> getAllMessagesForYear(int year){
		List<Message> messagesForYear=new ArrayList<>();
		Calendar cal=Calendar.getInstance();
		for(Message message: messages.values()){
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR)==year){
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}
	public List<Message> getAllMessagesPaginated(int start, int size){
			List<Message> list=new ArrayList<Message>(messages.values());
			if(start+size>list.size()) return new ArrayList<Message>();
			return list.subList(start, start+size);
	}
	
	public Message getMessage(long id){
		return messages.get(id);
	}
	
	public Message addMessage(Message message){
		message.setCreated(new Date());
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	public Message updateMessage(Message message){
		if(message.getId()<=0) return null;
		message.setCreated(new Date());
		messages.put(message.getId(),message);
		return message;
	}



	public boolean deleteMessage(Long id) {
		// TODO Auto-generated method stub
		if(messages.containsKey(id)){
			messages.remove(id);
			return true;
		}
		return false;
	}

}
