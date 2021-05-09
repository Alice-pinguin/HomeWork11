package Threads;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        FizzBuzzAction fizzBuzzAction = new FizzBuzzAction(22);
        Thread threadA = new Thread(() -> {
            try {
                fizzBuzzAction.fizz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread threadB = new Thread(() -> {
            try {
                fizzBuzzAction.buzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread threadC = new Thread(() -> {
            try {
                fizzBuzzAction.fizzbuzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread threadD = new Thread(() -> {
            try {
                fizzBuzzAction.number();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        for (Thread thread : Arrays.asList(threadA, threadB, threadC, threadD)) {
            thread.start();
        }

    }
}



