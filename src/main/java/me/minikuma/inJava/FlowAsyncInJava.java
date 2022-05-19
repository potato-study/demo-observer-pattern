package me.minikuma.inJava;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
/**
    Flow Class 사용 하여 Pub/Sub 구현 -> 비동기
 */

public class FlowAsyncInJava {
    public static void main(String[] args) throws InterruptedException {

        Flow.Publisher<String> publisher = new SubmissionPublisher<>();

        Flow.Subscriber<String> subscriber = new Flow.Subscriber<String>() {

            private Flow.Subscription subscription;

            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                System.out.println("구독");
                this.subscription = subscription;
                this.subscription.request(1);
            }

            @Override
            public void onNext(String item) {
                System.out.println("onNext 호출");
                System.out.println("스레드: " + Thread.currentThread().getName());
                System.out.println("메시지 : " + item);
                this.subscription.request(1); // back presser
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {
                System.out.println("Completed");
            }
        };

        publisher.subscribe(subscriber);

        ((SubmissionPublisher)publisher).submit("Hello");

        System.out.println("먼저 출력 될수도...");

        Thread.sleep(100);
    }
}
