package org.example;

import org.example.view.UI;

public class Main {
    public static void main(String[] args) {
        UI myInterface = new UI();
        myInterface.load();
        myInterface.start();
    }
}