package Display;

import java.awt.*;

public class Painter {
    public void ComputeTest(Graphics2D g, int TileSize, int ScrWidth, int ScrHeight) {
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

    public void PTSStartBox(Graphics2D g, int TileSize, int ScrWidth, int ScrHeight) {
        Graphics2D Box = (Graphics2D) g;
        Box.setColor(Color.WHITE);
        Box.fillRect(ScrWidth / 2 - TileSize / 2, ScrHeight / 2 - TileSize / 2, 4 * TileSize, 4 * TileSize);

    }
}
