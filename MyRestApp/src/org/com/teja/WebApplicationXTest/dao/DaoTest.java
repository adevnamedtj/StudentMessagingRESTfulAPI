package org.com.teja.WebApplicationXTest.dao;

import java.util.ArrayList;
import org.com.teja.WebApplicationX.dao.Dao;
import org.junit.Assert;
import org.junit.Test;

public class DaoTest
{
  Dao DaoTestClass = new Dao();
  
  @Test
  public void test()
  {
    Assert.assertEquals(new ArrayList(), Dao.getDeletedMessageList());
  }
}
