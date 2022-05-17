package me.minikuma.java;

public class A implements Observer {

    private final Subject subject;

    // 외부 주입
    public A(Subject subject) {
        this.subject = subject;
        this.subject.registerObserver(this);
    }

    @Override
    public void update(int value) {
        System.out.println("A Class update, value: " + value);
    }
}
