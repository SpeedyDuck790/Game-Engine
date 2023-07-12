package Display;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Screen extends JPanel implements Runnable {

    final int ResoScale = 2;

    final int TileSize = 10 * ResoScale; // 10x10
    final int ScrWidth = TileSize * 80;
    final int ScrHeight = TileSize * 40;

    public Screen() {
        this.setPreferredSize(new Dimension(ScrWidth, ScrHeight));
        this.setDoubleBuffered(getFocusTraversalKeysEnabled());
        // this.addKeyListener(keyValue);
        this.setFocusable(true);
        setBackground(Color.BLACK);
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

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D space = (Graphics2D) g;
        space.setColor(Color.BLUE);
        space.fillRect(0, 0, TileSize, TileSize);
        space.setColor(Color.RED);
        space.fillRect(ScrWidth - TileSize, ScrHeight - TileSize, TileSize, TileSize);
        space.setColor(Color.GREEN);
        space.fillRect(ScrWidth - TileSize, 0, TileSize, TileSize);
        space.setColor(Color.YELLOW);
        space.fillRect(0, ScrHeight - TileSize, TileSize, TileSize);
        space.setColor(Color.WHITE);
        space.fillRect(ScrWidth / 2 - TileSize / 2, ScrHeight / 2 - TileSize / 2, TileSize, TileSize);

    }

    int i = 0;

    public void update() {
        Updating u = new Updating();
        System.out.println("File Log");
        String content = "";
        try (Scanner reader = new Scanner(new File("PlayerData/save1.txt"))) {
            while (reader.hasNextLine()) {
                content += reader.nextLine();
            }
            String[] GameData = content.split("#");
            System.out.println("PlayerData: " + GameData[0]);
            System.out.println("PlayerData: " + GameData[1]);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Reading failed");
        }
        try (FileWriter writer = new FileWriter("PlayerData/save1.txt")) {
            writer.write("PlayerData:write#" + i);
            i++;
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Writing failed");
        }
    }

    // thread
    Thread Gthread;

    // start method
    public void startGthread() {
        Gthread = new Thread(this);
        Gthread.start();
    }

}