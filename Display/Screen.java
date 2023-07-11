package Display;

import javax.swing.JPanel;

public class Screen extends JPanel implements Runnable {

    public Screen() {
        System.out.println("Screen.Screen()");
    }

    @Override
    public void run() {
        update();
        paintComponent();
    }

    public void paintComponent() {
        Painter p = new Painter();
        p.OItest();
    }

    public void update() {
        Updating u = new Updating();
        u.OItest();
    }

    // thread
    Thread Gthread;

    // start method
    public void startGthread() {
        Gthread = new Thread(this);
        Gthread.start();
    }

}