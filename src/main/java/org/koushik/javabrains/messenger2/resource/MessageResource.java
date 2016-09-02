package org.koushik.javabrains.messenger2.resource;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.koushik.javabrains.messenger2.model.Message;
import org.koushik.javabrains.messenger2.resource.beans.MessageFilterBean;
import org.koushik.javabrains.messenger2.service.MessageService;

@Path("/messages")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class MessageResource {
	MessageService messageService=new MessageService();

	
	@GET	
	public List<Message> getMessages(@BeanParam MessageFilterBean filterBean){
		if(filterBean.getYear()>0) return messageService.getAllMessagesForYear(filterBean.getYear());
		if(filterBean.getStart()>0&&filterBean.getSize()>=0){
			return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		
		return messageService.getAllMessages(); 
	}
	@POST
	public Message addMessage(Message message){
		return messageService.addMessage(message);
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") Long messageId){
		return messageService.getMessage(messageId);
	}

	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") Long id,Message message){
		message.setId(id);
		return messageService.updateMessage(message);
		
	}
	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean deleteMessage(@PathParam("messageId")Long id){
		return messageService.deleteMessage(id);
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource(){
		return new CommentResource();
	}
	
	
	

}
