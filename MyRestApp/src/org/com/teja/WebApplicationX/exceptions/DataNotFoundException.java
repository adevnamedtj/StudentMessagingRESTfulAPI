package org.com.teja.WebApplicationX.exceptions;

public class DataNotFoundException
  extends RuntimeException
{
  private static final long serialVersionUID = 1L;
  
  public DataNotFoundException() {}
  
  public DataNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
  {
    super(message, cause, enableSuppression, writableStackTrace);
  }
  
  public DataNotFoundException(String message, Throwable cause)
  {
    super(message, cause);
  }
  
  public DataNotFoundException(String message)
  {
    super(message);
  }
  
  public DataNotFoundException(Throwable cause)
  {
    super(cause);
  }
}
