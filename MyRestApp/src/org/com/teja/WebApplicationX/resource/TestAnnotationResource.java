package org.com.teja.WebApplicationX.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/test")
@Consumes({"text/plain"})
@Produces({"text/plain"})
public class TestAnnotationResource
{
  @GET
  @Path("/annotations")
  public String testing(@MatrixParam("param") String MatrixParam, @HeaderParam("param2") String HeaderParam, @CookieParam("param3") String Cookie)
  {
    return MatrixParam + HeaderParam + Cookie;
  }
}
