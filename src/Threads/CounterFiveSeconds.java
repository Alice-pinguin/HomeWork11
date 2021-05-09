package Threads;

public class CounterFiveSeconds implements Runnable {
        private Time timer;

   public CounterFiveSeconds(Time timer) {
            this.timer = timer;
        }

        @Override
        public void run() {
            try {
                timer.every5Seconds();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
