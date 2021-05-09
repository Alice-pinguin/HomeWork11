package Threads;

public class Main {
    public static void main(String[] args) {
        Time timer = new Time(10);
        CounterSeconds counterSeconds = new CounterSeconds(timer);
        CounterFiveSeconds counterFiveSec = new CounterFiveSeconds(timer);
        new Thread(counterFiveSec).start();
        new Thread(counterSeconds).start();


    }
}
