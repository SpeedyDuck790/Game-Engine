package Display;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Screen extends JPanel implements Runnable {

    final int ResoScale = 5;

    final int TileSize = 10 * ResoScale; // 10x10
    final int ScrWidth = TileSize * 80;
    final int ScrHeight = TileSize * 40;

    public Screen() {
        this.setSize(ScrWidth, ScrHeight);
        this.setDoubleBuffered(getFocusTraversalKeysEnabled());
        // this.addKeyListener(keyValue);
        this.setFocusable(true);
    }

    public static void Startpg() {
        JFrame Screen = new JFrame();
        Screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Screen.setResizable(false);
        Screen.setTitle("2D Game Engine");
        Screen Startpg = new Screen();
        Screen.add(Startpg);

        Screen.pack();
        Screen.setLocationRelativeTo(null);
        Screen.setVisible(true);

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