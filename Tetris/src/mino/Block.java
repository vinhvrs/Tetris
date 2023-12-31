package mino;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Block {
    public int x, y;
    public static final int size = 30;
    public Color c;

    public Block(Color c){
        this.c = c;
    }

    public void draw(Graphics2D g2){
        int margin = 1;
        g2.setColor(c);
        g2.fillRect(x, y, size, size);
    }


    
}
