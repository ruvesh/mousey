package io.github.ruvesh.mousey.process;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;


public class MouseMoverProcess implements Runnable {
    private static final Logger log = LoggerFactory.getLogger(MouseMoverProcess.class);

    private final int delay;
    private final AtomicBoolean running = new AtomicBoolean(false);

    public MouseMoverProcess(int delay) {
        this.delay = delay;
    }

    public void start() {
        Thread worker = new Thread(this);
        worker.start();
    }

    public void stop() {
        running.set(false);
    }

    @Override
    public void run() {
        running.set(true);
        try {
            Robot mouseBot = new Robot();
            mouseBot.mouseMove(
                    (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2,
                    (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2
            );
            Random random = new Random();
            while (running.get()){
                mouseBot.mouseMove(random.nextInt(500), random.nextInt(500));
                Thread.sleep(this.delay * 1000L);
            }
        }
        catch (AWTException e) {
            log.error("Exception occurred", e);
            Thread.currentThread().interrupt();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread was interrupted, Failed to complete operation");
        }
    }
}
