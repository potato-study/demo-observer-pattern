package me.minikuma.inJava;

import java.util.Observable;
import java.util.Observer;

/**
 *  Observer interface
 *  Observable class
 */
public class ObserverInJava {

    static class User implements Observer { // deprecated java 9 +
        @Override
        public void update(Observable o, Object arg) {
            System.out.println(arg);
        }
    }

    static class Subject extends Observable {
        public void add(String message) {
            setChanged();
            notifyObservers(message);
        }
    }

    public static void main(String[] args) {
        Subject subject = new Subject();
        User user = new User();
        subject.addObserver(user);
        subject.add("Hello, Observer");
    }

}
