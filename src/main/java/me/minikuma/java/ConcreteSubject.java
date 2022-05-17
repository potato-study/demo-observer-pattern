package me.minikuma.java;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject {

    private static final List<Observer> observerList = new ArrayList<>();
    private int value;

    public ConcreteSubject() {
        this.value = 0; // 0 으로 초기화
    }

    public void setValue(int value) {
        this.value = value;
        notifyObserver();
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        observerList.forEach(o -> {
            o.update(value);
        });
    }
}
