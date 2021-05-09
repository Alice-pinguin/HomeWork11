package Threads;
import java.util.StringJoiner;

public class FizzBuzzAction {
    private int lastNumber;
    private int firstNumber = 1;
    StringJoiner printResult = new StringJoiner(", ");

    public FizzBuzzAction(int lastNumber) {
        this.lastNumber = lastNumber;
    }

    public synchronized void fizz() throws InterruptedException {
        while (firstNumber <= lastNumber) {
            /* если в цикле сравнить лишь одно значение переменной, которое
            равно 3(5), тогда поялвяются проблемы при выводе fizzbuzz,
            вместо него выводится  тогда либо fizz, либо buzz,
            поэтому сравнила 2 переменные
             */
            if (firstNumber % 3 == 0 && firstNumber %5!=0) {
                printResult.add("fizz");
                firstNumber++;
                notifyAll();
            } else {
                wait();
            }
        }
        System.out.println(printResult);
    }
    public synchronized void buzz() throws InterruptedException {
        while (firstNumber <= lastNumber) {
            if (firstNumber % 5 == 0 && firstNumber % 3!= 0) {
                printResult.add("buzz");
                firstNumber++;
                notifyAll();
            } else {
                wait();
            }
        }
    }
    public synchronized void fizzbuzz() throws InterruptedException {
        while (firstNumber <= lastNumber) {
            if (firstNumber % 3 == 0 && firstNumber % 5 == 0) {
                printResult.add("fizzbuzz");
                firstNumber++;
                notifyAll();
            } else {
                wait();
            }
        }
    }
    public synchronized void number() throws InterruptedException {
        while (firstNumber <= lastNumber) {
            if (firstNumber % 3 != 0 && firstNumber % 5 != 0) {
                printResult.add(String.valueOf(firstNumber));
                firstNumber++;
                notifyAll();
            } else {
                wait();
            }
        }
    }
}