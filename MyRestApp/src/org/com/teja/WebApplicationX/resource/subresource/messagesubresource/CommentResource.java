package org.com.teja.WebApplicationX.resource.subresource.messagesubresource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import org.com.teja.WebApplicationX.exceptions.DataNotFoundException;
import org.com.teja.WebApplicationX.model.Comment;
import org.com.teja.WebApplicationX.services.CommentService;

@Path("/")
@Produces({"application/json"})
@Consumes({"application/json"})
public class CommentResource
{
  private CommentService commentService = new CommentService();
  
  @GET
  public List<Comment> getComments(@PathParam("MessageId") Integer messageId)
  {
    return this.commentService.getMessageComments(messageId);
  }
  
  @POST
  public Response addComment(@PathParam("MessageId") Integer messageId, Comment comment, @Context UriInfo uriInfo)
    throws URISyntaxException
  {
    Comment commentTemp = this.commentService.addComment(messageId, comment);
    String IdString = commentTemp.getCommentid().toString();
    URI uri = uriInfo.getAbsolutePathBuilder().path(IdString).build(new Object[0]);
    return Response.created(uri).entity(commentTemp).build();
  }
  
  @PUT
  @Path("/{CommentId}")
  public Comment updateComment(@PathParam("MessageId") Integer messageId, @PathParam("CommentId") Integer commentId, Comment comment)
  {
    return this.commentService.updateComment(messageId, comment);
  }
  
  @DELETE
  @Path("/{CommentId}")
  public Comment deleteComment(@PathParam("MessageId") Integer messageId, @PathParam("CommentId") Integer commentId)
  {
    return this.commentService.deleteComment(messageId, commentId);
  }
  
  @GET
  @Path("/{CommentId}")
  public Comment getACommentOfAMessage(@PathParam("MessageId") Integer messageId, @PathParam("CommentId") Integer commentId)
  {
    Comment commentTemp = this.commentService.getACommentOfMessage(messageId, commentId);
    if (commentTemp == null) {
      throw new DataNotFoundException("Comment with ID " + commentId + " of Message " + messageId + " is not available");
    }
    return commentTemp;
  }
}
