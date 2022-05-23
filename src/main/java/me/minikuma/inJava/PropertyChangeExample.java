package me.minikuma.inJava;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * 권장
 */
public class PropertyChangeExample {
    static class User implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            System.out.println(evt.getNewValue());
        }
    }

    static class Subject {
        PropertyChangeSupport support = new PropertyChangeSupport(this);

        // 등록
        public void addObserver(PropertyChangeListener observer) {
            support.addPropertyChangeListener(observer);
        }

        // 해지
        public void removeObserver(PropertyChangeListener observer) {
            support.removePropertyChangeListener(observer);
        }

        public void add(String message) {
            support.firePropertyChange("event", null, message);
        }
    }

    public static void main(String[] args) {
        Subject subject = new Subject();
        User observer = new User();
        subject.addObserver(observer); // 옵저버 등록
        subject.add("옵저버~~");
        subject.removeObserver(observer); // 옵저버 등록 제거
        subject.add("패턴~~ 메시지 없어유~");
    }

}
