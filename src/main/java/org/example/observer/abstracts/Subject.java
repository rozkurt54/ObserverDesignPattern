package org.example.observer.abstracts;

public interface Subject {

  void register(Observer observer);
  void unRegister(Observer observer);
  void notifyObservers();
  public Object getUpdate(Observer observer);


}
