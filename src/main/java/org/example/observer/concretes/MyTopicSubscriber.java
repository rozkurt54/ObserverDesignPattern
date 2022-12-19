package org.example.observer.concretes;

import org.example.observer.abstracts.Observer;
import org.example.observer.abstracts.Subject;

public class MyTopicSubscriber implements Observer {

  private String name;
  private Subject topic;

  public MyTopicSubscriber(String name) {
    this.name = name;
  }

  @Override
  public void update() {

    String msg = (String) topic.getUpdate(this);
    if(msg == null) {
      System.out.println(name +":: No new message");
    }
    else {
      System.out.println(name+":: Consuming message:" + msg);
    }


  }

  @Override
  public void setSubject(Subject subject) {
    this.topic = subject;
  }
}
