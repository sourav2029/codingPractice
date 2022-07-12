package com.sourav.guava.eventbus;

import com.google.common.eventbus.Subscribe;

public class EventListener {
    private static int eventHandled;

    @Subscribe
    public void stringEvent(String event) {
        System.out.println("Handle Event : " + event);
        eventHandled++;
    }

}
