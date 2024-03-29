package ciffar.loaders;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyLoader implements KeyListener {

    private boolean[] keys;
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;
    private boolean bomb;

    public KeyLoader() {
        keys = new boolean[256];
    }

    public void update(){
        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];
        bomb = keys[KeyEvent.VK_SPACE];
    }

    public void keyTyped(KeyEvent e) { }

    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    public boolean isUp() {
        return up;
    }

    public boolean isDown() {
        return down;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isBomb() {
        return bomb;
    }

    public boolean isInUse() {
        return up || down || left || right;
    }
}
