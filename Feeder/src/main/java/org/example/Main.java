package org.example;

import org.example.scrapper.controller;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) throws IOException {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                controller controller = new controller();
                try {
                    controller.controller();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        timer.schedule(task, 0, 60*60*1000);
    }
}