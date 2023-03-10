package org.example;

import org.example.observer.abstracts.Observer;
import org.example.observer.concretes.MyTopic;
import org.example.observer.concretes.MyTopicSubscriber;

public class Main {
  public static void main(String[] args) {
    MyTopic topic = new MyTopic();

    Observer observer1 = new MyTopicSubscriber("observer1");
    Observer observer2 = new MyTopicSubscriber("observer2");
    Observer observer3 = new MyTopicSubscriber("observer2");

    topic.register(observer1);
    topic.register(observer2);
    topic.register(observer3);

    observer1.setSubject(topic);
    observer2.setSubject(topic);
    observer3.setSubject(topic);

    observer1.update();

    topic.postMessage("Notified message");



  }
}