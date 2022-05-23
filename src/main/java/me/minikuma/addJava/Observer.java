package me.minikuma.addJava;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

/**
 * iterator ------ observable (duality)
 */
@SuppressWarnings("deprecation")
public class Observer {

    public static void main(String[] args) {
        List<Integer> items = Arrays.asList(1, 2, 3, 4, 5, 7, 8, 9, 10);

        for (Integer i : items) {
            System.out.println(i);
        }
        System.out.println("======");

        for (Iterator<Integer> iter = items.iterator();iter.hasNext();) {
            System.out.println(iter.next());
        }

        System.out.println("======");

        // 나만의 Observer 만들기
        IntObservable ob = new IntObservable();

        java.util.Observer observer = new java.util.Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println(arg);
            }
        };

        ob.addObserver(observer); // 옵저버 등록
        ob.run(); // 옵저버 실행
    }
}
class IntObservable extends Observable implements Runnable {

    @Override
    public void run() {
        List<Integer> items = Arrays.asList(1, 2, 3, 4, 5, 7, 8, 9, 10);

        for (Integer item : items) {
            setChanged();
            notifyObservers(item); // notify
        }
    }
}
