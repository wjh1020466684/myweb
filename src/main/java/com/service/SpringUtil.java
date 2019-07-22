package com.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.sql.DataSource;
import java.sql.Connection;

public class SpringUtil implements ApplicationContextAware {
    private ApplicationContext  applicationContext;

    @Override
    public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext) throws BeansException {
   this.applicationContext=applicationContext;
    }
  private DataSource getDataSource(){
       if(applicationContext!=null){
           Object obj=applicationContext.getBean(DataSource.class);
       }
       return null;
  }

  public Connection getConnection(){
      Connection aa=null;
      return aa;
  }
}
