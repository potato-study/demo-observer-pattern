package me.minikuma.inJava;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/**
 * Flow Class 사용하여 Pub/Sub 구현 -> 동기
 */

public class FlowInJava {

    public static void main(String[] args) {
        // publisher
        Flow.Publisher<String> publisher = new Flow.Publisher<String>() {
            @Override
            public void subscribe(Flow.Subscriber<? super String> subscriber) {
                subscriber.onNext("플로우~");
                subscriber.onComplete(); // 메시지 끝
            }
        };

        // subscriber
        Flow.Subscriber<String> subscriber = new Flow.Subscriber<String>() {

            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                // do something!
            }

            @Override
            public void onNext(String item) {
                System.out.println("On Next Call");
                System.out.println("Thread : " + Thread.currentThread().getName());
                System.out.println(item);
            }

            @Override
            public void onError(Throwable throwable) {
                // do something!
            }

            @Override
            public void onComplete() {
                System.out.println("message completed");
            }
        };

        publisher.subscribe(subscriber);

        System.out.println("다 끝났다.....");
    }
}
