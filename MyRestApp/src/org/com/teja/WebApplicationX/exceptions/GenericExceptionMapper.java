package org.com.teja.WebApplicationX.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.com.teja.WebApplicationX.model.ErrorMessage;

@Provider
public class GenericExceptionMapper
  implements ExceptionMapper<Throwable>
{
  public Response toResponse(Throwable Ex)
  {
    ErrorMessage errMessage = new ErrorMessage(Ex.getMessage(), 979, "A Generic Error handeling Service Respose.");
    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errMessage).build();
  }
}
