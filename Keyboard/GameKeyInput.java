package Keyboard;

import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Characters.Movement;

public class GameKeyInput implements KeyListener {

    public boolean W, A, S, D;
    Movement Move = new Movement();

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int Key = e.getKeyCode();

        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                System.out.println("W");
                Move.Up();
                W = true;
                break;
            case KeyEvent.VK_A:
                System.out.println("A");
                Move.Left();
                A = true;
                break;
            case KeyEvent.VK_S:
                System.out.println("S");
                Move.Down();
                S = true;
                break;
            case KeyEvent.VK_D:
                System.out.println("D");
                Move.Right();
                D = true;
                break;
            default:
                System.out.println("NA");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        // int Key = e.getKeyCode();
        // if (Key == KeyEvent.VK_W) {
        // W = false;
        // }
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                W = false;
                break;
            case KeyEvent.VK_A:
                A = false;
                break;
            case KeyEvent.VK_S:
                S = false;
                break;
            case KeyEvent.VK_D:
                D = false;
                break;
            default:
                break;

        }

    }
}