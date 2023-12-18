public class Timer {

    public static void main(String[] args) {
        // Creating a daemon thread for the timer
        TimerThread timerThread = new TimerThread();
        timerThread.setDaemon(true);
        timerThread.start();
        
        // Main thread doing some other tasks
        for (int i = 1; i <= 10; i++) {
            System.out.println("Main thread doing task #" + i);
            //Simulate some work
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        
    }

    static class TimerThread extends Thread {
        @Override
        public void run() {
            // Daemon thread periodically printing a message
            for (int i = 1; i <= 6; i++) {
                System.out.println("Daemon thread printing message every 2 second later #" + i);
                // Simulate some work
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
