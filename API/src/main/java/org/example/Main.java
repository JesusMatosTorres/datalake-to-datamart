package org.example;

import org.example.api.WebService;

public class Main {
    public static void main(String[] args) {
        WebService webService = new WebService();
        webService.start();
    }
}