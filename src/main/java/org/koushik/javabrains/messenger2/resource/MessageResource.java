package org.koushik.javabrains.messenger2.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.koushik.javabrains.messenger2.model.Message;
import org.koushik.javabrains.messenger2.service.MessageService;

@Path("/messages")
public class MessageResource {
	MessageService messageService=new MessageService();
	
	
	@GET
	@Produces(MediaType.APPLICATION_XML)

	public List<Message> getMessages(){
		return messageService.getAllMessages(); 
	}

}
