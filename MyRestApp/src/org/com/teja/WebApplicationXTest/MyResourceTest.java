package org.com.teja.WebApplicationXTest;

import org.com.teja.WebApplicationX.MyResource;
import org.junit.Assert;
import org.junit.Test;

public class MyResourceTest
{
  MyResource myResourceTestClass = new MyResource();
  
  @Test
  public void test()
  {
    Assert.assertEquals("Got it!", this.myResourceTestClass.getIt());
  }
}
