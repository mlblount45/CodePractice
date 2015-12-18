package com.blountmarquis;

public class Main {
    public static void main(String[] args) {
        MouseMover mouseMover = new MouseMover();
        Thread thread = new Thread(mouseMover);
        thread.start();

    }
}
