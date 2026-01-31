package com.guvi.spring_boot_intro.notify;

public interface Notifier {
    // TODO: understand why notifier is an interface.
    void send(String to, String message);
}
