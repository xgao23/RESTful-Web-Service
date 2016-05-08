package org.koushik.javabrains.messenger2.service;

import java.util.ArrayList;
import java.util.List;

import org.koushik.javabrains.messenger2.model.Message;

public class MessageService {
	
	
	public List<Message>getAllMessages(){
		Message m1= new Message(1L,"Hello World","Xian");
		Message m2= new Message(2L,"Hello everyone","Xian");
		List<Message> list=new ArrayList<Message>();
		list.add(m1);
		list.add(m2);
		return list;
	}

}
