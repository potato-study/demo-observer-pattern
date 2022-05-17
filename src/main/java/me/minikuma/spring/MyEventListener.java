package me.minikuma.spring;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventListener implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println("이벤트는 어디서 왔나요 > " + event.getSource());
        System.out.println("이벤트 메시지는? > " + event.getMessage());
    }
}
