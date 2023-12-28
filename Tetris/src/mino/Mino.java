package mino;

import java.awt.Color;
import java.awt.Graphics2D;

import main.KeyHandler;

import main.PlayManager;

public class Mino {
    public Block b[] = new Block[4];
    public Block tempB[] = new Block[4];
    public int autoDropCounter = 0;
    public int direction = 1;

    public void create(Color c) {
        b[0] = new Block(c);
        b[1] = new Block(c);
        b[2] = new Block(c);
        b[3] = new Block(c);
        tempB[0] = new Block(c);
        tempB[1] = new Block(c);
        tempB[2] = new Block(c);
        tempB[3] = new Block(c);
    }

    public void setXY(int x, int y) {

    }

    public void updateXY(int Direction) {
        this.direction = Direction;
        for (int i = 0; i < 4; ++i) {
            b[i].x = tempB[i].x;
            b[i].y = tempB[i].y;
        }
    }

    public void getDirection1() {

    }

    public void getDirection2() {

    }

    public void getDirection3() {

    }

    public void getDirection4() {

    }

    public void update() {

        switch (KeyHandler.keyString) {
            case "enter":
                switch (direction) {
                    case 1:
                        getDirection2();
                        break;
                    case 2:
                        getDirection3();
                        break;
                    case 3:
                        getDirection4();
                        break;
                    case 4: 
                        getDirection1();
                        break;
                }
                KeyHandler.keyString = "";
                // autoDropCounter = 0;
                break;
            case "up":
                for (int i = 0; i < 4; i++) {
                b[i].y -= Block.size;
                }
                KeyHandler.keyString = "";
                autoDropCounter = 0;
                break;
            case "down":
                for (int i = 0; i < 4; i++) {
                    b[i].y += Block.size;
                }
                KeyHandler.keyString = "";
                autoDropCounter = 0;
                break;
            case "left":
                for (int i = 0; i < 4; i++) {
                    b[i].x -= Block.size;
                }
                KeyHandler.keyString = "";
                autoDropCounter = 0;
                break;
            case "right":
                for (int i = 0; i < 4; i++) {
                    b[i].x += Block.size;
                }
                KeyHandler.keyString = "";
                autoDropCounter = 0;
                break;
            default:
                break;
        }

        autoDropCounter++;
        if (autoDropCounter == PlayManager.dropInterval) {
            autoDropCounter = 0;
            for (int i = 0; i < 4; i++) {
                b[i].y += Block.size;
            }
        }
    }

    public void draw(Graphics2D g2) {
        int margin = 1;
        g2.setColor(b[0].c);
        for (int i = 0; i < 4; i++) {
            g2.fillRect(b[i].x + margin, b[i].y + margin, Block.size - margin * 2, Block.size - margin * 2);
        }
    }
}
