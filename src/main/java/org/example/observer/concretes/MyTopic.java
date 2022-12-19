package org.example.observer.concretes;

import org.example.observer.abstracts.Observer;
import org.example.observer.abstracts.Subject;

import java.util.ArrayList;
import java.util.List;

public class MyTopic implements Subject {

  private List<Observer> observerList;
  private String message;

  private boolean isChanged;
  private  final Object MUTEX = new Object();

  public MyTopic() {
    this.observerList = new ArrayList<>();
  }


  @Override
  public void register(Observer observer) {
    if(observer == null) {
      throw new NullPointerException("Null observer");
    }
    synchronized (MUTEX) {
      if(!observerList.contains(observer)) {
        observerList.add(observer);
      }
    }
  }

  @Override
  public void unRegister(Observer observer) {
    synchronized (MUTEX) {
      observerList.remove(observer);
    }
  }

  @Override
  public void notifyObservers() {

    List<Observer> observerListLocal = null;
    synchronized (MUTEX) {
      if(!isChanged){
        return;
      }
      observerListLocal = new ArrayList<>(this.observerList);
    }
    for (Observer observer : observerListLocal) {
      observer.update();
    }

  }

  @Override
  public Object getUpdate(Observer observer) {
    return this.message;
  }

  public void postMessage(String msg) {
    System.out.println("Message posted to topic:" + msg);
    this.message = msg;
    this.isChanged = true;
    notifyObservers();


  }

}
