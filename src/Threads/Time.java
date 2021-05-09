package Threads;

public class Time {
    private int second;
    private int counter = 1;

    public Time(int second) {
        this.second = second;
    }
    public synchronized void everySeconds() throws InterruptedException {
        while (second > 0) {
            Thread.sleep(1000);
            /*можно поток не усыплять,
            но без этого не выполняется условия задачи
            о ежесекундом оповещении
             */
            System.out.println("Pass - "+counter +" seconds.");
            counter++;
            second--;
            notifyAll();
            while (counter % 5 == 0) {
               Thread.sleep(1000);
                System.out.println("Pass - 5 seconds "+counter+".");
                if (second <= 0) {
                    break;
                }
                wait();
            }
        }
        System.out.println("The program is over at " + (counter -1) + " seconds.");
    }
    public synchronized void every5Seconds() throws InterruptedException {
        while (second > 0) {
            while (counter % 5 != 0) {
                if (second <= 0) {
                    break;
                }
                wait();
            }
            if (second > 0) {
                System.out.println("5 seconds passed!!!");
                counter++;
                second--;
                notifyAll();
            }
        }
    }
}

