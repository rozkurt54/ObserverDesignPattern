package org.example.observer.abstracts;

public interface Observer {

  public void update();

  public void setSubject(Subject subject);
}
