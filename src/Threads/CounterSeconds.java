package Threads;

public class CounterSeconds implements Runnable {
    private Time timer;

   public CounterSeconds(Time timer) {
        this.timer = timer;
    }

    @Override
    public void run() {
        try {
            timer.everySeconds();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

