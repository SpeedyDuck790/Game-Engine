package Display;

import java.awt.*;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Screen extends JPanel implements Runnable {
    // basic screen dimensions/resolution
    final int ResoScale = 2;
    final int TileSize = 10 * ResoScale;
    final int ScrWidth = TileSize * 80;
    final int ScrHeight = TileSize * 40;

    // constructed screen basics
    public Screen() {
        this.setDoubleBuffered(getFocusTraversalKeysEnabled());
        // this.addKeyListener(keyValue);
        this.setFocusable(true);
        setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(ScrWidth, ScrHeight));
    }

    // page1 child
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

    // Game loop
    int FPS = 60;

    @Override
    public void run() {
        double actionInterval = 1000000000.0 / FPS;
        double nextAction = System.nanoTime() + actionInterval;
        while (Gthread != null) {
            update();
            repaint();
            try {
                double wait = nextAction - System.nanoTime();
                wait = wait / 1000000;
                if (wait < 0) {
                    wait = 0;
                }
                Thread.sleep((long) wait);
                nextAction += actionInterval;
            } catch (Exception e) {
                System.out.println("Error in game loop");
            }
        }
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }

    // Response to IO data
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Painter p = new Painter();
        // painting methods
        p.ComputeTest((Graphics2D) g, TileSize, ScrWidth, ScrHeight);
        p.PTSStartBox((Graphics2D) g, TileSize, ScrWidth, ScrHeight);
    }

    // IO of screen data
    public void update() {
        Updating u = new Updating();
        // update methods
        u.Loading();
        u.WritingNewLoad();
    }

    // thread/start
    Thread Gthread;

    public void startGthread() {
        Gthread = new Thread(this);
        Gthread.start();
    }

}