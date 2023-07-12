package Characters;

import Display.Painter;

public class Movement {

    Painter Paint = new Painter();

    int y = Paint.Locationy();
    int x = Paint.Locationx();

    public void Up() {
        System.out.println("Up");
        y += 10;
        Paint.SetLocation(x, y);
        System.out.println("x: " + x + " y: " + y);
    }

    public void Down() {
        System.out.println("Down");
        y -= 10;
        Paint.SetLocation(x, y);
        System.out.println("x: " + x + " y: " + y);
    }

    public void Left() {
        System.out.println("Left");
        x -= 10;
        Paint.SetLocation(x, y);
        System.out.println("x: " + x + " y: " + y);
    }

    public void Right() {
        System.out.println("Right");
        x += 10;
        Paint.SetLocation(x, y);
        System.out.println("x: " + x + " y: " + y);
    }
}
