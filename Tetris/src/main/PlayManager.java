package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import mino.*;

public class PlayManager {
    // Game Play Area
    final int WIDTH = 360;
    final int HEIGHT = 600;
    public static int left_x;
    public static int right_x;
    public static int top_y;
    public static int bottom_y;

     //Minos
    Mino currentMino;
    final int Mino_Start_X;
    final int Mino_Start_Y;

    public static final int dropInterval = 60;



    public PlayManager() {
        left_x = (GamePanel.WIDTH - WIDTH) / 2;
        right_x = left_x + WIDTH;
        top_y = 50;
        bottom_y = top_y + HEIGHT;

        Mino_Start_X = left_x + WIDTH / 2 - Block.size;
        Mino_Start_Y = top_y + Block.size;

        currentMino = new Mino_Z2();
        currentMino.setXY(Mino_Start_X, Mino_Start_Y);
    }

    public void update() {
        currentMino.update();
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(4f));
        g2.drawRect(left_x - 4, top_y - 4, WIDTH + 8, HEIGHT + 8);

        int x = right_x + 100;
        int y = bottom_y - 200;
        g2.drawRect(x, y, 200, 200);

        g2.setFont(new Font("Arial", Font.PLAIN, 30));
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.drawString("NEXT", x + 60, y + 60);

        if (currentMino != null) {
            currentMino.draw(g2);
        }
    }

}
