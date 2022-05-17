package me.minikuma.java;

public class B implements Observer {

    private final Subject subject;

    public B(Subject subject) {
        this.subject = subject;
        this.subject.registerObserver(this);
    }

    @Override
    public void update(int value) {
        System.out.println("B Class update, value: " + value);
    }
}
