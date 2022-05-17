package me.minikuma.java;

public class Client {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        A aClass = new A(subject);
        B bClass = new B(subject);
        subject.setValue(10);
    }
}
