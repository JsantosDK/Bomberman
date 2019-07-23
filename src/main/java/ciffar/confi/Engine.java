package ciffar.confi;

public class Engine implements Runnable {

    private Thread thread;
    private boolean running;
    private WindowCanvas windowCanvas;

    public void run() {
        int FPS = 60;
        double timeUntilUpdate = 1000000000 / FPS;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timeUntilUpdate;
            lastTime = now;

            if (delta >= 1) {
                windowCanvas.update();
                windowCanvas.render();
                delta--;
                System.out.println("test");
            }
        }
    }

    public synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!running) {
            return;
        }
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setWindowCanvas(WindowCanvas windowCanvas) {
        this.windowCanvas = windowCanvas;
    }
}
