package me.minikuma.java;

public interface Subject {
    // 등록
    void registerObserver(Observer observer);
    // 해지
    void removeObserver(Observer observer);
    // 알림
    void notifyObserver();
}
